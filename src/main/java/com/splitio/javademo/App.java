package com.splitio.javademo;
import io.split.client.SplitFactoryBuilder;

import java.util.concurrent.TimeoutException;

import io.split.client.SplitClient;
import io.split.client.SplitClientConfig;
import io.split.client.SplitFactory;


public class App 
{	
    public static void main( String[] args )
    {
    	
    	System.out.print("Welcome to the split demo\n");
    	try {
    		// Set up the SDK.
    		SplitClientConfig config= SplitClientConfig.builder()
    				.setBlockUntilReadyTimeout(10000)
    				.build();
    		
    		SplitFactory splitFactory = SplitFactoryBuilder.build("YOUR_API_KEY", config);
    		SplitClient client = splitFactory.client();
    		
    		client.blockUntilReady();
    		
        	
        	// Get the Split treatment
        	String treatment = client.getTreatment("key", "SPLIT_NAME");
        	
        	switch(treatment) {
	        	case "off":
	        		break;
	        	case "on":
	        	default:
	        		break;
        	}
        	
        	
    	}catch (Exception ex) {
    		System.out.println("Error " + ex.getClass());
    		System.out.println(ex.getMessage());
    	} 

    	
    }
}
