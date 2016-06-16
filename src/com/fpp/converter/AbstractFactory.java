package com.fpp.converter;

public abstract class AbstractFactory {
	   abstract Converter getLength(String length);
	   abstract Converter getWeight(String weight) ;
	   abstract Converter getTemperature(String temperature);
	}
