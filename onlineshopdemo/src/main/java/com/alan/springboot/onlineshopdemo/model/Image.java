package com.alan.springboot.onlineshopdemo.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Image {
	private static int num=0;


	public String imageStore(MultipartFile multipartFile) throws IOException {
		num += 1;
		InputStream inputStream = multipartFile.getInputStream();
		OutputStream outputStream = new FileOutputStream("D:\\online_shop_demo\\onlineshopdemo\\src\\main\\resources\\static\\upload\\images\\"+num+".jpg");
		byte [] bytes = new byte[(int) multipartFile.getSize()];
		inputStream.read(bytes);
		outputStream.write(bytes);
		String productImage = Integer.toString(num);
		inputStream.close();
		outputStream.close();
		return productImage;
	}
}
