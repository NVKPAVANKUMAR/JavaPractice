package lambdaExpressionExample;

interface sayable {
    String say(String name);
}

public class LambdaExpressionExp3 {
    public static void main(String[] args) {
        sayable s1 = (name) -> {
            return "Hello " + name;
        };
        System.out.println(s1.say("Sonoo"));

        sayable s2 = name -> "Hello " + name;
        System.out.println(s2.say("Monaa"));
    }
}
