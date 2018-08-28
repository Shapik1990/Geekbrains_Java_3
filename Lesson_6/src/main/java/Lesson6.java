

public class Lesson6 {

    public int[] numberAfterFour(int ... mass) throws RuntimeException{
        int x = -1;
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] == 4){
                x = i + 1;
            }
        }

        if(x == -1){
            throw new RuntimeException();
        }
        else {
            int[] arr = new int[mass.length - x ];

            for (int i = x, j = 0; i < mass.length; i++, j++) {
                arr[j] = mass[i];
            }
            return arr;
        }
    }

    public boolean oneAndFour(int ... mass){
        boolean one = false;
        boolean four = false;

        for(int x : mass){
            if (x == 1){
                one = true;
            }
            if(x == 4){
                four = true;
            }
            if(one && four){
                return true;
            }
        }

        return false;
    }

}
