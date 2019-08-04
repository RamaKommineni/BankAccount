package com.bank.account.model;

import java.util.Date;

public class AccountTransactionDto {
	
	private Long id;
	private Date valueDate;
	private Float debitAmount;
	private Float creditAmount;
	private String narrative;
	private String transactionType;
	
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
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
}
