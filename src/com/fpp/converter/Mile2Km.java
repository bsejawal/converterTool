package com.fpp.converter;

import com.fpp.utils.Constants;

public class Mile2Km implements Converter {

	@Override
	public double convert(double a) {
		// TODO Auto-generated method stub
//		System.out.println("Km2Meter---");
		
		return a*Constants.MILE2KM;
	}

}
