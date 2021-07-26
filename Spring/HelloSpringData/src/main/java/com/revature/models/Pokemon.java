package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity //map this class as an entity
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode <-----This is what lombok would look like...
public class Pokemon {

//I thought Spring Data abstracts away hibernate? NO! It abstracts away the dao layer
//We still need to map our entities 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private int level;
	
	//Lombok doesn't have a super convenient way to make an all-args-minus-something-constructor
	public Pokemon(String name, String type, int level) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
	}

	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(int id, String name, String type, int level) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", level=" + level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
		
	
	
}
