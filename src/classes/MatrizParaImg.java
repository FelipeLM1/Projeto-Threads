package classes;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class MatrizParaImg {

    public BufferedImage setPixelEscalaDeCinza(int[][] mtzImg) {
        //matriz que vc passa como parâmetro definindo a largura da imagem
        int largura = mtzImg.length,
                //matriz que vc passa como parâmetro definindo a altura da imagem
                altura = mtzImg[0].length;


        //criando uma objeto BufferedImage a partir das dimensões da imagem representada pela matriz
        BufferedImage image = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);


        WritableRaster raster = image.getRaster();
        for (int h = 0; h < largura; h++) {
            for (int w = 0; w < altura; w++) {
                raster.setSample(h, w, 0, mtzImg[h][w]);
            }
        }

        return image;
    }
}
