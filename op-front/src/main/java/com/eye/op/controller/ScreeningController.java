package com.eye.op.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eye.op.bean.Screening;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.common.utils.Constant;
import com.eye.op.service.IScreeningService;

@Controller
@RequestMapping("/screening")
public class ScreeningController {
	
	private static Logger logger = Logger.getLogger(ScreeningController.class);
	@Autowired
	private IScreeningService iScreeningService;

	@RequestMapping("")
	public String indexStudent(){
		return "screening/screening";
	}
	
	@RequestMapping(value ="/addForm",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addForm(Screening screening) {
		AjaxResponse response = new AjaxResponse();
		try {
			logger.info(Constant.LOG_FORMAT  + "保存筛查结果" + Constant.LOG_FORMAT );
			iScreeningService.saveScreening(screening);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
}
	
	
}
