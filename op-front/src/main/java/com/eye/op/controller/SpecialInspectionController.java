package com.eye.op.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eye.op.bean.SpecialInspection;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.service.ISpecialInspectionService;

@Controller
@RequestMapping("special")
public class SpecialInspectionController {
	
	private static Logger logger = Logger.getLogger(SpecialInspectionController.class);

	@Autowired
	private ISpecialInspectionService inspectionService;
	 
	@RequestMapping("")
	public String indexStudent(){
		return "special-test/specialTest";
	}
	
	@RequestMapping(value ="/addForm",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addForm(@RequestParam(required = false, value = "mydriatic[]") String[] mydriatic,SpecialInspection specialInspection, HttpServletRequest request) {
		AjaxResponse response = new AjaxResponse();
		try {
			String imgString=specialInspection.getImg_specialTest();
			
			 String dataPrix = "";
	         String data = "";
	         String uploadPath="";
	            if(imgString == null || "".equals(imgString)){
	                throw new Exception("上传失败，上传图片数据为空");
	            }else{
	                String [] d = imgString.split("base64,");
	                if(d != null && d.length == 2){
	                    dataPrix = d[0];
	                    data = d[1];
	                }else{
	                    throw new Exception("上传失败，数据不合法");
	                }
	            }	          
	            String suffix = "";
	            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
	                suffix = ".jpg";
	            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
	                suffix = ".ico";
	            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
	                suffix = ".gif";
	            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
	                suffix = ".png";
	            }else{
	                throw new Exception("上传图片格式不合法");
	            }
	            String tempFileName = UUID.randomUUID().toString() + suffix;	            
	 
	            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
	            byte[] bs = Base64Utils.decodeFromString(data);
	            try{
	                //使用apache提供的工具类操作流	            	
	            	uploadPath=request.getServletContext().getRealPath("/upload");
	                FileUtils.writeByteArrayToFile(new File(uploadPath, tempFileName), bs);  
	            }catch(Exception ee){
	                throw new Exception("上传失败，写入文件失败，"+ee.getMessage());
	            }	           	          
	        if (mydriatic!=null&&mydriatic.length>0) {
	        	StringBuffer sBuffer=new StringBuffer();
	        	for (int i = 0; i < mydriatic.length; i++) {
					
					sBuffer=sBuffer.append(mydriatic[i]+",");
				}
	        	String stringMyString=sBuffer.toString();
	        	stringMyString=stringMyString.substring(0,stringMyString.length()-1);
	        	specialInspection.setLstMydriatic(stringMyString);
			} 
	        specialInspection.setImg_path(uploadPath+tempFileName);
			inspectionService.saveSpecialInspection(specialInspection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
}
	 
}
