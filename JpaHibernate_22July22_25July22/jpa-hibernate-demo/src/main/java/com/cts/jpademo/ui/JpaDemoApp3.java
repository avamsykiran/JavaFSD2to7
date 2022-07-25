package com.cts.jpademo.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cts.jpademo.entities.Departiment;
import com.cts.jpademo.entities.GroupReservation;
import com.cts.jpademo.entities.Reservation;
import com.cts.jpademo.entities.ReservationPass;

public class JpaDemoApp3 {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		
		System.out.println(em.find(Departiment.class,2L));
		
		System.out.println("----------------------------------------------------------------------------------------------");
		
		TypedQuery<Departiment> qry1 = em.createQuery("SELECT d FROM Departiment d", Departiment.class);
		qry1.getResultStream().forEach(System.out::println);
		
		System.out.println("----------------------------------------------------------------------------------------------");
		
		TypedQuery<String> qry2 = em.createQuery("SELECT d.deptName FROM Departiment d", String.class);
		qry2.getResultStream().forEach(System.out::println);
		em.close();
	}

}
