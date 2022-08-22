package com.cts.sbwrd.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="txns")
public class Txn implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long txnId;
	@NotBlank(message ="Description can not be left blank")
	@Size(min=4,max=50,message="Description is expected to 4 chars atleast and 50 chars at max.")
    private String desp;
	@NotNull(message="Trtansaction amount can not be left unfilled")
	@PositiveOrZero(message="Transaction Amount can not be negative")
    private Double amount;
	@NotNull(message="Trtansaction Date can not be left unfilled")
	@PastOrPresent(message="Transaction Date can not be a future date")
	@DateTimeFormat(iso=ISO.DATE)
    private LocalDate txndate;
	@NotNull(message="Trtansaction Type can not be left unfilled")
	private TxnType type;
    
    public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(Long txnId, String desp, Double amount, LocalDate txndate, TxnType type) {
		super();
		this.txnId = txnId;
		this.desp = desp;
		this.amount = amount;
		this.txndate = txndate;
		this.type = type;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((desp == null) ? 0 : desp.hashCode());
		result = prime * result + ((txnId == null) ? 0 : txnId.hashCode());
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (desp == null) {
			if (other.desp != null)
				return false;
		} else if (!desp.equals(other.desp))
			return false;
		if (txnId == null) {
			if (other.txnId != null)
				return false;
		} else if (!txnId.equals(other.txnId))
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

    
}
