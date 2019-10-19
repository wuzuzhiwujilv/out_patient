package com.eye.op.service;

import com.eye.op.bean.SpecialInspection;
import com.eye.op.common.service.ConfigurationService;

public interface ISpecialInspectionService extends ConfigurationService{
	
	public void saveSpecialInspection(SpecialInspection specialInspection) throws Exception;

}
