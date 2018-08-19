package dop_DZ;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    private final String SERV_ADDREESS = "localhost";
    private final int PORT = 8189;
    private Socket socket;
    Student student;

    public static void main(String[] args) {
        new Client();
    }

    public Client(){
        System.out.println("Клиент запущен!");
        try {
            socket = new Socket(SERV_ADDREESS,PORT);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            try {
                student = (Student) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ois.close();
            student.getInfo();



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
