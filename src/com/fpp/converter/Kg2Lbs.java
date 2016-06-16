package com.fpp.converter;

public class Kg2Lbs implements Converter {

	@Override
	public double convert(double kg) {
		// TODO Auto-generated method stub
//		System.out.println("COnverted "+kg+" Kg2Lbs : "+ kg*2);
		return  kg * Constants.KG2LBS;
	}

}
