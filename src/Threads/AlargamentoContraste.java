package Threads;

import classes.Imagem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AlargamentoContraste implements Runnable {

    private BufferedImage foto;

    public AlargamentoContraste(BufferedImage foto) {
        this.foto = foto;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        Imagem imagem = new Imagem(this.foto);
        System.out.println("Thread - AlargamentoContraste");
        int[][] matrizCinza = imagem.getMatrizCinza(foto);
        int[][] matrizComAlargamentoDeContraste = imagem.alargarContraste(matrizCinza);
        BufferedImage imagemSaida = imagem.matrizParaImg(matrizComAlargamentoDeContraste);

        try {
            ImageIO.write(imagemSaida, "jpg", new File("C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\out1.jpg"));
            System.out.println("Imagem Com alargamento de Contraste Criada!");
            //ImageIO.write(imagemSaida, "jpg", new File("/home/thuize/Documentos/UFRN/Projeto-Threads/src/out.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("FIM DA THREAD ALARGAMENTO");
    }
}
