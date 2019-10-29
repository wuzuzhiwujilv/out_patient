package com.eye.op.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eye.op.bean.Patient;
import com.eye.op.bean.Questionnaire;
import com.eye.op.common.dao.GenerateDao;
import com.eye.op.common.service.impl.ServiceImpl;
import com.eye.op.dao.PatientDao;
import com.eye.op.service.IPatientService;

@Service
public class PatientServiceImpl extends ServiceImpl implements IPatientService{
	
	@Value("${last_days_hist}")
	private int lastDaysHist;
	
	@Resource
	private GenerateDao generateDao;
	
	@Resource
	private PatientDao patientDao;
	

	@Override
	public Patient getPatient(String idCard) {
		return patientDao.getPatientByIdCard(idCard);
		
	}


	@Override
	public void saveQN(Questionnaire questionnaire) {
		Patient patient = patientDao.getPatientByIdCard(questionnaire.getIdCard());
		if(patient == null){
			patient = new Patient();
			patient.setIdCard(questionnaire.getIdCard());
			patient.setName(questionnaire.getName());
		}
		Questionnaire old = patient.getQuestionnaire();
		if(old != null){
			generateDao.deleteForLogic(old);
		}
		generateDao.save(questionnaire);
		patient.setQuestionnaire(questionnaire);
		generateDao.save(patient);
		
		//save hist record
		
		//add patient into checkList
		//todo
	}

}
