package lambdaExpressionExample;

interface MyFunctionalInterface1 {
    int incrementByFive(int a);
}

public class LambdaExpression_with_one_paramter {
    public static void main(String[] args) {
        MyFunctionalInterface1 obj = a -> a + 5;
        System.out.println(obj.incrementByFive(22));
    }

}
