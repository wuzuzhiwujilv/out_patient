package com.eye.op.common.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="op_user_privilege")
public class UserPrivilege {
	
	private Integer id;
	private User user;
	private Privilege privilege;
	@Id
	@GeneratedValue
	@Column
	public Integer getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="uid")
	@JsonBackReference
	@NotFound(action=NotFoundAction.IGNORE)
	public User getUser(){
		return user;
	}
	
	@ManyToOne
	@JoinColumn(name="pid")
	@JsonBackReference
	@NotFound(action=NotFoundAction.IGNORE)
	public Privilege getPrivilege() {
		return privilege;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

}
