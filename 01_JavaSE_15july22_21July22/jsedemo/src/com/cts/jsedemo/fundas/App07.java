package com.cts.jsedemo.fundas;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.cts.jsedemo.fundas.model.Trainee;

public class App07 {
	public static void main(String[] args) {
		Set<Trainee> trainees = new TreeSet<Trainee>();
		
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
		
		trainees.stream().forEach(System.out::println);
		trainees.stream().forEach(t -> { t.setFee(t.getFee()*2); });
		trainees.stream().forEach(System.out::println);
		
		Optional<Trainee> optTrainee = trainees.stream().reduce((t1,t2) -> t1.getId()>t2.getId()?t1:t2);
		System.out.println(optTrainee.get());
		
		trainees.stream().filter(t -> t.getCourse().equals("Java FSD")).forEach(System.out::println);
		
		List<Trainee> javaSETrainees = trainees.stream().filter(t -> t.getCourse().equals("Java SE")).collect(Collectors.toList());
		System.out.println(javaSETrainees);
		
		System.out.println(trainees.stream().map(t -> t.getName()).collect(Collectors.toSet()));
		System.out.println(trainees.stream().map(t -> t.getCourse()).collect(Collectors.toList()));
		System.out.println(trainees.stream().map(t -> t.getCourse()).distinct().collect(Collectors.toList()));
	}
}
