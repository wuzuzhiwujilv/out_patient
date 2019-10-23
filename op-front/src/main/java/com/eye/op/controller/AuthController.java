package com.eye.op.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eye.op.common.bean.User;
import com.eye.op.service.IAccountService;

@Controller
@RequestMapping("/")
public class AuthController {
	
	@Resource
	private IAccountService accountService;
	
	@RequestMapping("/")
	public String index(){
		return "front/main";
	}
	
	@RequestMapping("/dologin")
	public ModelAndView dologin(User account,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>(); 
		String path;
		if(accountService.dologin(account,map,session)){
			path="front/nav";
		}else{
			path="front/main";
		}
		return new ModelAndView(path,map);
	} 

	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "front/main";
	}
}
