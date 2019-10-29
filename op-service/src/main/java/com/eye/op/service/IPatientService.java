package com.eye.op.service;

import com.eye.op.bean.Patient;
import com.eye.op.bean.Questionnaire;
import com.eye.op.common.service.IService;

public interface IPatientService extends IService{
	
	Patient getPatient(String idCard);
	void saveQN(Questionnaire questionnaire);

}
