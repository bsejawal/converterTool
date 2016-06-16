package com.fpp.converter;

public class Lbs2Kg implements Converter {

	@Override
	public double convert(double a) {
		// TODO Auto-generated method stub
		return a * Constants.LBSTOKG;
	}

}
