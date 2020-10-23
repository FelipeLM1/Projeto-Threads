package Threads;

import classes.Imagem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AlargamentoContraste implements Runnable {

    private String localImgSaida;
    private String localImgEntrada;

    public AlargamentoContraste(String localImgEntrada, String localImgSaida) {
        this.localImgEntrada = localImgEntrada;
        this.localImgSaida = localImgSaida;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        System.out.println("Thread Alargamento de Contraste Iniciada!");

        try {
            BufferedImage img = ImageIO.read(new File(this.localImgEntrada));
            Imagem imagem = new Imagem(img);
            BufferedImage imagemSaida = imagem.alargarContraste();
            ImageIO.write(imagemSaida, "jpg", new File(this.localImgSaida));
            System.out.println("Imagem Com alargamento de Contraste Criada!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Thread Alargamento de Contraste Finalizada!");
    }
}
