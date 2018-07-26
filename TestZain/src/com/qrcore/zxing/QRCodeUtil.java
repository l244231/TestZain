/*
 * @(#)QRCodeUtil.java
 * Author : Zain.Luo
 * Created Date: 2017年2月14日 
 */
package com.qrcore.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @title 二维码工具类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年2月14日 Zain.Luo create file<br>
 * Id:QRCodeUtil.java,v1.0 2017年2月14日 下午4:07:53
 */
public class QRCodeUtil {
	public static void main(String[] args){
		//encode();
		decode();
	}
	
	public static void encode(){
		Map<EncodeHintType,Object> params = new Hashtable<>();
		params.put(EncodeHintType.CHARACTER_SET, "GBK");
		params.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
		
		
		String contents = "Test";
		
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, 21, 21);
			MatrixToImageWriter.writeToStream(bitMatrix,"png",new FileOutputStream("E:\\Test\\test.png"));
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void decode(){
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new File("E:\\Test\\qrcode.png"));
			if(image == null){
				System.out.println("图片不存在");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitMap = new BinaryBitmap(new HybridBinarizer(source));
			Map<DecodeHintType,Object> hints = new Hashtable<>();
			hints.put(DecodeHintType.CHARACTER_SET, "GBK");
			result = new MultiFormatReader().decode(bitMap,hints);
			System.out.println(result.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
