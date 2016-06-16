package com.fpp.converter;

public class WeightFactory extends AbstractFactory {

	@Override
	Converter getLength(String length) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	Converter getWeight(String weight) {
		// TODO Auto-generated method stub
		if(weight == null){
	         return null;
	      }	
	      
	      if(weight.equalsIgnoreCase("Kg2Lbs")){
	    	  System.out.println("--Kf2Lbs--");
	         return new Kg2Lbs();
	         
	      }else if(weight.equalsIgnoreCase("Lbs2Kg")){
	         return new Lbs2Kg();
	         
	      }
		return null;
	}

	@Override
	Converter getTemperature(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
