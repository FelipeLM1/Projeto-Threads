package classes;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Classe que representa uma imagem e suas propriedades
 */
public class Imagem {

    /**
     * Construtor da classe imagem
     * @param img
     */
    public Imagem(BufferedImage img) {
        setLargura(img.getWidth());
        setAltura(img.getHeight());
    }

    /**
     * Representa a largura da imagem
     */
    private int largura;

    /**
     * Representa a altura da imagem
     */
    private int altura;

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Método que retorna a matriz de cinza a partir do objeto BufferedImage fornecido
     * @param img
     * @return matrizCinza
     */
    public int[][] getMatrizCinza(BufferedImage img){
        int[][] matrizCinza = new int[this.largura][this.altura];
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                Color cor = new Color(img.getRGB(i, j));
                int tomCinza = cor.getRed();
                matrizCinza[i][j] = tomCinza;
            }
            System.out.println("");
        }

        return matrizCinza;
    }

    /**
     * Metodo de exibe a matriz cinza passada como parametro
     * @param matrizCinza
     */
    public void printMatrizCinza(int[][] matrizCinza){
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                System.out.print(matrizCinza[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Método que realiza o alargamento de contraste da imagem fornecida
     * @param matrizCinza
     */
    public void alargarContraste(int[][] matrizCinza){
        int iMax = 0;
        int iMin = 255;
        int [][] matrizContraste = new int[this.largura][this.altura];

        for (int i = 0; i < (this.largura)-1; i++) {
            for (int j = 0; j < (this.altura)-1; j++){
                if (matrizCinza[i][j] > iMax) {
                    iMax = matrizCinza[i][j];
                } else if(matrizCinza[i][j] < iMin) {
                    iMin = matrizCinza[i][j];
                }
            }
        }

        System.out.println("Imaior = "+iMax);
        System.out.println("Imenor = "+iMin);
    }
}
