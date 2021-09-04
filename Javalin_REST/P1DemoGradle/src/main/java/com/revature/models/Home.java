package com.revature.models;

public class Home {

	private String home_name; 
	private String home_address;
	private String home_city;
	private String home_state;
	private String home_zip;

	
	
	//boilerplate code (alt + shift + s, or the source tab)--------------------------------------------
	
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Home(String home_name, String home_address, String home_city, String home_state, String home_zip) {
		super();
		this.home_name = home_name;
		this.home_address = home_address;
		this.home_city = home_city;
		this.home_state = home_state;
		this.home_zip = home_zip;
	}



	@Override
	public String toString() {
		return "Home [home_name=" + home_name + ", home_address=" + home_address + ", home_city=" + home_city
				+ ", home_state=" + home_state + ", home_zip=" + home_zip + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((home_address == null) ? 0 : home_address.hashCode());
		result = prime * result + ((home_city == null) ? 0 : home_city.hashCode());
		result = prime * result + ((home_name == null) ? 0 : home_name.hashCode());
		result = prime * result + ((home_state == null) ? 0 : home_state.hashCode());
		result = prime * result + ((home_zip == null) ? 0 : home_zip.hashCode());
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
		Home other = (Home) obj;
		if (home_address == null) {
			if (other.home_address != null)
				return false;
		} else if (!home_address.equals(other.home_address))
			return false;
		if (home_city == null) {
			if (other.home_city != null)
				return false;
		} else if (!home_city.equals(other.home_city))
			return false;
		if (home_name == null) {
			if (other.home_name != null)
				return false;
		} else if (!home_name.equals(other.home_name))
			return false;
		if (home_state == null) {
			if (other.home_state != null)
				return false;
		} else if (!home_state.equals(other.home_state))
			return false;
		if (home_zip == null) {
			if (other.home_zip != null)
				return false;
		} else if (!home_zip.equals(other.home_zip))
			return false;
		return true;
	}



	public String getHome_name() {
		return home_name;
	}



	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}



	public String getHome_address() {
		return home_address;
	}



	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}



	public String getHome_city() {
		return home_city;
	}



	public void setHome_city(String home_city) {
		this.home_city = home_city;
	}



	public String getHome_state() {
		return home_state;
	}



	public void setHome_state(String home_state) {
		this.home_state = home_state;
	}



	public String getHome_zip() {
		return home_zip;
	}



	public void setHome_zip(String home_zip) {
		this.home_zip = home_zip;
	}
	
	
	
	
	
}
