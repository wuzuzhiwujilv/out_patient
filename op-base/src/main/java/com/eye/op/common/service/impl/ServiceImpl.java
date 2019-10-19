package com.eye.op.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eye.op.common.bean.GenerateBean;
import com.eye.op.common.dao.GenerateDao;
import com.eye.op.common.param.AjaxResponse;
import com.eye.op.common.service.IService;


@Service
public class ServiceImpl implements IService{

	@Resource(name="generateDao")
	private GenerateDao dao;

	public <T extends GenerateBean> T save(T object) {
		// TODO Auto-generated method stub
		return dao.save(object);
	}

	public <T extends GenerateBean> T update(T object) {
		// TODO Auto-generated method stub
		return dao.update(object);
	}

	public <T extends GenerateBean> T deleteForLogic(T object) {
		// TODO Auto-generated method stub
		return dao.deleteForLogic(object);
	}

	public <T extends GenerateBean> List<T> get(T object) {
		// TODO Auto-generated method stub
		return dao.get(object);
	}

	public <T> T getById(Class<T> clazz,int id) {
		// TODO Auto-generated method stub
		return dao.getById(clazz, id);
	}

	@Override
	public <T extends GenerateBean> AjaxResponse saveForDataGrid(T object, T example) throws Exception{
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		List<T> exsitList = dao.getByExample(example);
		if(exsitList.isEmpty()){
			save(object);
		}else{
			response.setSuccess(false);
			response.setMsg("已存在该数据");
		}
		return response;
	}

	@Override
	public <T extends GenerateBean> AjaxResponse updateForDataGrid(T object) throws Exception{
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		update(object);
		return response;
	}

	@Override
	public <T extends GenerateBean> AjaxResponse deleteForDataGrid(T object) throws Exception{
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		deleteForLogic(object);
		return response;
	}



}
