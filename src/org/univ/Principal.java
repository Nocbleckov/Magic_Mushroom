/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.univ;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.nio.IntBuffer;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;

/**
 *
 * @author Daniel Noblecias
 */
public class Principal {

    public static void main(String[] args) {
        try {
            BufferedImage imgBuff = ImageIO.read(new File("lena.png"));

            DataBufferByte ss = (DataBufferByte) imgBuff.getRaster().getDataBuffer();

            byte[] pixels = ss.getData();

            int anImg = imgBuff.getWidth();
            int alImg = imgBuff.getHeight();

            int[][] pixResult = new int[alImg][anImg];

            int[] pixImgResult = new int[alImg * anImg];
            int pixT = anImg * anImg;

            int pixelLenght = 3;

            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLenght) {

                int rgb = 0;
                rgb += ((int) pixels[pixel] & 0xFF);
                rgb += (((int) pixels[pixel] & 0xFF) << 8);
                rgb += (((int) pixels[pixel] & 0xFF) << 16);

                pixResult[row][col] = rgb;

                col++;

                if (col == anImg) {
                    col = 0;
                    row++;
                }
            }

            for (int i = 0, a = 0; i < pixT; i += 3) {

                int rgb = 0;
                //rgb += (((int) pixels[i] & 0xff) << 24);
                int Rrgb = ((int) pixels[i] & 0xff);
                int Grgb = (((int) pixels[i] & 0xff) << 8);
                int Brgb = (((int) pixels[i] & 0xff) << 16);
                //pixImgResult[a] = rgb;
                System.out.println(Color.rgb(Rrgb, Grgb, Brgb));
                a++;
            }

            BufferedImage imgsave = new BufferedImage(anImg, alImg, BufferedImage.TYPE_BYTE_INDEXED);

            IntBuffer imgBuffer = IntBuffer.allocate(pixT);
            imgBuffer.put(pixImgResult);

            //byte[] last = new byte[imgBuffer.rewind().remaining()];
            //BufferedImage imgsave = ImageIO.read(new ByteArrayInputStream(last));
            imgsave.setRGB(0, 0, anImg, alImg, imgBuffer.array(), 0, 0);

            ImageIO.write(imgsave, "jpg", new File("Some_to2B.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
