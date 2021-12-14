package com.revature;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Application {
	
	// we need to point to the location of the file we're going to read from
	private static final String INPUT_FILE = "src\\main\\resources\\war_and_peace.text";
	
	
	
	public static void main(String[] args) {
		
		// we will start our http server

	}

	// start server()
	public static void startServer(String text) throws IOException {
	
		// New way Spark Java MicroFramework
		
		// Old Way with the old networking packages included in the JDK
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
		public void handle(HttpExchange exchange) throws IOException {
			// we will send a response based on how many times we will find the requested word in the HttpRequest parameter
				
		}
		
	}
}
