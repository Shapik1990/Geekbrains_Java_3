public class MFU {
    private final String printer = "Отпечатано ";
    private final String scanner = "Отсканировано ";

    public static void main(String[] args) {
        final MFU mfu = new MFU();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.scaning(Thread.currentThread().getName());
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.print(Thread.currentThread().getName());
                }
            }).start();
        }

    }

    public void scaning(String nameThread){
        synchronized (scanner){
            for (int i = 1; i <= 5; i++) {
                System.out.println(nameThread + ": " + scanner + i + " страниц");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void print(String nameThread){
        synchronized (printer){
            for (int i = 1; i <= 5; i++) {
                System.out.println(nameThread + ": " + printer + i + " страниц");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
