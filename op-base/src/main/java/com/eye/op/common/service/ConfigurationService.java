package com.eye.op.common.service;

import com.eye.op.common.param.ConditionParam;
import com.eye.op.common.param.DataGridResponse;

public interface ConfigurationService extends IService{
	public DataGridResponse list(ConditionParam conditionParam);
}
