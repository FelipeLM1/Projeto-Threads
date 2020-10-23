package Threads;

import classes.Imagem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EqualizacaoHistograma implements Runnable {

    private BufferedImage foto;

    public EqualizacaoHistograma(BufferedImage foto) {
        this.foto = foto;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Thread - EqualizacaoHistograma");
        Imagem imagem = new Imagem(this.foto);
        int[][] matrizCinza = imagem.getMatrizCinza(foto);
        int[] histograma = imagem.calcularHistograma(matrizCinza);
        double[] probabilidades = imagem.calcularProbabilidadeCinza(histograma);
        double[] probabilidadeAcumulada = imagem.calcularProbabilidadeAcumulada(probabilidades);
        int[][] matrizSaida = imagem.calculaEqualizacaoHistograma(matrizCinza, probabilidadeAcumulada);

        BufferedImage imagemSaida = imagem.matrizParaImg(matrizSaida);

        try {
            ImageIO.write(imagemSaida, "jpg", new File("C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\teste2.jpg"));
            //ImageIO.write(imagemSaida, "jpg", new File("/home/thuize/Documentos/UFRN/Projeto-Threads/src/out.jpg"));
            System.out.println("Imagem Com Equalização de Histograma criada!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("FIM THREAD - EQUALIZAÇÃO ");
    }
}
