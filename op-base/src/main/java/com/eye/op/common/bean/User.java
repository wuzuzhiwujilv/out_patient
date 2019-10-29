package com.eye.op.common.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.eye.op.common.bean.GenerateBean;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "op_user")
public class User extends GenerateBean{
	private static final long serialVersionUID = 1L;
	private String vcAccount;
	private String password;
	private Integer flag;
	private List<Privilege> privileges;
	
	@Column
	public String getVcAccount() {
		return vcAccount;
	}

	@Column
	public String getPassword() {
		return password;
	}

	@Column
	public Integer getFlag() {
		return flag;
	}
	@ManyToMany
	@JoinTable(name="op_user_privilege",joinColumns =@JoinColumn(name ="uid"),
			inverseJoinColumns = {@JoinColumn(name = "pid")})
	@OrderBy("id ASC")
	@JsonManagedReference
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setVcAccount(String vcAccount) {
		this.vcAccount = vcAccount;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}
