package com.revature.models;

public interface Joggable {
		
		void move(int distance);

		default void trip() {
			System.out.println("Oh no you fell extra hard :O");
		}
	
}
