package classes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * Classe que representa uma imagem e suas propriedades
 */
public class Imagem {

    /**
     * Construtor da classe imagem
     *
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
     *
     * @param img
     * @return matrizCinza
     */
    public int[][] getMatrizCinza(BufferedImage img) {
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
     *
     * @param matrizCinza
     */
    public void printMatrizCinza(int[][] matrizCinza) {
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                System.out.print(matrizCinza[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Método que realiza o alargamento de contraste da imagem fornecida
     *
     * @param matrizCinza
     */
    public int[][] alargarContraste(int[][] matrizCinza) {
        int iMax = 0;
        int iMin = 255;
        int[][] matrizContraste = new int[this.largura][this.altura];

        for (int i = 0; i < (this.largura) - 1; i++) {
            for (int j = 0; j < (this.altura) - 1; j++) {
                if (matrizCinza[i][j] > iMax) {
                    iMax = matrizCinza[i][j];
                } else if (matrizCinza[i][j] < iMin) {
                    iMin = matrizCinza[i][j];
                }
            }
        }

        for (int i = 0; i < (this.largura) - 1; i++) {
            for (int j = 0; j < (this.altura) - 1; j++) {
                int novoPixel = (255 / (iMax - iMin)) * (matrizCinza[i][j] - iMin);
                matrizContraste[i][j] = novoPixel;
            }
        }
        return matrizContraste;
    }

    /**
     * Método para transformar uma matriz em imagem
     *
     * @param mtzImg
     * @return imagem
     */
    public BufferedImage matrizParaImg(int[][] mtzImg) {

        //criando uma objeto BufferedImage a partir das dimensões da imagem representada pela matriz
        BufferedImage image = new BufferedImage(this.largura, this.altura, BufferedImage.TYPE_BYTE_GRAY);

        WritableRaster raster = image.getRaster();
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                raster.setSample(i, j, 0, mtzImg[i][j]);
            }
        }
        return image;
    }

    /**
     * Faz a contagem de pixels para cada um dos 256 níveis de
     * cinza que a imagem possui.
     *
     * @param mtzImg
     * @return
     */
    public int[] calcularHistograma(int[][] mtzImg) {
        int[] histograma = new int[255];
        for (int i = 0; i < histograma.length; i++) {
            histograma[i] = 0;
        }

        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                histograma[(mtzImg[i][j])]++;
            }
        }

        return histograma;
    }

    /**
     * Calcula a probabilidade de ocorrência de cada nível de cinza
     *
     * @param histograma
     * @return
     */
    public double[] calcularProbabilidadeCinza(int[] histograma) {
        double[] probabilidades = new double[255];
        int dimensao = (this.altura * this.largura);
        double contador = 0d;
        for (int i = 0; i < probabilidades.length; i++) {
            probabilidades[i] = 0d;
        }

        for (int i = 0; i < probabilidades.length; i++) {
            probabilidades[i] = ((double) histograma[i] / dimensao);
            System.out.println(i + ": " + probabilidades[i]);
            contador += probabilidades[i];
        }

        System.out.println("contador: " + contador);


        return probabilidades;
    }

    /**
     * calcula o acúmulo da probabilidade de
     * ocorrência da intensidade do pixel correspondente da imagem
     *
     * @param probabilidade
     * @return
     */
    public double[] calcularProbabilidadeAcumulada(double[] probabilidade) {
        double[] probabilidadeAcumulada = new double[255];
        //inicializa o vetor com zeros
        for (int i = 0; i < probabilidadeAcumulada.length; i++) {
            probabilidadeAcumulada[i] = 0;
        }
        double cont;

        for (int i = 0; i < probabilidadeAcumulada.length; i++) {
            cont = 0;
            for (int j = 0; j < i; j++) {
                cont = (cont + probabilidade[j]);
            }
            probabilidadeAcumulada[i] = cont;
        }

        return probabilidadeAcumulada;
    }

    public int[][] calculaEqualizacaoHistograma(int[][] matrizImg, double[] probabilidadeAcumulada) {
        int[][] matrizSaida = new int[this.largura][this.altura];

        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                matrizSaida[i][j] = 0;
            }
        }
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                matrizSaida[i][j] = (int) (255 * probabilidadeAcumulada[matrizImg[i][j]]);
            }
        }

        return matrizSaida;
    }


}
