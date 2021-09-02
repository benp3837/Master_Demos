package com.revature.models;

public class Avenger {

	private int av_id;
	private String av_name;
	private String av_power;
	private String first_name;
	private String last_name;
	private int power_level;
	private Home home_fk;

	
	
	
	//boiler plater code below---------------------------------------------------------------------
	
	public Avenger() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Avenger(int av_id, String av_name, String av_power, String first_name, String last_name, int power_level,
			Home home_fk) {
		super();
		this.av_id = av_id;
		this.av_name = av_name;
		this.av_power = av_power;
		this.first_name = first_name;
		this.last_name = last_name;
		this.power_level = power_level;
		this.home_fk = home_fk;
	}




	public Avenger(String av_name, String av_power, String first_name, String last_name, int power_level,
			Home home_fk) {
		super();
		this.av_name = av_name;
		this.av_power = av_power;
		this.first_name = first_name;
		this.last_name = last_name;
		this.power_level = power_level;
		this.home_fk = home_fk;
	}




	@Override
	public String toString() {
		return "Avenger [av_id=" + av_id + ", av_name=" + av_name + ", av_power=" + av_power + ", first_name="
				+ first_name + ", last_name=" + last_name + ", power_level=" + power_level + ", home_fk=" + home_fk
				+ "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + av_id;
		result = prime * result + ((av_name == null) ? 0 : av_name.hashCode());
		result = prime * result + ((av_power == null) ? 0 : av_power.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((home_fk == null) ? 0 : home_fk.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + power_level;
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
		if (av_id != other.av_id)
			return false;
		if (av_name == null) {
			if (other.av_name != null)
				return false;
		} else if (!av_name.equals(other.av_name))
			return false;
		if (av_power == null) {
			if (other.av_power != null)
				return false;
		} else if (!av_power.equals(other.av_power))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (home_fk == null) {
			if (other.home_fk != null)
				return false;
		} else if (!home_fk.equals(other.home_fk))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (power_level != other.power_level)
			return false;
		return true;
	}




	public int getAv_id() {
		return av_id;
	}


	public void setAv_id(int av_id) {
		this.av_id = av_id;
	}


	public String getAv_name() {
		return av_name;
	}


	public void setAv_name(String av_name) {
		this.av_name = av_name;
	}


	public String getAv_power() {
		return av_power;
	}


	public void setAv_power(String av_power) {
		this.av_power = av_power;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getPower_level() {
		return power_level;
	}


	public void setPower_level(int power_level) {
		this.power_level = power_level;
	}


	public Home getHome_fk() {
		return home_fk;
	}


	public void setHome_fk(Home home_fk) {
		this.home_fk = home_fk;
	}
	
	
	
	
}
