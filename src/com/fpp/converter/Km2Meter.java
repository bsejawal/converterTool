package com.fpp.converter;

public class Km2Meter implements Converter {

	@Override
	public double convert(double a) {
		// TODO Auto-generated method stub
//		System.out.println("Km2Meter---");
		
		return a*Constants.KM2METER;
	}

}
