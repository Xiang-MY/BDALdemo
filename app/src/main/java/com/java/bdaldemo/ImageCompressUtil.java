package com.java.bdaldemo;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageCompressUtil {

    /**
     * BufferedImage图片流转byte[]数组
     */
    public static byte[] imageToBytes(BufferedImage bImage) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "jpg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth) throws IOException {
        int targetHeight = (originalImage.getHeight()*targetWidth)/originalImage.getWidth();//保持纵横比
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_AREA_AVERAGING);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    /**
     * byte[]数组转BufferedImage图片流
     */
    private static BufferedImage bytesToBufferedImage(byte[] ImageByte) {
        ByteArrayInputStream in = new ByteArrayInputStream(ImageByte);
        BufferedImage image = null;
        try {
            image = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static void ChangeImageSize(String imgPath) {
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
            int width =  image.getWidth();
            int height = image.getHeight();
            System.out.println("Width: " + width);
            System.out.println("Height: " + height);
           // BufferedImage newImage =bytesToBufferedImage(ImageCompressUtil.compressByWidth(width,height,600,image,1.8f));
            BufferedImage newImage = ImageCompressUtil.resizeImage(image,600);
            System.out.println("targetImgWidth: " + newImage.getWidth());
            System.out.println("targetImgHeight: " + newImage.getHeight());
            ImageIO.write(newImage, "jpg", new File(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
