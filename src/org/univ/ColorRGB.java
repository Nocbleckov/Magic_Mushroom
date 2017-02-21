package org.univ;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
public class ColorRGB {

    int red;
    int green;
    int blue;
    int color;
    int media;
    int binario;
    int canalesRGB[];

    public ColorRGB(int color) {
        this.color = color;
        this.red = (color >> 16) & 0xFF;
        this.green = (color >> 8) & 0xFF;
        this.blue = color & 0xFF;
        this.canalesRGB = new int[]{red, green, blue};
        this.media = ((int) (red + green + blue) / 3);
    }

    public ColorRGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.canalesRGB = new int[]{red, green, blue};
        this.media = ((int) (red + green + blue) / 3);
    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getMedia() {
        return ((media << 16) | (media << 8) | (media));
    }

    public int getBinario(int umbral) {
        if (media <= umbral) {
            binario = 0;
        } else {
            binario = 255;
        }
        return ((binario << 16) | (binario << 8) | (binario));
    }

    public int getGreen() {
        return green;
    }

    /*public int getEquilibrio(int[] max, int[] min) {
        for (int canal = 0; canal < 3; canal++) {

            double factor = 256.0 / (max[canal] - min[canal]);
            canalesRGB[canal] = (int) ((canalesRGB[canal] - min[canal]) * factor);
            canalesRGB[canal] = Math.min(255, Math.max(0, canalesRGB[canal]));
        }
        this.red = canalesRGB[0];
        this.green = canalesRGB[1];
        this.blue = canalesRGB[2];
        return Color.rgb(red, green, blue);

    }*/
    @Override
    public String toString() {
        return "ColorRGB{"
                + "red=" + red
                + ", green=" + green
                + ", blue=" + blue
                + '}';
    }

}
