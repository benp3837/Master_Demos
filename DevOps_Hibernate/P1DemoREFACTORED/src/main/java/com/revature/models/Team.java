package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int team_id;
	private String team_name;
	
	@ManyToMany(mappedBy="team")
	private List<Avenger> members;
	//Notice - we only need the @JoinColumn annotation on ONE of the two entities in the ManyToMany relationship.
	
	
	
	//Boilerplate code-----------------
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(int team_id, String team_name, List<Avenger> members) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.members = members;
	}
	public Team(String team_name, List<Avenger> members) {
		super();
		this.team_name = team_name;
		this.members = members;
	}
	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", members=" + members.size() + "]";
	}
	
	
	
}
