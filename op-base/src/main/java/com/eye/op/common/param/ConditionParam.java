package com.eye.op.common.param;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

public class ConditionParam {
	
	Logger log = Logger.getLogger(ConditionParam.class);
	
	private int page;
	private int rows;
	private String area_name;
	private String project_name;
	private String student_name;
	private String school_name;
	private String idCard;
	private String school;
	private Integer area_id;
	private Integer status;
	private String fileName;
	private Integer school_id;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ltrd;
	
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public Date getLtrd() {
		return ltrd;
	}
	public void setLtrd(Date ltrd) {
		this.ltrd = ltrd;
	}
	
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public Map<String,Object> getNotNullParam(){
		Map<String,Object> map = new HashMap<String, Object>();
		try{
		for(Field field:ConditionParam.class.getDeclaredFields()){
			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase(); 
			String getMethodName = "get" + firstLetter + fieldName.substring(1); 
			Method getMethod = ConditionParam.class.getMethod(getMethodName, new Class[] {});
			Object value = getMethod.invoke(this, new Object[] {});
			if(value!=null){
				map.put(fieldName, value);
			}
		}}catch(Exception e){
			log.error("ConditionParam 反射get方法错误");
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append("page : " + page +"\n")
			.append("rows : " + rows +"\n")
			.append("area_name : " + area_name +"\n")
			.append("project_name : " + project_name +"\n")
			.append("student_name : " + student_name +"\n")
			.append("idCard : " + idCard +"\n")
			.append("school : " + school +"\n")
			.append("area_id : " + area_id +"\n")
			.append("status : " + status +"\n")
			.append("fileName : " + fileName +"\n")
			.append("school_id : " + school_id +"\n");
		return str.toString();
		
	}
}
