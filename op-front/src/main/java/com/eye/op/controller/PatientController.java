package com.eye.op.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eye.op.bean.History;
import com.eye.op.bean.Patient;
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
		String path = "front/hist";
		return new ModelAndView(path,map);
		
	} 
	
}
