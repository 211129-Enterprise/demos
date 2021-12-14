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
	
	// we need to point to the location of the file we're going top read from
	private static final String INPUT_FILE = "C:\\Users\\SophieGavrila\\Desktop\\demos\\3-javaSE-apis\\ThroughputHttpServer\\src\\main\\resources\\war_and_peace.txt";
	
	private static final int NUMBER_OF_THREADS = 4;

	
	public static void main(String[] args) throws IOException {

		// Save the entire content of the file to a String object
		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
		// Non-NBlocking IO 
		// https://www.geeksforgeeks.org/introduction-to-java-nio-with-examples/#:~:text=Java%20NIO%20is%20a%20buffer,of%20the%20other%20NIO%20packages.
		
		
		// we will start our HTTP server
		startServer(text);
		
	}
	
	// startServer()
	public static void startServer(String text) throws IOException {
		
		/** Create start server method by calling HttpServer.create() method.
		 * 
		 * 1st param: Takes address of our localhost an port we want to listen on from
		 * com.sun.net package in the form of SocketAddress object.
		 * 
		 * 2nd param is backlog size which is size of queue for HTTP server requests. We
		 * keep it at 0 because all requests should end up in the thread pool queue
		 * instead
		 */
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		/**
		 * Create a context which assigns a handler object to a specific http
		 * route. This handler handles each incoming http request and sends a response.
		 * client can send requests to http://localhost:8000/search -> trigger a method inside of our application
		 */
		server.createContext("/search", new WordCountHandler(text));
		
		
		/**
		 * Executor schedules each incoming HTTP request to a pool of threads which will handle those requests.
		 */
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		// pass the executor object to the server
		// This is why we're using HttpServer from the com.sun.net.httpServer because we can pass that executor object
		server.setExecutor(executor); // other oframeworks like Spark Web Microframework 
		
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
			// the above method will return word=talk from the request: http://localhost:8000/search?word=talk
			
			// word=talk we need to split "talk" from word AND we need to make sure we received "word" as
			// URL universal resource locator
			// URI universal resource identifier
			
			String[] keyValuePair = query.split("="); // creates String array like this: ["word", "talk"]
			String action = keyValuePair[0];
			String word = keyValuePair[1]; // this is value we pass to countWord()
			
			// check that the qery param key is correct
			if (!action.equals("word")) {
				// if the URL query parameters are malformed, send back an error message
				httpExchange.sendResponseHeaders(400, 0); // this returns an HTTP response with a STATUS code of 400, meaning client side error
				return;
			}
			
			// create some method that counts how many times the word is featured is featured in the text:
			
			//call that method here and
			String count = countWord(word); // "The word ____ appeared __ times"
			
			// we need to convert our String object to something that we can send back in an HttpResponse
			byte[] response = count.getBytes();
			// the first arg is the status code we're sending 
			httpExchange.sendResponseHeaders(200, response.length); // the length of the reponse body is the 2nd param
			
			// represent the reposne body as an OutputStream
			OutputStream outputStream =  httpExchange.getResponseBody();
			
			// .write() the the outputstream
			outputStream.write(response);
			
			// close it!
			outputStream.close();
			
			
		}
		
		// returns a phrase (String) recounting how many times a word appeared in the book text
		private String countWord(String word) {
			
			System.out.println("countWord() method triggered!!!");
			
			int count = 0;
			int index = 0;
			
			// Run some loop that will check for every appearance of the word passed thru
			// we're using the index (which we'll increment each time to capture exactly where the word appeared so we don't repeat ourselves.
			while (index >= 0) {
				
				// text os a String object that holds the entirete of war & peace.txt
				index = text.indexOf(word, index);
				
				// if hte index is positive, we found the word in the book
				if (index >= 0) {
					count++;
					index++;	
				}
			}
			
			// this will be returnedd within the handle() method
			return " The word " + word + " appeared " + count + " times.";
		}
		
	}
}
