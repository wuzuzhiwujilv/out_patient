package com.eye.op.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/randomCode")
public class RandomCodeController {
	private int width = 60;
	private int height = 20;
	private char[] codeSequence = {'A','B','C','D','E','F','G','H','I',
			'J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z',
			'1','2','3','4','5','6','7','8','9'};
	@RequestMapping("/createRandom")
	public String createRandomCode(HttpServletRequest request,HttpServletResponse response){
		BufferedImage buffImg = new BufferedImage(width, height, 
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		
		Random random = new Random();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		Font font = new Font("宋体", Font.BOLD, 20);
		g.setFont(font);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		
		g.setColor(Color.WHITE);
		for (int i = 0; i < 40; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(12);
			int y2 = random.nextInt(12);
			g.drawLine(x1, y1, x2, y2);
		}
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		for (int i = 0; i < 4; i++) {
			String strRand = String.valueOf(codeSequence[random.nextInt(34)]);
			red = random.nextInt(50);
			green = random.nextInt(50);
			blue = random.nextInt(50);
			
			g.setColor(new Color(red,green,blue));
			g.drawString(strRand, 13*i+6, 16);
			randomCode.append(strRand);
		}
		HttpSession session = request.getSession();
		session.setAttribute("randomCode", randomCode);
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("image/jpeg");
		ServletOutputStream sos=null;
		try{
			sos = response.getOutputStream();
			ImageIO.write(buffImg, "jpeg", sos);
			sos.flush();
		}catch(Exception e){
			
		}finally{
			if(sos!=null){
				try {
					sos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		sos=null;
		try {
			if(response!=null){
				response.flushBuffer();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
