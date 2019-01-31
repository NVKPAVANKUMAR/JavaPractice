package lambdaExpressionExample;


interface MyFunctionalInterface2 {
    String sconcat(String str1, String str2);
}

public class LambdaExpression_with_multiple_parameters {
    public static void main(String[] args) {
        MyFunctionalInterface2 obj = (str1, str2) -> str1 + str2;
        System.out.println(obj.sconcat("Hello ", "lambda!"));
    }

}
