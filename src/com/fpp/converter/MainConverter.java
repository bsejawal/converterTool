package com.fpp.converter;

public class MainConverter {

	public static void main(String[] args) {

		AbstractFactory weightFactory = FactoryProducer.getFactory("WEIGHT");
		Converter weight1 = weightFactory.getWeight("Kg2Lbs");
		Double a =23.0;
		String b = "45587455";
		try {
			if(!b.matches("[-+]?\\d*\\.?\\d+")){
				throw new BadInputException("Invalid Number");
			}
			
			weight1.convert(a);
		} catch (BadInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*AbstractFactory lengthFactory = FactoryProducer.getFactory("LENGTH");
		Converter km2Meter = lengthFactory.getLength("Km2Meter");
//		System.out.println(km2Meter.convert(2));

		// TEMPERATURE
		AbstractFactory temperatureFactory = FactoryProducer.getFactory("TEMPERATURE");
		Converter celcius2Fahrenheit = temperatureFactory.getTemperature("Celsius2Fahrenheit");
		System.out.println("celcius2Fahrenheit" + celcius2Fahrenheit.convert(-40));

		Converter fahrenheit2Celcius = temperatureFactory.getTemperature("Fahrenheit2Celsius");
		System.out.println("Fahrenheit2Celcius" + fahrenheit2Celcius.convert(-40));
*/
	}
}
