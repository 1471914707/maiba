package com.lin.tool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servImgVal extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Random random = new Random();
	public servImgVal(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codeLength = 4; //数字个数
		int mixTimes = 300; //线条个数
		Color bgColor = getRandColor(200,250);
		Color bfColor = new Color(0,0,0);
		boolean ifRandomColor = true;
		boolean ifMixColor = false;
		
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		
		int width = 13 * codeLength +6,height = 20;
		BufferedImage  image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.setColor(bgColor);
		g.fillRect(0, 0, width, height);
		Font font = new Font("微软雅黑",Font.PLAIN,18);
		g.setFont(font);
		g.setColor(new Color(33,66,99));
		g.drawRect(0,0,width-1,height-1);
		g.setColor(getRandColor(160,200));
		for (int i=0; i<mixTimes*codeLength/10; i++){
			if (ifMixColor) {
				g.setColor(getRandColor(160, 200));
			}
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		String sRand = "";
		char[] charsArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		int len = charsArray.length;
		for (int i = 0; i < codeLength; i++) {
			String rand = String.valueOf(charsArray[random.nextInt(len)]);
			sRand += rand;
			if (ifRandomColor)
				g.setColor(getRanfColor(20, 110, 0));
			else
				g.setColor(bfColor);
			g.drawString(rand, 13 * i + 6, 16);
		}
		req.getSession().setAttribute("rand", sRand);
		g.dispose();
		ImageIO.write(image, "PNG", resp.getOutputStream());
	}

	private Color getRandColor(int i, int j) {
		// TODO Auto-generated method stub
		return getRanfColor(i,j,i);
	}
	private Color getRanfColor(int i, int j, int i2) {
		// TODO Auto-generated method stub
		if (i > 255){
			i =255;
		}
		if (j > 255){
			j = 255;
		}
		int r = i + random.nextInt(j-i2);
		int g = i + random.nextInt(j-i2);
		int b = i + random.nextInt(j-i2);
		return new Color(r,g,b);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
