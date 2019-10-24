package com.eye.op.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

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


@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Value("${last_days_hist}")
	private int lastDaysHist;
	
	@Resource
	private IPatientService patientService;
	
	
	@RequestMapping("/nav")
	public ModelAndView nav(String idCard) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>(); 
		Patient patient = patientService.getPatient(idCard);
		if(patient != null){
			History history = patient.getHistorys().get(0);
			Date date = DateUtil.formatToDate(history.getCreatedDate());
			Date current = new Date();
			Date last_day = DateUtil.minDays(current, lastDaysHist);;
			if(DateUtil.isGET(date, last_day)){
				map.put("hist_flag", true);
			}
		}
		map.put("lastDays", lastDaysHist);
		map.put("idCard", idCard);
		String path = "front/hist";
		return new ModelAndView(path,map);
		
	} 
	
	@RequestMapping("/goQN")
	public ModelAndView goQN(String idCard, String isNew){
		Map<String,Object> map=new HashMap<String,Object>(); 
		String path = "anamnesis/anamnesis";
		map.put("isNew", isNew);
		map.put("idCard", idCard);
		return new ModelAndView(path,map);
	}
	
	@RequestMapping("/loadQN")
	@ResponseBody
	public AjaxResponse loadQN(String idCard){
		AjaxResponse response = new AjaxResponse();
		Patient patient = patientService.getPatient(idCard);
		Questionnaire qn = patient.getQuestionnaire();
		response.setSuccess(true);
		response.setData(qn);
		return response;
	}
	
}
