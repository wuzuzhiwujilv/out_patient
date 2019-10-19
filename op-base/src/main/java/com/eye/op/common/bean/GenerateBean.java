package com.eye.op.common.bean;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class GenerateBean implements Serializable{
	
	private static final long serialVersionUID = 7794499746513455592L;
	protected Integer id;
	protected String createdUser;
	protected String modifiedUser;
	protected Date createdDate;
	protected Date modifiedDate;
	protected Boolean deleted;
	
	@Id
	@GeneratedValue //GenerationType默认是auto
	@Column
	public Integer getId() {
		return id;
	}
	
	@Basic(fetch=FetchType.LAZY)
	@Column(name="created_user")
	public String getCreatedUser() {
		return createdUser;
	}
	
	@Basic(fetch=FetchType.LAZY)
	@Column(name="modified_user")
	public String getModifiedUser() {
		return modifiedUser;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(fetch=FetchType.LAZY)
	@Column(name="created_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreatedDate() {
		return createdDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(fetch=FetchType.LAZY)
	@Column(name="modified_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	@Column(name="is_delete",columnDefinition="tinyint")
	public Boolean getDeleted() {
		return deleted;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
