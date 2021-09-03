package com.revature.models;

public class Dinosaur {
	
	int id;
	String species;
	int legs;
	double weight;
	boolean isScary;
	
	
	//boilerplate code-------------------------------------------------------------
	
	public Dinosaur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Dinosaur(int id, String species, int legs, double weight, boolean isScary) {
		super();
		this.id = id;
		this.species = species;
		this.legs = legs;
		this.weight = weight;
		this.isScary = isScary;
	}


	public Dinosaur(String species, int legs, double weight, boolean isScary) {
		super();
		this.species = species;
		this.legs = legs;
		this.weight = weight;
		this.isScary = isScary;
	}


	@Override
	public String toString() {
		return "Dinosaur [id=" + id + ", species=" + species + ", legs=" + legs + ", weight=" + weight + ", isScary="
				+ isScary + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isScary ? 1231 : 1237);
		result = prime * result + legs;
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dinosaur other = (Dinosaur) obj;
		if (id != other.id)
			return false;
		if (isScary != other.isScary)
			return false;
		if (legs != other.legs)
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public int getLegs() {
		return legs;
	}


	public void setLegs(int legs) {
		this.legs = legs;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public boolean isScary() {
		return isScary;
	}


	public void setScary(boolean isScary) {
		this.isScary = isScary;
	}
	
}
