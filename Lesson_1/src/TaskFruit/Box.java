package TaskFruit;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> amountOfFruit;

    public Box(){
        amountOfFruit = new ArrayList<T>();
    }

    public Box(T... fruits){
        amountOfFruit = new ArrayList<T>();
        for (T f : fruits){
            amountOfFruit.add(f);
        }
    }

    public void addFruit (T fruit){
        amountOfFruit.add(fruit);
    }

    public float getWeight(){
        float sum = 0;

        for (T f : amountOfFruit){
            sum += f.getFruitWeight();
        }

        return sum;
    }

    public boolean compare (Box<? extends Fruit> box){
        return this.getWeight() == box.getWeight();
    }

    public void moveToBox (Box<T> box){

        for (T f : amountOfFruit){
            box.addFruit(f);
        }
        amountOfFruit.clear();
    }
}
