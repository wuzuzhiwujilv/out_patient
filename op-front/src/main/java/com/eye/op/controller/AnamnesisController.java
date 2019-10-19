package com.eye.op.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anamnesis")
public class AnamnesisController {
	@RequestMapping("")
	public String index(){
		return "anamnesis/anamnesis";
	}
}
