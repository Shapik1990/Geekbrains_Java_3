import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Homework {

    public static void main(String[] args) {
        // Тест первого пункта домашнего задания
        Integer[] arrInt = {1,2,3,4,5};
        String[] arrStr = {"1","2","3","4","5"};
        Double[] arrDouble = {1.0, 2.5, 5.5,86.3};

        swap(1, 2, arrInt);
        System.out.println("arrInt - " + Arrays.toString(arrInt));
        swap(5, 2, arrInt);
        System.out.println("arrInt - " + Arrays.toString(arrInt));
        swap(2, 0, arrStr);
        System.out.println("arrStr - " + Arrays.toString(arrStr));
        swap(0, 3, arrDouble);
        System.out.println("arrDouble - " + Arrays.toString(arrDouble));

        // Тест второго пункта домашнего задания

        ArrayList <Integer> arrayInt = arrToArrayList(arrInt);
        System.out.println("\nВторой пункт задания \n" + arrayInt.toString());
        ArrayList <Double> arrayDouble = arrToArrayList(arrDouble);
        System.out.println(arrayDouble);
        ArrayList<String> arrayStr= arrToArrayList(arrStr);
        System.out.println(arrayStr);
    }

    // Первый пункт домашнего задания
    public static <T> void swap (int firstElement, int secondElement, T[] arr){

        if(firstElement > arr.length - 1 || firstElement < 0) {
            System.out.println("Указанный индекс первого элемента выходит за пределы массива");
            return;
        }
        if(secondElement > arr.length - 1 || secondElement < 0) {
            System.out.println("Указанный индекс второго элемента выходит за пределы массива");
            return;
        }
        if(firstElement == secondElement)
            return;

        T a = arr[firstElement];
        T b = arr[secondElement];

        arr[firstElement] = b;
        arr[secondElement] = a;
    }

    // Второй пункт домашнего задания
    public static <T> ArrayList<T> arrToArrayList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
