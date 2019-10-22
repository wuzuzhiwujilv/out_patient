package com.eye.op.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eye.op.common.bean.User;
import com.eye.op.common.service.impl.ServiceImpl;
import com.eye.op.common.utils.Constant;
import com.eye.op.common.utils.DesUtils;
import com.eye.op.common.utils.StrUtil;
import com.eye.op.service.IAccountService;

@Service
public class AccountServiceImpl extends ServiceImpl implements IAccountService{
	
	final static Logger log = Logger.getLogger(AccountServiceImpl.class);
	
	public boolean dologin(User account,Map<String,Object> map,HttpSession session){
		if(StrUtil.isEmpty(account.getPassword())){
			return false;
		}
		try {
			account.setPassword(DesUtils.encrypt(account.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("加密失败");
			e.printStackTrace();
			map.put("msg", "加密失败");
			return false;
		}
		List<User> list =get(account);
		if(!list.isEmpty()){
			map.put("authName",account.getVcAccount());
			session.setAttribute(Constant.SESSION_ACCOUNT, account.getVcAccount());
			session.setAttribute(Constant.SESSION_USER, account);
			return true;
		}
		map.put("msg", "用户名/密码不正确");
		return false;
	}
}
