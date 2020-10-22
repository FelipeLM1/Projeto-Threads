import classes.Imagem;
import classes.MatrizParaImg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            String pathImg = "/home/thuize/Documentos/UFRN/Projeto-Threads/src/balloons.png";
            //String pathImg = "C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\balloons.png";
            BufferedImage img = ImageIO.read(new File(pathImg));

            //Criando um objeto imagem
            Imagem imagem = new Imagem(img);

            //Gerando a matriz de cinza e exibindo
            int[][] matrizCinza = imagem.getMatrizCinza(img);
            imagem.printMatrizCinza(matrizCinza);
            imagem.alargarContraste(matrizCinza);
            
            MatrizParaImg matrizParaImg = new MatrizParaImg();
            BufferedImage imgOut = matrizParaImg.setPixelEscalaDeCinza(matrizCinza);
            ImageIO.write(imgOut, "jpg", new File("/home/thuize/Documentos/UFRN/Projeto-Threads/src/out.jpg"));
            //ImageIO.write(imgOut, "jpg", new File("C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\out.jpg"));
            System.out.println("Imagem criada");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
