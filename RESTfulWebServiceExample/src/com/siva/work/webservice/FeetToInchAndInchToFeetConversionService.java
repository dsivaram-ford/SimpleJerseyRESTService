package com.siva.work.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ConversionService")
public class FeetToInchAndInchToFeetConversionService {
	
	@GET
	@Path("/InchToFeet/{i}")
	@Produces(MediaType.TEXT_XML)
	public String ConversionToFeet(@PathParam("i")int i){
		int inch = i;
		double feet = 0;
		feet = inch/2;
		
        return "<InchToFeetService>"  
        + "<Inch>" + inch + "</Inch>"  
          + "<Feet>" + feet + "</Feet>"  
         + "</InchToFeetService>"; 
	}
	
	@GET
	@Path("/FeetToInch/{f}")
	@Produces(MediaType.TEXT_XML)
	public String ConversionToInch(@PathParam("f")int f) {
		int inch = 0;
		int feet = f;
		inch = f*12;
		
		return "<FeetToInchService>"  
        + "<Feet>" + feet + "</Feet>"  
        + "<Inch>" + inch + "</Inch>"  
        + "</FeetToInchService>"; 

	}

}
