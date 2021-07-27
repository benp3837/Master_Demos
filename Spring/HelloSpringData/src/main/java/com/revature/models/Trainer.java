package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainer_id;
	
	private String name;

	
	
	//boilerplate code--------------------------------------------------------
	
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Trainer(int trainer_id, String name) {
		super();
		this.trainer_id = trainer_id;
		this.name = name;
	}



	public Trainer(String name) {
		super();
		this.name = name;
	}



	@Override
	public String toString() {
		return "Trainer [trainer_id=" + trainer_id + ", name=" + name + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + trainer_id;
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
		Trainer other = (Trainer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (trainer_id != other.trainer_id)
			return false;
		return true;
	}



	public int getTrainer_id() {
		return trainer_id;
	}



	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
}
