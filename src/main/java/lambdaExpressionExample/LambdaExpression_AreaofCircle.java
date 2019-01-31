package lambdaExpressionExample;

interface Circle {
    double area(double r);
}

public class LambdaExpression_AreaofCircle {
    public static void main(String[] args) {
        Circle obj = r -> (Math.PI * r * r);
        System.out.println(obj.area(6));
    }
}
