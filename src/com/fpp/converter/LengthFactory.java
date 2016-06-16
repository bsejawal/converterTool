package com.fpp.converter;

public class LengthFactory extends AbstractFactory {

	@Override
	Converter getLength(String length) {
		// TODO Auto-generated method stub
		if(length == null){
	         return null;
	      }	
	      
	      if(length.equalsIgnoreCase("Km2Mile")){
	         return new Km2Mile();
	         
	      }else if(length.equalsIgnoreCase("Km2Meter")){
	         return new Km2Meter();
	         
	      }
		return null;
	}

	@Override
	Converter getWeight(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Converter getTemperature(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
