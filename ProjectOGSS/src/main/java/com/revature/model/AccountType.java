package com.revature.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account_type")
public class AccountType {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "acc_type")
	private String type;

	public AccountType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "accountType")
	@JsonIgnore
	private List<UserAccount> userAccount;

	public AccountType(int id, String type) {
		super();
		this.id = id;
		this.type = type;

	}

	public AccountType(int id, String type, List<UserAccount> userAccount) {
		super();
		this.id = id;
		this.type = type;
		this.userAccount = userAccount;
	}

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		AccountType temp = (AccountType) obj;
		return Objects.equals(id, temp.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public List<UserAccount> getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(List<UserAccount> userAccount) {
		this.userAccount = userAccount;
	}
}
