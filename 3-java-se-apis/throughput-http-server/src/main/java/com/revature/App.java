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

public class App {
	
	// We'll need to point to the location of the file we're going to read from
	private static final String INPUT_FILE = "/Users/cosmos/Documents/Revature/demos/3-java-se-apis/throughput-http-server/src/main/resources/war_and_peace.txt";

	private static final int NUMBER_OF_THREADS = 4;

	
	
	public static void main(String[] args) throws IOException {
		
		// Save the entire content of the file to a String object
		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
		// Non-blocking IO
		// 
		//
		System.out.println("Launching server...");
		
		// We will start our HTTP server
		startServer(text);

	}
	
	
	
	
	
	// startServer()
	public static void startServer(String text) throws IOException {
		
		// Newer way would be Spark Java Microframework
		// but...		
		// Old fashion way is using old networking packages
		// that are included in the JDK like:
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0); // port is 8000 and 0 specifies backlog size
		// We are going to control the HttpRequest queque by managing it in a thread pool that we create.
		// Hence why we specified the backlog size as 0 above.
		/** Create start server method by calling HttpServer.create() method.
		 * 
		 * 1st param: Takes address of our localhost an port we want to listen on from
		 * com.sun.net package in the form of SocketAddress object.
		 * 
		 * 2nd param is backlog size which is size of queue for HTTP server requests. We
		 * keep it at 0 because all requests should end up in the thread pool queue
		 * instead
		 */
		
		
		
		/**
		 * Create a context which assigns a handler object to a specific http
		 * route. This handler handles each incoming http request and sends a response.
		 * client can send requests to http://localhost:8000/search -> trigger a method inside of our application
		 */
		server.createContext("/search", new WordCountHandler(text));
		
		
		/**
		 *  Executor schedules each incoming HTTP request to a pool of threas which 
		 *  will handle those requests.  
		 */
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		
		/**
		 *  Pass the executor object to the server
		 *  This is why we're using HTTP Server from the com.sun.net.httpServer because we
		 *  can pass that exeutor to the object.
		 *  Other frameworks like SPark Web Microframework won't allow us to.
		 */
		server.setExecutor(executor);
		
		server.start();
		
	}

	
	
	
	
	public static class WordCountHandler implements HttpHandler {
		
		private String text;
		
		
		
		public WordCountHandler(String text) {
			this.text = text;
		}

		
		
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			// We'll send back a response based on how many times we find
			// the requested word that was sent in the Http Request
			// parameter.
			
			// Here we can examine requests and handle them...
			
			String query = httpExchange.getRequestURI().getQuery();
			// The above will return "word=talk" from "http://localhost:8000/search?word=talk"
			// From, "word=talk" we need to extract "talk" from "word=" AND we need to make sure
			// that we received "word" as our key
			//
			// URL = Uniform Resource Locator (method and location)
			// URI = Uniform Resource Identifier (Method, location, and resource)
			// Technical difference is that URI encompases more
			
			String[] keyValuePair = query.split("="); // Create String array like this: ["word", "talk"]
			String action = keyValuePair[0];
			String word = keyValuePair[1]; // This is the value we pass to countWord()

			// Check that the query param key is correct
			if (!action.equals("word")) {
				// If the URL query parameters are malformed, send back an error message.
				httpExchange.sendResponseHeaders(400, 0); // This returns an HTTP response with a status code
															// of 400 meaning client side error.
				return;
			}
				
			//Create some method that counts how many times the word is featured in the text
			// Call that method here and
			String count = countWord(word); // "The word ___ appeared __ times"
			
			// We need to convert our String object to something we can send back in
			// an HTTP response.
			byte[] response = count.getBytes();
			httpExchange.sendResponseHeaders(200, response.length); // Params = HTTP code and length of response (technically we're serializing here)
			
			// Represent the response body as an OutputStream
			OutputStream outputStream =  httpExchange.getResponseBody();
			
			// Write the output stream
			outputStream.write(response);
			
			// Close it!
			outputStream.close();
			
			
			
		}
		
		
		
		
		/**
		 * Returns a phrase (String) recounting how many times a word appeared in
		 * the book text.
		 */
		private String countWord(String word) {
			System.out.println("countWord() method triggered");
			
			int count = 0;
			int index = 0;
			
			// Run some loop that will check for every appearance of the word passed through.
			// We're using the index, which we'll increment each time to capture exactly where the word appeared so we don't repeat ourselves.
			while( index >= 0) {
				
				// Text is a string object that holds the entirety of war_and_peace.txt
				index = text.indexOf(word, index);
				
				// If the index is positive, we found the word in the book.
				if(index >= 0) {
					
					count++;
					index++;
					
				}
			}
			
			// This will be returned within the handle() method
			return "The word " + word + " appeared " + count + " times.";
		}
		
	}
	
}

