import Threads.AlargamentoContraste;
import Threads.EqualizacaoHistograma;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        //String localImgEntrada = "/home/thuize/Documentos/UFRN/Projeto-Threads/src/balloons.png";
        String localImgEntrada = "C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\balloons.png";

        String localImgSaida1 = "C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\thread1.jpg";
        //String localImgSaida = "/home/thuize/Documentos/UFRN/Projeto-Threads/src/out.jpg";

        String localImgSaida2 = "C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\thread2.jpg";
        //String localImgSaida = "/home/thuize/Documentos/UFRN/Projeto-Threads/src/out.jpg";
        
        AlargamentoContraste thread1 = new AlargamentoContraste(localImgEntrada, localImgSaida1);
        EqualizacaoHistograma thread2 = new EqualizacaoHistograma(localImgEntrada, localImgSaida2);

    }
}
