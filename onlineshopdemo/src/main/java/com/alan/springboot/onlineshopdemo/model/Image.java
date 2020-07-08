package com.alan.springboot.onlineshopdemo.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Image {

    public String randomName() {
        String imageName = "";
        String[] strArr =
                {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 1; i <= 10; i++) {
            int num = (int) (Math.random() * 63);
            String word = strArr[num];
            imageName = imageName + word;
        }
        return imageName;
    }


    public void imageStore(MultipartFile multipartFile, String productImage) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        OutputStream outputStream = new FileOutputStream("src\\main\\resources\\static\\upload\\images\\" + productImage + ".jpg");
        byte[] bytes = new byte[(int) multipartFile.getSize()];
        inputStream.read(bytes);
        outputStream.write(bytes);
        inputStream.close();
        outputStream.close();
    }
}
