package TaskFruit;

public class Main {
    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<Orange>(new Orange(), new Orange());
        Box<Apple> appleBox = new Box<Apple>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox1 = new Box<Orange>();
        System.out.println("Вес первой коробки с апельсинами - " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками - " + appleBox.getWeight());
        System.out.println("Вес второй (пустой) коробки с апельсинами - " + orangeBox1.getWeight());
        System.out.println("Сравнение первой коробки с апельсинами и коробки яблоками - " + orangeBox.compare(appleBox));
        orangeBox1.addFruit(new Orange());
        orangeBox.moveToBox(orangeBox1);
        System.out.println("Вес первой коробки после перемещения апельсинов во вторую коробку - " + orangeBox.getWeight());
        System.out.println("Вес второй коробки с апельсинами после пермещения апельсинов - " + orangeBox1.getWeight());
        System.out.println("Сравнение второй коробки с апельсинами и коробки яблоками - " + orangeBox1.compare(appleBox));
    }
}
