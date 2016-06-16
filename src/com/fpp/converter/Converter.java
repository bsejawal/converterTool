package com.fpp.converter;

import com.fpp.utils.BadInputException;

public interface Converter {
	public double convert(double a) throws BadInputException;
}
