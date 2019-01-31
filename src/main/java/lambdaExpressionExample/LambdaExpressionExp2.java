package lambdaExpressionExample;

interface Sayable {
    String say();
}

public class LambdaExpressionExp2 {
    public static void main(String[] args) {
        Sayable s1 = () -> "I have nothing to say";
        System.out.println(s1.say());
    }
}
