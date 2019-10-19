package com.eye.op.dao;

import org.springframework.stereotype.Repository;

import com.eye.op.bean.Questionnaire;
import com.eye.op.common.dao.GenerateDao;

@Repository
public class QuestionnaireDao extends GenerateDao {
	
	public Questionnaire save(Questionnaire questionnaire) throws Exception{
		try {
			getCurrentSession().save(questionnaire);
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		return questionnaire;	
	}
	
	
	
	

}
