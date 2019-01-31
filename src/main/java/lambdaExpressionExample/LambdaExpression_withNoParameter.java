package lambdaExpressionExample;

interface MyFunctionalInterface {
    String sayHello();
}

public class LambdaExpression_withNoParameter {
    public static void main(String[] args) {
        MyFunctionalInterface obj = () -> "Hello!";
        System.out.println(obj.sayHello());

        MyFunctionalInterface obj1 = () -> "World!";
        System.out.println(obj1.sayHello());
    }
}
