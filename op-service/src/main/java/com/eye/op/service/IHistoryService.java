package com.eye.op.service;

import java.util.List;

import com.eye.op.bean.History;
import com.eye.op.common.service.IService;

public interface IHistoryService extends IService{
	
	List<History> getHist(String idCard);

}
