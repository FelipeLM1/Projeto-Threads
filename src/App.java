import Threads.AlargamentoContraste;
import Threads.EqualizacaoHistograma;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            //String pathImg = "/home/thuize/Documentos/UFRN/Projeto-Threads/src/balloons.png";
            String pathImg = "C:\\Users\\Programação\\Desktop\\Threads - Projeto\\Projeto-Threads\\src\\balloons.png";
            BufferedImage img = ImageIO.read(new File(pathImg));

            AlargamentoContraste thread1 = new AlargamentoContraste(img);
            EqualizacaoHistograma thread2 = new EqualizacaoHistograma(img);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
