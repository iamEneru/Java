package com.java.exercise52;

public class Planet extends HeavenlyBody {

	public Planet(String heavenlyBodyName, double orbitalPeriod) {
		super(heavenlyBodyName, orbitalPeriod, HeavenlyBody.BodyTypes.PLANET);
	}

	@Override
	public boolean addSatellite(HeavenlyBody heavenlyBody) {
		if (heavenlyBody.getKey().getBodyType().equals(HeavenlyBody.BodyTypes.MOON))
			return super.addSatellite(heavenlyBody);
		return false;
	}
}
