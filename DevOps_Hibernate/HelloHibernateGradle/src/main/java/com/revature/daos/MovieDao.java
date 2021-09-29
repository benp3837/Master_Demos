package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Movie;
import com.revature.utils.HibernateUtil;

public class MovieDao {

	//Hibernate DAO Classes incorporate the session object methods to create/manipulate DB data
	//read up on the session methods in the notes to understand what's doing what here
	
	public void insertMovie(Movie movie) {
		
		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection with JDBC
		
		ses.save(movie); 
		
		HibernateUtil.closeSession();
		
		//This is the ENTIRE insert method - much cleaner than JDBC :)
		//no try/catch? well, we aren't really writing any SQL that could go wrong. Simply using sessions methods
		
	}
	
	public List<Movie> findAllMovies(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language. It references Java Classes, not DB entities
		List<Movie> movieList = ses.createQuery("FROM Movie").list();
		
		HibernateUtil.closeSession();
		
		return movieList;
	
	}
	
	
	public Movie findMovieById(int id){
		
		Session ses = HibernateUtil.getSession();
		
		Movie movie = ses.get(Movie.class, id);
		
		HibernateUtil.closeSession();
		
		return movie;
		
	}
	
	//Using the session merge() method didn't update the DB... we weren't using a persistent object so it won't take
	
	public Movie updateMovie1(Movie movie) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();	
	
		Movie newMovie = (Movie)ses.merge(movie); //have to cast, since merge() returns type Object
		//update would throw an exception if the movie object already existed
		//hence why I say merge is less error prone
		
		
		
		return newMovie;
	}
	
	
	public void updateMovie2(Movie movie) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction(); //update and delete must happen within a transaction
		
		//updates and deletes take a little more work... You should put the query into a Query object
		//and then make sure to executeUpdate(), similar to in JDBC.
		
		String HQL = "UPDATE Movie SET title = '" + movie.getTitle() + "' WHERE id = " + movie.getId();
		
		Query q = ses.createQuery(HQL);
		
		q.executeUpdate();
		
		tran.commit();
		HibernateUtil.closeSession();
		
	}
	
	
}
