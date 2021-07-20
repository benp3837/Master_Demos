package com.revature.models;

public class Avenger {

	private int id;
	private String heroName;
	private String power;
	private String firstName;
	private String lastName;
	private int powerLevel;
	
	
	public Avenger() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Avenger(int id, String heroName, String power, String firstName, String lastName, int powerLevel) {
		super();
		this.id = id;
		this.heroName = heroName;
		this.power = power;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
	}


	public Avenger(String heroName, String power, String firstName, String lastName, int powerLevel) {
		super();
		this.heroName = heroName;
		this.power = power;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
	}


	@Override
	public String toString() {
		return "Avenger [id=" + id + ", heroName=" + heroName + ", power=" + power + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", powerLevel=" + powerLevel + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((heroName == null) ? 0 : heroName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + powerLevel;
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
		Avenger other = (Avenger) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (heroName == null) {
			if (other.heroName != null)
				return false;
		} else if (!heroName.equals(other.heroName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (powerLevel != other.powerLevel)
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHeroName() {
		return heroName;
	}


	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}


	public String getPower() {
		return power;
	}


	public void setPower(String power) {
		this.power = power;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getPowerLevel() {
		return powerLevel;
	}


	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	
	
}
