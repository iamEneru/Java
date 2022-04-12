package com.java.exercise52;

/*
Only add/edit code where it is stated in the description.
*/

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
	private final Key key;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;

	public enum BodyTypes {
		PLANET, DWARF_PLANET, MOON
	}

	public HeavenlyBody(String heavenlyBodyName, double orbitalPeriod, BodyTypes bodyType) {
		key = new Key(heavenlyBodyName, bodyType);
		this.orbitalPeriod = orbitalPeriod;
		this.satellites = new HashSet<>();
	}

	public double getOrbitalPeriod() {
		return this.orbitalPeriod;
	}

	public Key getKey() {
		return this.key;
	}

	public boolean addSatellite(HeavenlyBody heavenlyBody) {
		return this.satellites.add(heavenlyBody);
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		Key objKey = ((HeavenlyBody) obj).getKey();
		return this.key.equals(objKey);
	}

	@Override
	public final int hashCode() {
		return this.key.hashCode();
	}

	public static Key makeKey(String name, BodyTypes bodyType) {
		return new Key(name, bodyType);
	}

	@Override
	public String toString() {
		return this.key.getName() + ": " + this.key.getBodyType() + ", " + this.orbitalPeriod;
	}

	public static final class Key {
		private String name;
		private BodyTypes bodyType;

		private Key(String name, BodyTypes bodyType) {
			this.name = name;
			this.bodyType = bodyType;
		}

		public String getName() {
			return name;
		}

		public BodyTypes getBodyType() {
			return bodyType;
		}

		@Override
		public int hashCode() {
			return Objects.hash(bodyType, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			return bodyType == other.bodyType && Objects.equals(name, other.name);
		}

		@Override
		public String toString() {
			return name + ": " + bodyType;
		}

	}
}