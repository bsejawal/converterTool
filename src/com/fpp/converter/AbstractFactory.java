package com.fpp.converter;

public abstract class AbstractFactory {
	   public abstract Converter getLength(String length);
	   public abstract Converter getWeight(String weight) ;
	   public abstract Converter getTemperature(String temperature);
	}
