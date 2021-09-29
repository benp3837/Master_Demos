package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "movies") //This isn't a necessary annotation, but without it, Hibernate would call the table "Movie"
public class Movie {

	@Id //This makes this field the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This will make our PK serial
	@Column(name = "movie_id")
	private int id;
	
	@Column(name = "movie_title", nullable = false) //we set a not null constraint here - movies need titles!
	private String title;
	
	@Column(name = "movie_genre")
	private String genre;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name = "director_id") //this is how we establish relationships - the name must equal the id of Director
	private Director director;
	
	//what is FetchType and CascadeType??
	
	//CascadeType defines how the queries will maintain Referential Integrity
	//So in the case of CascadeType.ALL, all operations will occur when needed (DETACH, PERSIST, etc.)
	//We tend to leave it on ALL for the most referential integrity
	
	
	//FetchType defines WHEN Hibernate will go to the DB to fetch an associated object
	//Two options: LAZY and EAGER
	/*LAZY: Hibernate will give a proxy object instead of going to the database, 
	 *until your code actually calls for the object. 
		
	 *EAGER: Hibernate returns the dependent object immediately, without using a proxy object. 
	 *This is generally less error prone... why?
	 *		well, if you close a Session, proxy objects aren't available anymore
	 */
	
	//What's a proxy object? Think of it as an "empty" object that gets filled only when it's needed
	//This is good for memory management, think of it as a lightweight placeholder
	
	//since Director can be null, and since FetchType is set to LAZY,
	//the Director field will have a proxy object to be filled IF there's an assocaited Director in the returned Movie
	
	
	
	
	//boilerplate code--------------------------------------------
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int id, String title, String genre, Director director) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
	}

	public Movie(String title, String genre, Director director) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movie other = (Movie) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
	
	
	
}
