package com.eye.op.bean;

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
	private Questionnaire questionnaire;
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="qn_id")
	@JsonManagedReference
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	@JsonManagedReference
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
