package com.cts.jpademo.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("pass")
//@Table(name="reservation_passes")
@Table(name="reservation_passes_only")
public class ReservationPass extends Reservation {

	private LocalDate validTill;
	
	public ReservationPass() {
		// TODO Auto-generated constructor stub
	}

	public ReservationPass(Long pnr, String ticketHolder, String boarding, String dropping,LocalDate validTill) {
		super(pnr, ticketHolder, boarding, dropping);
		this.validTill=validTill;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	@Override
	public String toString() {
		return "ReservationPass [validTill=" + validTill + "]";
	}
	
	
}
