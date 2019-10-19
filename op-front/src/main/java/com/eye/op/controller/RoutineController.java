package com.eye.op.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eye.op.bean.RoutineInspection;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.common.utils.DecodeUploadImgUtil;
import com.eye.op.service.IRoutineService;

@Controller
@RequestMapping("routine")
public class RoutineController {

	private static Logger logger = Logger.getLogger(RoutineController.class);
	
	@Autowired
	private IRoutineService iRoutineService;
	
	@RequestMapping("")
	public String indexStudent(){
		return "routine-test/routineTest";
	}
	
	@RequestMapping(value ="/addForm",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addForm(RoutineInspection routineInspection, HttpServletRequest request) {
		AjaxResponse response = new AjaxResponse();
		String img_preganglionic_result=routineInspection.getImg_preganglionic_result();
		routineInspection.setImg_preganglionic_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_preganglionic_result, request));
		String img_eyeground_result=routineInspection.getImg_eyeground_result();
		routineInspection.setImg_eyeground_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeground_result, request));
		String img_eyeMoveLT_result=routineInspection.getImg_eyeMoveLT_result();
		routineInspection.setImg_eyeMoveLT_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveLT_result, request));
		String img_eyeMoveCT_result=routineInspection.getImg_eyeMoveCT_result();
		routineInspection.setImg_eyeMoveCT_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveCT_result, request));
		String img_eyeMoveRT_result=routineInspection.getImg_eyeMoveRT_result();
		routineInspection.setImg_eyeMoveRT_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveRT_result, request));
		String img_eyeMoveLC_result=routineInspection.getImg_eyeMoveLC_result();
		routineInspection.setImg_eyeMoveLC_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveLC_result, request));
		String img_eyeMoveCC_result=routineInspection.getImg_eyeMoveCC_result();
		routineInspection.setImg_eyeMoveCC_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveCC_result, request));
		String img_eyeMoveRC_result=routineInspection.getImg_eyeMoveRC_result();
		routineInspection.setImg_eyeMoveRC_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveRC_result, request));
		String img_eyeMoveLB_result=routineInspection.getImg_eyeMoveLB_result();
		routineInspection.setImg_eyeMoveLB_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveLB_result, request));
		String img_eyeMoveCB_result=routineInspection.getImg_eyeMoveCB_result();
		routineInspection.setImg_eyeMoveCB_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveCB_result, request));
		String img_eyeMoveRB_result=routineInspection.getImg_eyeMoveRB_result();
		routineInspection.setImg_eyeMoveRB_path(DecodeUploadImgUtil.DecodeBase64ToImg(img_eyeMoveRB_result, request));

		try {
			iRoutineService.saveRoutineInspection(routineInspection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
}
	
	
	
}
