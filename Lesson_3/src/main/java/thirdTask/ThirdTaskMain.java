package thirdTask;

import java.io.*;
import java.util.Scanner;

public class ThirdTaskMain {

    public static void main(String[] args) throws IOException {
        int page = 1800;
        int numberPage;

        FileInputStream in = new FileInputStream("src/main/java/thirdtask/test.txt");
        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите номер страницы :");

        numberPage = sc.nextInt() - 1;
        int x = -1;
        long time = System.currentTimeMillis();
        for (int i = 0;result.length() < 1800 &&(x = in.read()) != -1; i++){
            if(i >= page * numberPage) {
                result.append((char) x);
            }
        }
        System.out.println(result);
        System.out.println("\nВремя выполнения - " + ((double)(System.currentTimeMillis() - time) / 1000) + " сек");
    }
}
