package org.dbyz.wechat.app.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 生成随机码图
 * 
 * <pre>
 * Example:
 * VerfiyCode vc=new VerfiyCode();
 * BufferedImage img=vc.getImage();
 * System.out.println(vc.getRandomCode());
 * </pre>
 * 
 */

public class VerfiyCode {
	private String randomCode;

	public VerfiyCode() {
		System.setProperty("java.awt.headless", "true");
	}

	Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * 获取图片
	 */
	public BufferedImage getImage() {
		// 在内存中创建图象
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 获取图形上下�?
		Graphics g = image.getGraphics();

		// 生成随机�?
		Random random = new Random();

		// 设定背景�?
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// 画边�?
		g.setColor(new Color(255, 255, 255));
		g.drawRect(0, 0, width - 1, height - 1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测�?
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证�?(4位数�?)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生�?
			g.drawString(rand, 13 * i + 6, 16);
		}

		// 将认证码存入
		this.setRandomCode(sRand);
		// session.setAttribute("rand",sRand);

		// 图象生效
		g.dispose();

		// 输出图象到页�?
		return image;
	}

	/**
	 * 随机�?
	 */
	public String getRandomCode() {
		return this.randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}
}
