package com.cts.jpademo.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.GroupReservation;
import com.cts.jpademo.entities.Reservation;
import com.cts.jpademo.entities.ReservationPass;

public class JpaDemoApp2 {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		em.getTransaction().begin();
		
		em.persist(new Reservation(123435L, "Vamsy", "VSP", "TIRUPATI"));
		em.persist(new ReservationPass(34567L, "Sagar", "Hyd", "Banglore", LocalDate.now().plusMonths(3)));
		em.persist(new GroupReservation(1003435L, "Suseela", "VSP", "TIRUPATI",13));
		
		em.getTransaction().commit();
		em.close();
	}

}
