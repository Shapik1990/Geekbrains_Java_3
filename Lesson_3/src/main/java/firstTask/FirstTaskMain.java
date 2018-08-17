package firstTask;

import java.io.*;

public class FirstTaskMain {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("src/main/java/firstTask/file.txt"));

        for (int i = 0; i < 20; i++) {
            out.writeChars(i + " " + "Hello world\n");
        }

        out.close();
        FileInputStream in = new FileInputStream("src/main/java/firstTask/file.txt");
        byte[] arr = new byte[in.available()];

        in.read(arr, 0 , in.available());

        for (int i = 0; i < arr.length; i++) {
            System.out.print((char)arr[i]);
        }

        in.close();

    }
}
