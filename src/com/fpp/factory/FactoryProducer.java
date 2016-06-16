package com.fpp.factory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase("LENGTH")) {
			return new LengthFactory();

		} else if (choice.equalsIgnoreCase("WEIGHT")) {
			return new WeightFactory();

		}else if(choice.equalsIgnoreCase("TEMPERATURE")){
			return new TemperatureFactory();
		}

		return null;
	}

}
