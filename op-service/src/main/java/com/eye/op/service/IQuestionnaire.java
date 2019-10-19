package com.eye.op.service;


import com.eye.op.bean.Questionnaire;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.common.service.ConfigurationService;

public interface IQuestionnaire extends ConfigurationService{
	
	public void saveQuestionnire(Questionnaire questionnaire) throws Exception;
	
	public AjaxResponse updateQuestionnaire(Questionnaire questionnaire) throws Exception;
	
	public AjaxResponse deleteQuestionnaire(Questionnaire questionnaire) throws Exception;

}
