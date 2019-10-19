package com.eye.op.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eye.op.bean.Screening;
import com.eye.op.common.param.ConditionParam;
import com.eye.op.common.param.DataGridResponse;
import com.eye.op.common.service.impl.ServiceImpl;
import com.eye.op.dao.ScreeningDao;
import com.eye.op.service.IScreeningService;

@Service
public class ScreeningServiceImpl extends ServiceImpl implements IScreeningService {

	final static Logger logger = Logger.getLogger(ScreeningServiceImpl.class);
	
	@Resource(name="screeningDao")
	private ScreeningDao  screeningDao ;
	
	@Override
	public DataGridResponse list(ConditionParam conditionParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Screening saveScreening(Screening screening) throws Exception {
		// TODO Auto-generated method stub
		return screeningDao.save(screening);
	}

	

}
