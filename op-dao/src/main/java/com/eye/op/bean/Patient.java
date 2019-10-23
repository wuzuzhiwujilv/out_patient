package com.eye.op.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.eye.op.common.bean.GenerateBean;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="patient")
public class Patient extends GenerateBean{

	private static final long serialVersionUID = 9196173249066244887L;
	
	private String idCard;
	private String name;
	private String mobile;
	private Date lastTime;
	private Questionnaire questionnaire;
	private List<History> historys;
	
	@Column
	public String getIdCard() {
		return idCard;
	}
	@Column
	public String getName() {
		return name;
	}
	@Column
	public String getMobile() {
		return mobile;
	}
	@Column(name="last_time")
	public Date getLastTime() {
		return lastTime;
	}
	
	@OneToOne
	@JoinColumn(name="qn_id")
	@NotFound(action=NotFoundAction.IGNORE)
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	@OneToMany(mappedBy="patient",fetch=FetchType.LAZY)//默认是lazy
	@Where(clause="is_delete=0")
	@OrderBy(value="id desc")
	@NotFound(action=NotFoundAction. IGNORE)
	@JsonBackReference
	public List<History> getHistorys() {
		return historys;
	}
	
	
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	public void setHistorys(List<History> historys) {
		this.historys = historys;
	}
	
	
	
		
}
