package com.cts.jpademo.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity

//@Table(name="all_reservations")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("normal")

//@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name="reservations")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="reservations_only")
public class Reservation {
	
	@Id
	private Long pnr;
	private String ticketHolder;
	private String boarding;
	private String dropping;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(Long pnr, String ticketHolder, String boarding, String dropping) {
		super();
		this.pnr = pnr;
		this.ticketHolder = ticketHolder;
		this.boarding = boarding;
		this.dropping = dropping;
	}

	public Long getPnr() {
		return pnr;
	}

	public void setPnr(Long pnr) {
		this.pnr = pnr;
	}

	public String getTicketHolder() {
		return ticketHolder;
	}

	public void setTicketHolder(String ticketHolder) {
		this.ticketHolder = ticketHolder;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getDropping() {
		return dropping;
	}

	public void setDropping(String dropping) {
		this.dropping = dropping;
	}

	@Override
	public String toString() {
		return "Reservation [pnr=" + pnr + ", ticketHolder=" + ticketHolder + ", boarding=" + boarding + ", dropping="
				+ dropping + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boarding == null) ? 0 : boarding.hashCode());
		result = prime * result + ((dropping == null) ? 0 : dropping.hashCode());
		result = prime * result + ((pnr == null) ? 0 : pnr.hashCode());
		result = prime * result + ((ticketHolder == null) ? 0 : ticketHolder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (boarding == null) {
			if (other.boarding != null)
				return false;
		} else if (!boarding.equals(other.boarding))
			return false;
		if (dropping == null) {
			if (other.dropping != null)
				return false;
		} else if (!dropping.equals(other.dropping))
			return false;
		if (pnr == null) {
			if (other.pnr != null)
				return false;
		} else if (!pnr.equals(other.pnr))
			return false;
		if (ticketHolder == null) {
			if (other.ticketHolder != null)
				return false;
		} else if (!ticketHolder.equals(other.ticketHolder))
			return false;
		return true;
	}
	
	
}
