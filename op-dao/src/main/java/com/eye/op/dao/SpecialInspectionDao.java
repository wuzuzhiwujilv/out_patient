package com.eye.op.dao;

import org.springframework.stereotype.Repository;

import com.eye.op.bean.SpecialInspection;
import com.eye.op.common.dao.GenerateDao;

@Repository
public class SpecialInspectionDao extends GenerateDao {
	
	public SpecialInspection save(SpecialInspection sprInspection) throws Exception{
		try {
			getCurrentSession().save(sprInspection);
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		return sprInspection;	
	}

}
