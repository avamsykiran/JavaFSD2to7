package com.cts.jsedemo.fundas;

import com.cts.jsedemo.fundas.model.Loan;

public class App01 {

	public static void main(String[] args) {
		Loan l1 = new Loan(10000, 1, 1);
		Loan l2 = new Loan(10000, 1, 1);
		Loan l3 = l1;
		Loan l4 = new Loan(l1);
		
		System.out.println(System.identityHashCode(l1));
		System.out.println(System.identityHashCode(l2));
		System.out.println(System.identityHashCode(l3));
		System.out.println(System.identityHashCode(l4));
		
		System.out.println(l1.hashCode());
		System.out.println(l2.hashCode());
		System.out.println(l3.hashCode());
		System.out.println(l4.hashCode());
		
		System.out.println(l1.equals(l2));
		System.out.println(l1.equals(l3));
		System.out.println(l1.equals(l4));
		
		System.out.println(l1==l2);
		System.out.println(l1==l3);
		System.out.println(l1==l4);
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		
		
	}

}
