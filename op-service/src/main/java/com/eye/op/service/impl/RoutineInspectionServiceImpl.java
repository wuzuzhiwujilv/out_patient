package com.eye.op.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eye.op.bean.RoutineInspection;
import com.eye.op.common.service.impl.ServiceImpl;
import com.eye.op.dao.RoutineDao;
import com.eye.op.service.IRoutineService;

@Service
public class RoutineInspectionServiceImpl extends ServiceImpl implements IRoutineService {
	
	@Resource(name="routineDao")
	RoutineDao RoutineDao;

	@Override
	public void saveRoutineInspection(RoutineInspection routineInspection) throws Exception {

		RoutineDao.save(routineInspection);
	}

}
