package com.fpp.converter;

public class Mile2Km implements Converter {

	@Override
	public double convert(double a) {
		// TODO Auto-generated method stub
//		System.out.println("Km2Meter---");
		
		return a*Constants.MILE2KM;
	}

}
