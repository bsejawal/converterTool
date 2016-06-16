package com.fpp.converter;

public class Fahrenheit2Celsius   implements Converter{

	@Override
	public double convert(double a) {
		
		 return (a-32) * (5.0/9.0);
	}

}
