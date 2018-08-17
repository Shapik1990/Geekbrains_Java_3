package secondTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SecondTaskMain {
    public static void main(String[] args) throws IOException {
        DataOutputStream[] outStreams = new DataOutputStream[5];
        ArrayList<InputStream> inputStreams = new ArrayList<InputStream>();

        for (int i = 0; i < 5; i++) {
            outStreams[i] = new DataOutputStream(new FileOutputStream("src/main/java/secondTask/file" + i + ".txt"));
            for (int q = 0; q < 10; q++){
                outStreams[i].writeChars("Hello file" + i + "!!!\n");
            }
            outStreams[i].close();
            inputStreams.add(new FileInputStream("src/main/java/secondTask/file" + i + ".txt"));
        }

        SequenceInputStream seq = new SequenceInputStream(Collections.enumeration(inputStreams));

        byte[] buffer = new byte[512];
        FileOutputStream outAll = new FileOutputStream("src/main/java/secondTask/fileAll.txt");
        int x;
        while ((x = seq.read(buffer)) != -1){
            outAll.write(buffer);
        }

        seq.close();
        outAll.close();

    }
}
