import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CyclicBarrier cb;
    private static AtomicBoolean win = new AtomicBoolean(false);

    static {
        CARS_COUNT = 0;
        cb = new CyclicBarrier(MainClass.CARS_COUNT , new Runnable() {
            @Override
            public void run() {
                /*
                    Наверно не очень правильно объявление о начале гонки запускать в классе Car,
                    но иначе периодически поток Main не успевает отработать раньше остальных при
                    одновременном снятие барьера, приоритеты не особо помогли.
                 */
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        });
    }

    private CountDownLatch latch;
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch latch) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.latch = latch;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        latch.countDown();
        if (!win.get()){
            win.set(true);
            System.out.println(this.name + " - WIN");
        }

    }
}
