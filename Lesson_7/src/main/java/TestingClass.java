public class TestingClass {

    @BeforeSuite
    private void before(){
        System.out.println("Before");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("Test1");
    }
    @Test(priority = 3)
    private void test3(){
        System.out.println("Test3");
    }
    @Test(priority = 5)
    public void test5(){
        System.out.println("Test5");
    }
    @Test(priority = 4)
    public void test4(){
        System.out.println("Test4");
    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 5)
    public void test6(){
        System.out.println("Test6");
    }

    @AfterSuite
    private void after(){
        System.out.println("After");
    }
}
