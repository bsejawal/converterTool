package com.fpp.converter;

public class TemperatureFactory  extends AbstractFactory{

	@Override
	public Converter getLength(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Converter getWeight(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Converter getTemperature(String temperature) {
		// TODO Auto-generated method stub
		if(temperature == null){
	         return null;
	      }	
	      
	      if(temperature.equalsIgnoreCase("Celsius2Fahrenheit")){
	    	  System.out.println("--Celsius2Fahrenheit--");
	         return new Celsius2Fahrenheit();
	         
	      }else if(temperature.equalsIgnoreCase("Fahrenheit2Celsius")){
	         return new Fahrenheit2Celsius();
	         
	      }
		return null;
	}

}
