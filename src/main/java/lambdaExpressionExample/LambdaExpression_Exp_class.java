package lambdaExpressionExample;


interface MyFuctionality {
    int addition(int a, int b);
}

public class LambdaExpression_Exp_class {
    public static void main(String[] args) {
        MyFuctionality obj = (a, b) -> a + b;
        System.out.println(obj.addition(10, 20));
    }
}
