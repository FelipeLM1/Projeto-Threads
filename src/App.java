import classes.MatrizParaImg;
import jdk.swing.interop.SwingInterOpUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            String pathImg = "C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\balloons.png";
            BufferedImage img = ImageIO.read(new File(pathImg));
            int largura = img.getWidth();
            int altura = img.getHeight();
            int[][] matrizCinza = new int[largura][altura];
            for (int i = 0; i < largura; i++) {
                for (int j = 0; j < altura; j++) {
                    Color cor = new Color(img.getRGB(i, j));
                    int tomCinza = (int) ((cor.getRed()));
                    //img.setRGB(i, j, tomCinza);
                    matrizCinza[i][j] = tomCinza;
                }
                System.out.println("");
            }

            for (int i = 0; i < largura; i++) {
                for (int j = 0; j < altura; j++) {
                    System.out.print(matrizCinza[i][j] + " ");
                }
                System.out.println(" ");
            }
            
            MatrizParaImg matrizParaImg = new MatrizParaImg();
            BufferedImage imgOut = matrizParaImg.setPixelEscalaDeCinza(matrizCinza);
            ImageIO.write(imgOut, "jpg", new File("C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\out.jpg"));
            System.out.println("Imagem criada");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
