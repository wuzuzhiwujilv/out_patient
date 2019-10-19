package com.eye.op.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eye.op.bean.Questionnaire;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.common.param.ConditionParam;
import com.eye.op.common.param.DataGridResponse;
import com.eye.op.common.utils.Constant;
import com.eye.op.common.utils.ErrorConstant;
import com.eye.op.service.IQuestionnaire;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	private static Logger logger = Logger.getLogger(QuestionnaireController.class);
	@Autowired
	private IQuestionnaire iQuestionnaire;
	
	@RequestMapping(value ="/addForm",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addForm(Questionnaire questionnaire) {
		AjaxResponse response = new AjaxResponse();
		try {
//			questionnaire.setId(UUID.randomUUID().toString());
			iQuestionnaire.saveQuestionnire(questionnaire);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
}
	
	@RequestMapping("")
	public String indexStudent(){
		return "questionnaire/questionnaire";
	}
	
//	@RequestMapping("/getQuestionnaireRecord")
//	@ResponseBody
//	public DataGridResponse getQuestionnaireRecord(ConditionParam param) {
//	
//		logger.info(Constant.LOG_FORMAT  + "获取病史表单" + Constant.LOG_FORMAT );
//		return iQuestionnaire.list(param);
//	}
	
	
	@RequestMapping("/updateQuestionnaire")
	@ResponseBody
	public AjaxResponse updateQuestionnaire(Questionnaire questionnaire){
		logger.info(Constant.LOG_FORMAT  + "更新问卷记录" + Constant.LOG_FORMAT );
		AjaxResponse response = new AjaxResponse();
		try{
			response=iQuestionnaire.updateQuestionnaire(questionnaire);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			response.setSuccess(false);
			response.setMsg(ErrorConstant.GENERATE_ERROR_MSG);
		}
		return response;
	}
	
	@RequestMapping("/deleteQuestionnaire")
	@ResponseBody
	public AjaxResponse deleteQuestionnaire(Questionnaire questionnaire){
		logger.info(Constant.LOG_FORMAT  + "删除问卷记录" + Constant.LOG_FORMAT );
		AjaxResponse response = new AjaxResponse();
		try{
			response=iQuestionnaire.deleteQuestionnaire(questionnaire);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			response.setSuccess(false);
			response.setMsg(ErrorConstant.GENERATE_ERROR_MSG);
		}
		return response;
	}

}
