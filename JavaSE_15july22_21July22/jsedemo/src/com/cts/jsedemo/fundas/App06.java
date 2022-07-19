package com.cts.jsedemo.fundas;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.cts.jsedemo.fundas.model.Trainee;

public class App06 {
	public static void main(String[] args) {
		//Set<Trainee> trainees = new HashSet<Trainee>();
		//Set<Trainee> trainees = new LinkedHashSet<Trainee>();
		//Set<Trainee> trainees = new TreeSet<Trainee>();
	
		Set<Trainee> trainees = new TreeSet<Trainee>((t1,t2) -> t1.getName().compareTo(t2.getName()));
		
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
				
	}
}
