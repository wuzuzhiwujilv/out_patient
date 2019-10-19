package com.eye.op.dao;

import org.springframework.stereotype.Repository;

import com.eye.op.bean.Screening;
import com.eye.op.common.dao.GenerateDao;

@Repository
public class ScreeningDao extends GenerateDao{
	
	
	public Screening name(Screening screening) {
		
		try {
			getCurrentSession().save(screening);
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		return screening;	
	}
		
		

}
