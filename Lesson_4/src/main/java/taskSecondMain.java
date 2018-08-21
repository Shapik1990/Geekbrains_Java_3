import java.io.*;

public class taskSecondMain {

    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        try(final BufferedWriter out = new BufferedWriter(new FileWriter("src/main/java/test.txt"))) {

            for (int i = 0; i < 3; i++) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new taskSecondMain().write(out);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threads[i].start();
            }

            for (int i = 0; i < 3; i++) {
                threads[i].join();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write(BufferedWriter out) throws InterruptedException, IOException {
        synchronized (out){
            for (int i = 0; i < 10; i++) {
                out.write("Hi, i am " + Thread.currentThread().getName() + "\n");
                out.flush();
                out.wait(20);
            }
        }
    }
}
