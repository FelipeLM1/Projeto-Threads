package Threads;

import java.awt.image.BufferedImage;

public class EqualizacaoHistograma implements Runnable {

    public EqualizacaoHistograma(BufferedImage img) {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Thread - EqualizacaoHistograma");
        System.out.println("FIM THREAD - EQUALIZAÇÃO ");
    }
}
