package com.eye.op.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eye.op.common.bean.GenerateBean;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="history")
public class History extends GenerateBean{
	private static final long serialVersionUID = 1L;
	private String idCard;
	private Date lastTime;
	private Questionnaire questionnaire;
	
	@Column
	public String getIdCard() {
		return idCard;
	}
	@Column(name="last_time")
	public Date getLastTime() {
		return lastTime;
	}
	@ManyToOne
	@JoinColumn(name="qn_id")
	@JsonManagedReference
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	
	
	
}
