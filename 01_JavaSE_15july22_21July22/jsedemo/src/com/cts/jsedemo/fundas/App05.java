package com.cts.jsedemo.fundas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cts.jsedemo.fundas.model.Trainee;

public class App05 {
	public static void main(String[] args) {
		List<Trainee> trainees = new ArrayList<Trainee>();
		
		trainees.add(new Trainee(111, "Komal", "Java SE",3450.0));
		trainees.add(new Trainee(101, "Kowshik", "Java EE",13450.0));
		trainees.add(new Trainee(123, "Sharma", "Java SE",3450.0));
		trainees.add(new Trainee(222, "Kumari", "Java FSD",23450.0));
		trainees.add(new Trainee(107, "Vinay", "Java SE",3450.0));
		trainees.add(new Trainee(118, "Vasanth", "Java FSD",23450.0));
		trainees.add(new Trainee(115, "Komal", "Java FSD",23450.0));
		trainees.add(new Trainee(109, "Vinodh", "Java SE",3450.0));
		trainees.add(new Trainee(169, "Pavan", "Java SE",3450.0));
		trainees.add(new Trainee(198, "Prem", "Java EE",13450.0));
		trainees.add(new Trainee(147, "Raghu", "Java EE",13450.0));
		trainees.add(new Trainee(156, "Zeenath", "Java FSD",23450.0));
		trainees.add(new Trainee(102, "Arjun", "Java SE",3450.0));
		
		for(Trainee t : trainees)
			System.out.println(t);
		System.out.println("---------------------------------------------------------------------------");
		
		Collections.sort(trainees);
		for(Trainee t : trainees)
			System.out.println(t);
		System.out.println("---------------------------------------------------------------------------");
		
		/*
		 * Comparator<Trainee> nameWiseComparator = new Comparator<Trainee>() {
		 * 
		 * @Override public int compare(Trainee o1, Trainee o2) { return
		 * o1.getName().compareTo(o2.getName()); } };
		 */

		Collections.sort(trainees,(t1,t2) -> t1.getName().compareTo(t2.getName()));
		for(Trainee t : trainees)
			System.out.println(t);
		System.out.println("---------------------------------------------------------------------------");
		
		Collections.sort(trainees,(t1,t2) -> t1.getCourse().compareTo(t2.getCourse()));
		for(Trainee t : trainees)
			System.out.println(t);
		System.out.println("---------------------------------------------------------------------------");
		
		
	}
}
