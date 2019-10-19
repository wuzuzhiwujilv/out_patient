package com.eye.op.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eye.op.bean.SpecialInspection;
import com.eye.op.common.param.ConditionParam;
import com.eye.op.common.param.DataGridResponse;
import com.eye.op.common.service.impl.ServiceImpl;
import com.eye.op.dao.SpecialInspectionDao;
import com.eye.op.service.ISpecialInspectionService;

@Service
public class SpecialInspectionServiceImpl extends ServiceImpl implements ISpecialInspectionService {

	@Resource(name="specialInspectionDao")
	private SpecialInspectionDao specialInspectionDao;
	
	@Override
	public DataGridResponse list(ConditionParam conditionParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSpecialInspection(SpecialInspection specialInspection) throws Exception {
		// TODO Auto-generated method stub
		specialInspectionDao.save(specialInspection);
	}

}
