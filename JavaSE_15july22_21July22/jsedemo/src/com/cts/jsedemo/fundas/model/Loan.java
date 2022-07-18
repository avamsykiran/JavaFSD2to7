package com.cts.jsedemo.fundas.model;

public class Loan {

	private double principal;
	private double roi;
	private double tenure;
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}

	public Loan(double principal, double roi, double tenure) {
		super();
		this.principal = principal;
		this.roi = roi;
		this.tenure = tenure;
	}
	
	public Loan(Loan l) {
		this(l.principal,l.roi,l.tenure);
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(principal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tenure);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Loan other = (Loan) obj;
		if (Double.doubleToLongBits(principal) != Double.doubleToLongBits(other.principal))
			return false;
		if (Double.doubleToLongBits(roi) != Double.doubleToLongBits(other.roi))
			return false;
		if (Double.doubleToLongBits(tenure) != Double.doubleToLongBits(other.tenure))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [principal=" + principal + ", roi=" + roi + ", tenure=" + tenure + "]";
	}
	
	
}
