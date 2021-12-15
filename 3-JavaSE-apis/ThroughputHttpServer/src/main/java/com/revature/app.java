package com.revature;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class app {

	private static final String INPUT_FILE = "C:\\Users\\somer\\projects\\demos\\3-JavaSE-apis\\ThroughputHttpServer\\src\\main\\resources\\war_and_peace.txt";

	private static final int NUMBER_OF_THREADS = 1;
	
	
	
	public static void main(String[] args) throws IOException {
		
		// we will start our HTTP server
		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
		
		startServer(text);
	}
	
	// startServer()
	
	public static void startServer(String text) throws IOException {
		// new fashioned way Spark Java Microframework
		
		// old way with the old networking packages included in the JDK
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		// a client can send requests to http://localhost:8000/search -> trigger a method
		
		server.createContext("/search", new WordCountHandler(text));
		
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		server.setExecutor(executor); // other frameworks like Spark web microframework
		
		server.start();
		

	}
	
	public static class WordCountHandler implements HttpHandler {
		private String text;
		
		public WordCountHandler(String text) {
			this.text = text;
		}
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			// here we will send back a response based on how many times we find the requested word in the http request parameter
			String query = httpExchange.getRequestURI().getQuery();
			
			String[] keyValuePair = query.split("=");
			String action = keyValuePair[0];
			String word = keyValuePair[1];
			
			if (!action.equals("word")) {
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
			System.out.println("countWord() method triggered!!!");
			int count = 0;
			int index = 0;
			
			while (index >= 0) {
				index = text.indexOf(word, index);
				
				if (index >= 0) {
					count++;
					index++;
				}
			}
			return " the word " + word + " appeared " + count + " times.";
		}
	}

}
