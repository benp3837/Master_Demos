package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		for(int i = 0; i<days.length; i++) {
			
			System.out.println(days[i]);
			
			if(days[i].charAt(0) == 'T' || days[i].charAt(0) == 'S') {
				System.out.println("GO TO THE GYM");
			} else {
				System.out.println("STAY HOME");
			}
			
		}
		
	}
	
}
