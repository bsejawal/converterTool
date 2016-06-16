package com.fpp.converter;

public class Celsius2Fahrenheit  implements Converter {

	@Override
	public double convert(double a) {
		return (a * (9.0/5.0)) + 32;
	}

}
