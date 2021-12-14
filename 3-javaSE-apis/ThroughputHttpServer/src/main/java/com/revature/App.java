package com.revature;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.*;

public class App {
	
	// we need to point to the location of the file we're going top read from
	private static final String INPUT_FILE = "C:\\Users\\SophieGavrila\\Desktop\\demos\\3-javaSE-apis\\ThroughputHttpServer\\src\\main\\resources\\war_and_peace.txt";

	
	public static void main(String[] args) {

		// we will start our HTTP server
		
	}
	
	// startServer()
	public static void startServer(String text) throws IOException {
		
		// New way is with Spark Java MicroFramework 
		
		// Old way with the old networking packages included in the JDK
		// We are going to control the HttpRequest queue by managing it in a thread pool that we create
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		// a client can send requests to http://localhost:8000/search -> trigger a method inside of our application
		server.createContext("/search", new WordCountHandler(text));
		
		Executor executor = Executors.newFixedThreadPool(4);
		
		server.setExecutor(executor);
		
		server.start();
	}
	
	public static class WordCountHandler implements HttpHandler {

		private String text;
		
		
		public WordCountHandler(String text) {
			
			this.text = text;
			
		}
		
		@Override
		public void handle(HttpExchange arg0) throws IOException {
			// here we will send back a response based on how many times we find the requested word that was sent in the Http Request parameter
			
		}
		
	}

}
