package Dop_Dz;

import java.io.*;
import java.util.ArrayList;

public class DopDZ {
    private BufferedReader in;
    private static ArrayList<BufferedReader> list = new ArrayList<>();

    public DopDZ(String path) {
        try {
            in = new BufferedReader(new FileReader(path));
            addlist(in);
            read();
            removeList(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void removeList(BufferedReader in) {
        synchronized (list) {
            list.remove(in);
            list.notifyAll();
        }
    }

    private void addlist(BufferedReader in) {

        while (true) {
            synchronized (list) {
                if(list.size() >= 4) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                else {
                    list.add(in);
                    break;
                }
            }
        }

    }


    private void read() throws IOException {
        String s;
        while ((s = in.readLine()) != null) {
            System.out.println(s + " " + Thread.currentThread().getName());
        }

    }
}
