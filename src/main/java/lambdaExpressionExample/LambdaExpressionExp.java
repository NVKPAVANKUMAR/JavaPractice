package lambdaExpressionExample;

interface drawable {
    void draw();
}

public class LambdaExpressionExp {

    public static void main(String[] args) {
        int width = 10;
        drawable d2 = () -> System.out.println("Drawing : " + width);
        d2.draw();
    }
}
