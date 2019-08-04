/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.account.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ramakiran
 */
@Entity
@Table(name = "account_transaction", catalog = "virtusa", schema = "public")
//@Getter @Setter @NoArgsConstructor
public class AccountTransaction extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    
    @Column(name = "value_date")
    @Temporal(TemporalType.DATE)
    private Date valueDate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "debit_amount")
    private Float debitAmount;
    
    @Column(name = "credit_amount")
    private Float creditAmount;
    
    @Size(max = 255)
    @Column(name = "narrative")
    private String narrative;
    
    @Size(max = 255)
    @Column(name = "notes")
    private String notes;
    
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne
    private Account accountId;
    
    @JoinColumn(name = "transaction_type", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne
    private TransactionType transactionType;

    public AccountTransaction() {
    }

    public AccountTransaction(Long id) {
        this.id = id;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Float getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Float debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Float getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Float creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
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
        if (!(object instanceof AccountTransaction)) {
            return false;
        }
        AccountTransaction other = (AccountTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bank.account.entity.AccountTransaction[ id=" + id + " ]";
    }
    
}
