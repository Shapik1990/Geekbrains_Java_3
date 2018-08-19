package Dop_Dz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DopDzMain {
    public static void main(String[] args) throws IOException {
        final String path = "src/main/java/dop_dz/dop_DZ.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 100; i++) {
            bw.write(i + "\n");
        }
        bw.flush();

        bw.close();

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    DopDZ dz = new DopDZ(path);
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
