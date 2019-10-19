package com.eye.op.dao;

import org.springframework.stereotype.Repository;

import com.eye.op.bean.RoutineInspection;
import com.eye.op.common.dao.GenerateDao;

@Repository
public class RoutineDao extends GenerateDao{
	
	public RoutineInspection save(RoutineInspection routineInspection) throws Exception{
		try {
			getCurrentSession().save(routineInspection);
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		return routineInspection;	
	}

}
