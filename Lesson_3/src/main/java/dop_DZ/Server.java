package dop_DZ;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket client;
    Student student = new Student("Вася", 15, new Book("book"));


    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            client = server.accept();
            System.out.println("Клиент подключился.");
            student.getInfo();
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(student);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
