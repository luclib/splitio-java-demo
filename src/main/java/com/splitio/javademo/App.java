package com.splitio.javademo;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;
import io.split.client.SplitClient;
import io.split.client.SplitClientConfig;
import io.split.client.SplitFactory;
import io.split.client.SplitFactoryBuilder;

public class App 
{	
    public static void main( String[] args )
    {
    	final File file = new File(".\\src\\main\\java\\com\\splitio\\javademo\\sample.txt");
    	
    	final SplitClientConfig config;
    	final SplitClient client;
    	final String treatment;
    	final SplitFactory splitFactory;
    	
    	System.out.print("Welcome to the split demo\n");
    	try {
    		
    		// Set up the scanner and timer
    		Scanner scan = new Scanner(file);
    		
    		// Set up the SDK.
    		config= SplitClientConfig.builder()
    				.setBlockUntilReadyTimeout(10000)
    				.build();
    		
    		splitFactory = SplitFactoryBuilder.build("1ho5d5ncnr4p272d5j7o32h5vnpa2m382ggo", config);
    		client = splitFactory.client();
    		
    		client.blockUntilReady();
        	
        	// Get the Split treatment
        	treatment = client.getTreatment("key", "java-split-demo");
        	
    		System.out.println("Treatment is set to: " + treatment);
        	System.out.println("\nPrinting...\n");
        	
        	switch(treatment) {
	        	case "on":
	        		while(scan.hasNext()) {
	        			System.out.println(scan.nextLine());
	        		}	
	        		break;
	        	case "off":
	        	default:
	        		break;
        	}	
        	
    	}catch (Exception ex) {
    		System.out.println("Error: " + ex.getClass());
    		System.out.println(ex.getMessage());
    		System.out.println("Stack trace: " + ex.getStackTrace());
    	} 

    	
    }
}
