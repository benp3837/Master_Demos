package com.revature.models;

import org.springframework.stereotype.Repository;

@Repository //All stereotype annotations make a class a bean... @Repository is usually for DAO classes though!!
public class Account {

	private double amount;
	private String type;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(double amount, String type) {
		super();
		this.amount = amount;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Account [amount=" + amount + ", type=" + type + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
