package com.siva.work.webservice.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;


public class ConversionServiceClient {
	 static final String REST_URI = "http://localhost:8080/RESTfulWebServiceExample";
	 static final String INCH_TO_FEET = "/ConversionService/InchToFeet/";
	 static final String FEET_TO_INCH = "/ConversionService/FeetToInch/";
	 
	 public static void main(String[] args) {

		 int inch=12;
		 int feet=2;

		 ClientConfig config = new ClientConfig();
		 Client client = ClientBuilder.newClient(config);
		 WebTarget target = client.target(getBaseURI());
		 
		 WebTarget inchToFeet = target.path("rest").path(INCH_TO_FEET+inch);
		 WebTarget feetToInch = target.path("rest").path(FEET_TO_INCH+feet);
		 
		 System.out.println("INCH_TO_FEET Response: " + getResponse(inchToFeet));  
		 System.out.println("INCH_TO_FEET Output as XML: " + getOutputAsXML(inchToFeet));  
		 System.out.println("---------------------------------------------------");  
		  
		 System.out.println("FEET_TO_INCH Response: " + getResponse(feetToInch));  
		 System.out.println("FEET_TO_INCH Output as XML: " + getOutputAsXML(feetToInch));  
		 System.out.println("---------------------------------------------------");  

/*		 String response = target.path("rest").path(INCH_TO_FEET+inch).
	              request().accept(MediaType.TEXT_XML).get(Response.class).toString();
		 String responseXML = target.path("rest").path(INCH_TO_FEET+inch).
	              request().accept(MediaType.TEXT_XML).get(String.class);
		        System.out.println(response);
		        System.out.println(responseXML);*/
		 }
	 
	 private static String getResponse(WebTarget wt) {  
		 return wt.request().accept(MediaType.TEXT_XML).get(Response.class).toString();  
		 } 
	 
	 private static String getOutputAsXML(WebTarget wt) {  
		 return wt.request().accept(MediaType.TEXT_XML).get(String.class);
		 } 

	 private static URI getBaseURI() {
		    return UriBuilder.fromUri("http://localhost:8080/RESTfulWebServiceExample").build();
		  }
}
