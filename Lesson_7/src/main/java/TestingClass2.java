public class TestingClass2{

    @Test(priority = 6)
    public void test1(){
        System.out.println("Test1");
    }
    @Test(priority = 8)
    public  void test3(){
        System.out.println("Test3");
    }
    @Test(priority = 10)
    public void test5(){
        System.out.println("Test5");
    }
    @Test(priority = 9)
    public void test4(){
        System.out.println("Test4");
    }
    @Test(priority = 7)
    public void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 10)
    public void test6(){
        System.out.println("Test6");
    }

}
