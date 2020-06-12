package com.revature.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "account_type")
public class AccountType {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "acc_type")
	private String type;

	@OneToMany(mappedBy = "accountType")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Collection<UserAccount> user_accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
