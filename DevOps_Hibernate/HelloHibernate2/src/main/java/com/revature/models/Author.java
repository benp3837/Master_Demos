package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int id;
	
	//going to leave the rest of the fields for Hibernate to handle itself
	private String firstName;
	private String lastName;
	private int yearBorn; //because I'm lazy to implement a date
	
	@OneToMany(mappedBy="author", fetch=FetchType.EAGER) 
	private List<Book> bibliography;
	//what's mappedBy? It's the field in the Book class that references the Author class.
	//super necessary if we want this ManyToMany relationship to work.
	
	//boilerplate code below-------------------------------------
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Author(String firstName, String lastName, int yearBorn, List<Book> bibliography) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.bibliography = bibliography;
	}


	public Author(int id, String firstName, String lastName, int yearBorn, List<Book> bibliography) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.bibliography = bibliography;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn
				+ ", bibliography=" + bibliography + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bibliography == null) ? 0 : bibliography.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + yearBorn;
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
		Author other = (Author) obj;
		if (bibliography == null) {
			if (other.bibliography != null)
				return false;
		} else if (!bibliography.equals(other.bibliography))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (yearBorn != other.yearBorn)
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getYearBorn() {
		return yearBorn;
	}


	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}


	public List<Book> getBibliography() {
		return bibliography;
	}


	public void setBibliography(List<Book> bibliography) {
		this.bibliography = bibliography;
	}
	
	
	
	
}
