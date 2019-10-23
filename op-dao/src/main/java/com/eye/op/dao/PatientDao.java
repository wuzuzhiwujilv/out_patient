package com.eye.op.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eye.op.bean.Patient;
import com.eye.op.common.dao.GenerateDao;

@Repository
public class PatientDao extends GenerateDao{
	
	public Patient getPatientByIdCard(String idCard){
		Patient patient = new Patient();
		patient.setIdCard(idCard);
		List<Patient> list = getByExample(patient);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
}
