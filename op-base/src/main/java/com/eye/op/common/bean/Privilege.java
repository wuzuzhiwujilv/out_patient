package com.eye.op.common.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="op_privilege")
public class Privilege implements Serializable{
	
	private static final long serialVersionUID = -2247190533465421920L;
	
	private Integer id;
	private String name;
	
	@Id
	@GeneratedValue 
	@Column
	public Integer getId() {
		return id;
	}
	
	@Column
	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
