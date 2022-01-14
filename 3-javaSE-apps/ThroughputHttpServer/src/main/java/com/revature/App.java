package com.revature;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;///nio stands for non-blocking io. A thread can ask a channel to read data into a buffer, while the channel reads to buffer the thread can do something else
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.*;


public class App {
	private static final int NUMBER_OF_THREADS = 4;
	
	//Saving the entire file to a string
	private static final String INPUT_FILE = "C:\\Users\\haugh\\Documents\\Work\\Revature\\Projects and Demos\\demos\\3-javaSE-apps\\ThroughputHttpServer\\src\\main\\resources\\war_and_peace.txt";
	
	public static void main(String[] args) throws IOException {
		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
		startServer(text);
	}
	
	public static void startServer(String text) throws IOException{
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		server.createContext("/search", new WordCountHandler(text));
		
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		server.setExecutor(executor);//Other frameworks like spark can't customize like this
		
		server.start();
	}
	
	public static class WordCountHandler implements HttpHandler {

		private String text;
		
		
		public WordCountHandler(String text) {
			
			this.text = text;
			
		}
		
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			// here we will send back a response based on how many times we find the requested word that was sent in the Http Request parameter
			String query = httpExchange.getRequestURI().getQuery();
			
			String[] keyValuePair = query.split("=");
			String action = keyValuePair[0];
			String word = keyValuePair[1];
			
			if (!action.equals("word") ) {
				httpExchange.sendResponseHeaders(400, 0);
				return;
			}
			
			String count = countWord(word);
			
			byte[] response = count.getBytes();
			
			httpExchange.sendResponseHeaders(200, response.length);
			
			OutputStream outputStream = httpExchange.getResponseBody();
			
			outputStream.write(response);
			
			outputStream.close();
		
	}
		
		private String countWord(String word) {
			System.out.println("Counting method triggered");
			
			int count = 0;
			int index = 0;
			
			while (index >= 0) {
				index = text.indexOf(word, index);
				
				if (index >= 0) {
					count++;
					index++;
				}
			}
			
			return "The word "+word+" appears "+count+" times.";
			
		}

	}
}