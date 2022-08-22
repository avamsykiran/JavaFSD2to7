package in.cts.budgetanalysis.statement.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Txn implements Comparable<Txn>{

	private Long txnId;
	private String header;
	private Double amount;
	private TxnType type;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfTransaction;
	
	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(Long txnId, String header, Double amount, TxnType type, LocalDate dateOfTransaction) {
		super();
		this.txnId = txnId;
		this.header = header;
		this.amount = amount;
		this.type = type;
		this.dateOfTransaction = dateOfTransaction;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	@Override
	public int compareTo(Txn o) {
		return txnId.compareTo(o.txnId);
	}
}
