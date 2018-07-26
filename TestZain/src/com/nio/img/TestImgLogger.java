/*
 * @(#)TestImgLogger.java
 * Author : zixian.luo001
 * Created Date: 2018年6月20日 
 */
package com.nio.img;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @title 图片水印
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年6月20日 zixian.luo001 create file<br>
 *              Id:TestImgLogger.java,v1.0 2018年6月20日 下午5:01:15
 */
public class TestImgLogger {
	public static void main(String[] args) {
		try {
			addWaterMark();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 添加水印
	public static void addWaterMark() throws IOException {
		File srcImgFile = new File("C:\\Users\\Expectation\\Desktop\\Test\\图片2.JPG");
		String waterMarkContent = "2018/6/20 17:28";
		Image srcImg = ImageIO.read(srcImgFile);// 文件转化为图片
		int srcImgWidth = srcImg.getWidth(null);// 获取图片的宽
		int srcImgHeight = srcImg.getHeight(null);// 获取图片的高
		int WaterMarkSize = (int) (srcImgWidth * 0.08);
		// 加水印
		BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bufImg.createGraphics();
		g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
		g.setColor(new Color(240, 0, 0, 128)); // 根据图片的背景设置水印颜色  配色#FF0000
		g.setFont(new Font("微软雅黑", Font.PLAIN, WaterMarkSize)); // 设置字体
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1)); //设置透明度

		// 设置水印的坐标
		int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - WaterMarkSize;
		int y = srcImgHeight - WaterMarkSize;
		g.drawString(waterMarkContent, x, y); // 画出水印
		g.dispose();

		// 输出图片
		FileOutputStream outImgStream = new FileOutputStream("C:\\Users\\Expectation\\Desktop\\Test\\waterMark\\F00000_2.jpg");
		ImageIO.write(bufImg, "jpg", outImgStream);
		System.out.println("添加水印完成");
		outImgStream.flush();
		outImgStream.close();
	}

	public static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
		return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
	}
}
