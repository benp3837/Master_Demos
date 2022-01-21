package com.revature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=======================================================(Time)");
		
		LocalTime ld = LocalTime.now(); //LocalTime is a Class that gives us... the Local Time
		
		System.out.println(ld);
		
		LocalDateTime ldt = LocalDateTime.now(); //LocalDateTime is a Class that gives us... the Local Date and Time
		
		System.out.println(ldt);
		
		ZonedDateTime zdt = ZonedDateTime.now(); //ZonedDateTime gives us... the Date and Time with Timezone
		
		System.out.println(zdt);
		
		
		
		System.out.println("=======================================================(Date)");
		
		Date date = new Date(); //new date from java.util package
		
		System.out.println(date); //we can print out the date object, gives us the date and time
		
		//what if I just want the date, no time??
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter. ...formats dates 
		
		String formattedDate = dateFormat.format(date); //make a String representing today's date in the format we specified
		
		System.out.println(formattedDate);
		
		
		//formatting to show the year, month, day, day of the week, and timezone 
		dateFormat = new SimpleDateFormat("yyyy-MM-dd-E-z");
		
		String formattedDate2 = dateFormat.format(date); 
		
		System.out.println(formattedDate2);
		
		//There are a bunch more options when formatting a date - you can check the java.util.Date documentation
		
	}
	
}
