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

public class Application {
	
	// we need to point to the location of the file we're going to read from
	private static final String INPUT_FILE = "C:\\Users\\kphu\\Desktop\\projects\\demos\\3-JavaSE-apis\\ThroughputHttpServer\\src\\main\\resources\\war_and_peace.txt";
	
	private static final int NUMBER_OF_THREADS = 4;
	
	
	public static void main(String[] args) throws IOException {
		
		// Save the entire content of the file to a String object
		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
		// Non-Blocking IO 
		
		// we will start our http server
		startServer(text);
	}

	// start server()
	public static void startServer(String text) throws IOException {
		
		/**
		 * Create start server method by calling HttpServer.create()method.
		 * 
		 * 1st param: takes address of our localhost and port we want to listen on from com.sun.net package
		 * in the form of SocketAddress object.
		 * 
		 * 2nd param: backlog size which is size of queue for http server requests. We keep it at 0
		 * because all requests should end up in the thread pool queue instead
		 */
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		/**
		 * Create a context which assigns a handler object to a specifi http
		 * route. THIs handler handles each incoming http request and sends a response.
		 * Client can send requests to http://localhoast:8000/search -> trigger a method inside of our application
		 */
		server.createContext("/search", new WordCountHandler(text));
		
		/**
		 * Executor schedules each incoming http request to a pool of threads which will handle those requests.
		 */
		
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		/**
		 * pass the exxecutor object to the server
		 * This is why we're using HttpServer from the com.out.net.httpServer because we can pass that executor object.
		 */
		
		server.setExecutor(executor); // other frameworks like Spark Web MIcroframework
		
		server.start();
	}
	
	public static class WordCountHandler implements HttpHandler {
		
		private String text;
		
		public WordCountHandler(String text) {
			this.text = text;
		}
		
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			// we will send a response based on how many times we will find the requested word in the HttpRequest parameter
			
			String query = httpExchange.getRequestURI().getQuery();
			// the above method will return word=talk from the request: http://localhost:8000/search?word=talk
			// URL = Uniform Resource Locator
			// URI = Uniform Resource Identifier
			String[] keyValuePair = query.split("=");
			String action = keyValuePair[0];
			String word = keyValuePair[1];
			
			// check that the param key is correct
			if (!action.equals("word")) {
				// if the URL query parameters, are malformed, sned back naa
				httpExchange.sendResponseHeaders(400,0); // this returns an HTTP response with a Status code of 400, meaning client side error
				return;
			}
			// create some  method that counts how many times the word is featured in the text:
			
			// call method here and
			String count = countWord(word); // "The word ____ appeared __ times"
			
			// we need to convert our String object to something that we can send back in an HttpResponse
			byte[] response = count.getBytes();
			httpExchange.sendResponseHeaders(200, response.length); // the length of the response body
			
			// represent the response body as an OutputStream
			OutputStream outputStream = httpExchange.getResponseBody();
			
			// .write the outputstream to 
			outputStream.write(response);
			
			// close it!
			outputStream.close();
			
		}
		
		
		// returns a phrase (String) recountin ghow many times a word appeared in the book
		private String countWord(String word) {
			
			System.out.println("countWOrd() method triggered!");
			
			int count = 0;
			int index = 0;
			
			// Run some loop that will check for every appearance of the word passed through
			
			// we're using the index (which we'll increment each time to capture exactly
			// where the word appeared so we don't repeat ourselves
			
			while (index >=0) {
				// text is a String Object that holds the entirety of War & Peace
				index = text.indexOf(word, index);
				if (index >= 0) {
					count++;
					index++;
				}
			}	
			
			// this will be returned with the handle() method
			return " The word " + word + " appeared " + count + "times";
		}
		
	}
}
