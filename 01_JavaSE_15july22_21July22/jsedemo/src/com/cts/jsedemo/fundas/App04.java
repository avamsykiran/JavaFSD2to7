package com.cts.jsedemo.fundas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class App04 {
	public static void main(String[] args) {
		LocalDateTime start = LocalDateTime.now();
		System.out.println(start);
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate dob = LocalDate.of(1985, Month.JUNE,11);
		System.out.println(dob);
		System.out.println(Period.between(dob, today));
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd-MMMM-yyyy hh:mm:ss a");
		
		System.out.println(start.format(dtf1));
		System.out.println(start.format(dtf2));
		System.out.println(start.format(dtf3));
		
		LocalDateTime end = LocalDateTime.now();
		System.out.println(end);
		System.out.println(Duration.between(start, end));
	}
}
