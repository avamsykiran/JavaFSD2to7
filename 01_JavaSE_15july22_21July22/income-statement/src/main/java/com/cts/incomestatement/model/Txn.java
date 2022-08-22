package com.cts.incomestatement.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 CREATE TABLE txns (
  txnId INT PRIMARY KEY AUTO_INCREMENT,
  desp VARCHAR(40) NOT NULL,
  amount DOUBLE NOT NULL,
  txndate DATE NOT NULL,
  type VARCHAR(10) NOT NULL
 );
 */

public class Txn implements Serializable{
	private int txnId;
    private String desp;
    private double amount;
    private LocalDate txndate;
    private TxnType type;
    
    public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(int txnId, String desp, double amount, LocalDate txndate, TxnType type) {
		super();
		this.txnId = txnId;
		this.desp = desp;
		this.amount = amount;
		this.txndate = txndate;
		this.type = type;
	}

	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getTxndate() {
		return txndate;
	}

	public void setTxndate(LocalDate txndate) {
		this.txndate = txndate;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((desp == null) ? 0 : desp.hashCode());
		result = prime * result + txnId;
		result = prime * result + ((txndate == null) ? 0 : txndate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Txn other = (Txn) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (desp == null) {
			if (other.desp != null)
				return false;
		} else if (!desp.equals(other.desp))
			return false;
		if (txnId != other.txnId)
			return false;
		if (txndate == null) {
			if (other.txndate != null)
				return false;
		} else if (!txndate.equals(other.txndate))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Txn [txnId=" + txnId + ", desp=" + desp + ", amount=" + amount + ", txndate=" + txndate + ", type="
				+ type + "]";
	}
    
    
}
