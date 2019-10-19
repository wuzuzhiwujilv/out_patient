package com.eye.op.common.service;

import java.util.List;

import com.eye.op.common.bean.GenerateBean;
import com.eye.op.common.param.AjaxResponse;


public interface IService {
	
//	public int getCount(ConditionParam param);
//	
//	public List getByPage(int page,int size,ConditionParam param);
	public <T extends GenerateBean> List<T> get(T object);
	
	public <T extends GenerateBean> T save(T object);
	
	public <T extends GenerateBean> AjaxResponse saveForDataGrid(T object, T example) throws Exception;
	
	public <T extends GenerateBean> T update(T object);
	
	public <T extends GenerateBean> AjaxResponse updateForDataGrid(T object) throws Exception;
	
	public <T extends GenerateBean> T deleteForLogic(T object);
	
	public <T extends GenerateBean> AjaxResponse deleteForDataGrid(T object) throws Exception;
	
	public <T> T getById(Class<T> clazz,int id);
}
