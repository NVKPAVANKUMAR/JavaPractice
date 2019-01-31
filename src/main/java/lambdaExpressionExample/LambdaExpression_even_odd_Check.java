package lambdaExpressionExample;

interface EvenOdd {
    void check(int a);
}

public class LambdaExpression_even_odd_Check {
    public static void main(String[] args) {
        EvenOdd obj = a -> {
            if (a % 2 == 0) {
                System.out.println(a + " is Even");
            } else {
                System.out.println(a + " is Odd");
            }
        };

        obj.check(10);
        obj.check(11);
    }

}
