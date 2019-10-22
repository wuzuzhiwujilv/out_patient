package com.eye.op.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.eye.op.common.bean.User;
import com.eye.op.common.service.IService;

public interface IAccountService extends IService{
	public boolean dologin(User account,Map<String,Object> map,HttpSession session);
}
