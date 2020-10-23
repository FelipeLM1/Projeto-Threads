package Threads;

import classes.Imagem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EqualizacaoHistograma implements Runnable {

    private String localImgSaida;
    private String localImgEntrada;

    public EqualizacaoHistograma(String localImgEntrada, String localImgSaida) {
        this.localImgEntrada = localImgEntrada;
        this.localImgSaida = localImgSaida;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        System.out.println("Thread Equalização de Histograma Iniciada!");
        try {
            BufferedImage img = ImageIO.read(new File(this.localImgEntrada));
            Imagem imagem = new Imagem(img);
            BufferedImage imagemSaida = imagem.equalizarHistograma();
            ImageIO.write(imagemSaida, "jpg", new File(localImgSaida));
            System.out.println("Imagem Com Equalização de Histograma criada!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Thread Equalização de Histograma Finalizada!");
    }
}
