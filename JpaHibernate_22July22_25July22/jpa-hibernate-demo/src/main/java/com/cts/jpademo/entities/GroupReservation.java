package com.cts.jpademo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("group")
//@Table(name="grp_reservations")
@Table(name="grp_reservations_only")
public class GroupReservation extends Reservation {

	private int count;
	
	public GroupReservation() {
		// TODO Auto-generated constructor stub
	}

	public GroupReservation(Long pnr, String ticketHolder, String boarding, String dropping,int count) {
		super(pnr, ticketHolder, boarding, dropping);
		this.count=count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "GroupReservation [count=" + count + "]";
	}
	
	
}
