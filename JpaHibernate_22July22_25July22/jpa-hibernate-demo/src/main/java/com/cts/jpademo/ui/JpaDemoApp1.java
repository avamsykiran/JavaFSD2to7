package com.cts.jpademo.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.Address;
import com.cts.jpademo.entities.Departiment;
import com.cts.jpademo.entities.Employee;
import com.cts.jpademo.entities.Laptop;

public class JpaDemoApp1 {

	public static void main(String[] args) {

		Departiment sales = new Departiment(null, "SALES", new TreeSet<>());
		Departiment operations = new Departiment(null, "OPERATIONS", new TreeSet<>());
		Departiment hr = new Departiment(null, "HR", new TreeSet<>());
		
		Employee e1 = new Employee(null, "Vamsy", 4567.0, new Address("f#9015", "VSP", "AP"), sales, new Laptop(null, "DELL", "ASPIRON", null));
		e1.getLaptop().setOwner(e1);
		
		Employee e2 = new Employee(null, "Sagar", 5567.0, new Address("f#9017", "VSP", "AP"), sales, new Laptop(null, "DELL", "ThinkPAd", null));
		e2.getLaptop().setOwner(e2);
		
		sales.getEmps().add(e1);
		sales.getEmps().add(e2);
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		em.getTransaction().begin();
		em.persist(hr);
		em.persist(sales);
		em.persist(operations);
		em.getTransaction().commit();
		em.close();
	}

}
