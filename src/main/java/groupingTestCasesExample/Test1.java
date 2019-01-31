package groupingTestCasesExample;

import org.testng.annotations.Test;

public class Test1 {
    @Test(groups = {"functest", "checkintest"})
    public void test1() {
        System.out.println("This is test1");
    }

    @Test(groups = {"functest", "checkintest"})
    public void testMethod2() {
        System.out.println("This is test2");
    }

    @Test(groups = {"functest"})
    public void testMethod3() {
        System.out.println("This is test3");
    }

    @Test(groups = {"checkintest"})
    public void testMethod4() {
        System.out.println("This is test4");
    }


}
