package lambdaExpressionExample;

interface addable {
    int add(int a, int b);
}

public class LambdaExpressionExp4 {
    public static void main(String[] args) {

        addable add1 = (a, b) -> a + b;
        System.out.println(add1.add(10, 20));

        // second way to write

        addable add2 = (int a, int b) -> a + b;
        System.out.println(add2.add(40, 50));

        // third way to write

        addable add3 = (a, b) -> a + b;
        System.out.println(add3.add(1, 2));
    }
}
