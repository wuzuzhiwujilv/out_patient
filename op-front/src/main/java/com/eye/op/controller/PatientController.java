package com.eye.op.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eye.op.bean.History;
import com.eye.op.bean.Patient;
import com.eye.op.bean.Questionnaire;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.common.utils.DateUtil;
import com.eye.op.service.IPatientService;
import com.eye.op.service.impl.AccountServiceImpl;


@Controller
@RequestMapping("/patient")
public class PatientController {
	final static Logger log = Logger.getLogger(PatientController.class);
	
	@Value("${last_days_hist}")
	private int lastDaysHist;
	
	@Resource
	private IPatientService patientService;
	
	
	@RequestMapping("/nav")
	public ModelAndView nav(String idCard) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>(); 
		Patient patient = patientService.getPatient(idCard);
		if(patient != null && patient.getQuestionnaire() != null){
			map.put("qn", patient.getQuestionnaire());
		}
		map.put("idCard", idCard);
		String path = "anamnesis/anamnesis";
		return new ModelAndView(path,map);
		
	} 
	
	@RequestMapping("/goQN")
	public ModelAndView goQN(String idCard, String isNew){
		String path = "anamnesis/histSearch";
		return new ModelAndView(path);
	}
	
	@RequestMapping("/loadQN")
	@ResponseBody
	public AjaxResponse loadQN(String idCard){
		AjaxResponse response = new AjaxResponse();
		Patient patient = patientService.getPatient(idCard);
		Questionnaire qn = patient == null ? null:patient.getQuestionnaire();
		response.setSuccess(true);
		response.setData(qn);
		return response;
	}
	
	@RequestMapping("/saveQN")
	@ResponseBody
	public AjaxResponse saveQN(Questionnaire questionnaire){
		AjaxResponse response = new AjaxResponse();
		try{
			patientService.saveQN(questionnaire);
		}catch(Exception e){
			log.error(e);
			response.setSuccess(false);
			return response;
		}
		response.setSuccess(true);
		return response;
	}
}
