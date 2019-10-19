package com.eye.op.service;

import com.eye.op.bean.Screening;
import com.eye.op.common.service.ConfigurationService;

public interface IScreeningService extends ConfigurationService{
	
	public Screening saveScreening(Screening screening) throws Exception;

}
