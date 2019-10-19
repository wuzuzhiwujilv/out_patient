package com.eye.op.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eye.op.bean.Questionnaire;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.common.param.ConditionParam;
import com.eye.op.common.param.DataGridResponse;
import com.eye.op.common.service.impl.ServiceImpl;
import com.eye.op.dao.QuestionnaireDao;
import com.eye.op.service.IQuestionnaire;

@Service
public class QuestionnaireImpl extends ServiceImpl implements IQuestionnaire {
	final static Logger logger = Logger.getLogger(QuestionnaireImpl.class);
	@Resource(name="questionnaireDao")
	private QuestionnaireDao questionnaireDao ;

	@Override
	public DataGridResponse list(ConditionParam conditionParam) {
		logger.info(conditionParam);
		DataGridResponse response = new DataGridResponse();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from Questionnaire");
		logger.info(hql);
		response.setRows(questionnaireDao.getByPage(hql,conditionParam.getPage(), conditionParam.getRows(),conditionMap));
		response.setTotal(questionnaireDao.getCount(hql, conditionMap));
		return response;
	}

	@Override
	public void saveQuestionnire(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		questionnaireDao.save(questionnaire);
	}

	@Override
	public AjaxResponse updateQuestionnaire(Questionnaire questionnaire) throws Exception {
		Questionnaire persistence = questionnaireDao.getById(Questionnaire.class, questionnaire.getId());
		return updateForDataGrid(persistence);
	}

	@Override
	public AjaxResponse deleteQuestionnaire(Questionnaire questionnaire) throws Exception {
		questionnaire = questionnaireDao.getById(Questionnaire.class, questionnaire.getId());
		return deleteForDataGrid(questionnaire);
	}

	
	

}
