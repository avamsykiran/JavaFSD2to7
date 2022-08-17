package in.cts.budgetanalysis.txns.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account_holders")
public class AccountHolder {
	@Id
	private Long ahId;
    private Double currentBalance;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "holder")
    private Set<Txn> txns;
    
    public AccountHolder() {
		// TODO Auto-generated constructor stub
	}

	public AccountHolder(Long ahId, Double currentBalance, Set<Txn> txns) {
		super();
		this.ahId = ahId;
		this.currentBalance = currentBalance;
		this.txns = txns;
	}

	public Long getAhId() {
		return ahId;
	}

	public void setAhId(Long ahId) {
		this.ahId = ahId;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Set<Txn> getTxns() {
		return txns;
	}

	public void setTxns(Set<Txn> txns) {
		this.txns = txns;
	}    
}
