import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestLesson6 {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {new int[]{4,4,2,3,4,5,0,5,4}},
            {new int[] {1,2,4,4,4,5,6,4,1,2}},
            {new int[]{1,2,5,6,1,2}},
            {new int[]{0}}
        });
    }
    private Lesson6 test;
    int[] arr;

    public TestLesson6(int... arr){
        this.arr = arr;
    }

    @Before
    public void init(){
        test = new Lesson6();

    }

    @Test
    public void testNumverAfterFour1 (){
        Assert.assertArrayEquals(new int[]{1,2}, test.numberAfterFour(arr));
    }

    @Test(expected = RuntimeException.class)
    public void testNumverAfterFour2 (){
        Assert.assertArrayEquals(new int[]{1,2}, test.numberAfterFour(arr));
    }

    @Test
    public void testoneAndFour(){
        Assert.assertTrue(test.oneAndFour(arr));
    }
}
