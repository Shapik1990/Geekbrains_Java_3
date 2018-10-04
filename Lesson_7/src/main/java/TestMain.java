import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class TestMain {

    public static void main(String[] args) throws Exception {
        start(TestingClass.class);
        System.out.println("-----------------");
        start(TestingClass2.class);
        System.out.println("-----------------");
        start(TestingClass3.class);
    }

    public static void start(Class cl) throws Exception {
        Method before = null;
        Method after = null;
        Object testing = cl.newInstance();
        ArrayList<Method> tests = new ArrayList<Method>();
        Method[] methods = cl.getDeclaredMethods();

        for(Method m : methods){
            if(m.isAnnotationPresent(BeforeSuite.class)){
                if (before == null) {
                    before = cl.getDeclaredMethod(m.getName());
                    before.setAccessible(true);
                }
                else{
                    throw new RuntimeException("Более одного метода с аннотацией @BeforeSuite");
                }
            }
            if(m.isAnnotationPresent(AfterSuite.class)){
                if (after == null) {
                    after = cl.getDeclaredMethod(m.getName());
                    after.setAccessible(true);
                }
                else{
                    throw new RuntimeException("Более одного метода с аннотацией @AfterSuite");
                }
            }
            if(m.isAnnotationPresent(Test.class)) {
                tests.add(cl.getDeclaredMethod(m.getName()));
                tests.get(tests.indexOf(cl.getDeclaredMethod(m.getName()))).setAccessible(true);

            }
        }

        tests.sort(new Comparator<Method>() {
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
            }
        });

        if(before != null){
            before.invoke(testing);
        }

        for (Method m : tests){
            m.invoke(testing);
        }

        if(after != null){
            after.invoke(testing);
        }
    }
}
