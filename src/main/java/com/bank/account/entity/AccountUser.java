/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.account.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ramakiran
 */
@Entity
//@Getter @Setter @NoArgsConstructor
@Table(name = "account_user", catalog = "virtusa", schema = "public")
public class AccountUser extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "login_name")
    private String loginName;
    
    @Size(max = 10)
    @Column(name = "status")
    private String status;
    
    @Size(max = 255)
    @Column(name = "notes")
    private String notes;
    
    @OneToMany(mappedBy = "accountUserId")
    @JsonManagedReference
    private Collection<Account> accountCollection;

    public AccountUser() {
    }

    public AccountUser(Long id) {
        this.id = id;
    }

    public AccountUser(Long id, String loginName) {
        this.id = id;
        this.loginName = loginName;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Collection<Account> getAccountCollection() {
		return accountCollection;
	}

	public void setAccountCollection(Collection<Account> accountCollection) {
		this.accountCollection = accountCollection;
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
        if (!(object instanceof AccountUser)) {
            return false;
        }
        AccountUser other = (AccountUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bank.account.entity.AccountUser[ id=" + id + " ]";
    }
    
}
