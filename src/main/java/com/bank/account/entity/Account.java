/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.account.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ramakiran
 */
@Entity
@Table(name = "account", catalog = "virtusa", schema = "public")
//@Getter @Setter @NoArgsConstructor
public class Account extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    
    @Column(name = "account_number")
    private Long accountNumber;
    
    @Size(max = 20)
    @Column(name = "account_name")
    private String accountName;
    
    @Column(name = "balance_date")
    @Temporal(TemporalType.DATE)
    private Date balanceDate;
    
    @Size(max = 4)
    @Column(name = "currency")
    private String currency;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Float balance;
    
    @Size(max = 255)
    @Column(name = "notes")
    private String notes;
       
    @OneToMany(mappedBy = "accountId")
    @JsonManagedReference
    private Collection<AccountTransaction> accountTransactionCollection;
    
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne(optional = false)
    private AccountType accountTypeId;
    
    @JoinColumn(name = "account_user_id", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne
    private AccountUser accountUserId;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Collection<AccountTransaction> getAccountTransactionCollection() {
		return accountTransactionCollection;
	}

	public void setAccountTransactionCollection(Collection<AccountTransaction> accountTransactionCollection) {
		this.accountTransactionCollection = accountTransactionCollection;
	}

	public AccountType getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(AccountType accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public AccountUser getAccountUserId() {
		return accountUserId;
	}

	public void setAccountUserId(AccountUser accountUserId) {
		this.accountUserId = accountUserId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bank.account.entity.Account[ id=" + id + " ]";
    }
    
}
