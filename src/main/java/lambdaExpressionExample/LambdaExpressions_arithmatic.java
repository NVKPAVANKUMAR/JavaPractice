package lambdaExpressionExample;

import java.util.Scanner;

interface Arithmatic {
    int operation(int a, int b);
}

public class LambdaExpressions_arithmatic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first number : ");
        int num1 = scan.nextInt();
        System.out.println("Enter second number : ");
        int num2 = scan.nextInt();
        int value1 = (num1 > num2) ? num1 : num2;
        int value2 = (num1 < num2) ? num1 : num2;

        Arithmatic addition = (a, b) -> a + b;
        System.out.println("sum is " + addition.operation(value1, value2));

        Arithmatic subtraction = (a, b) -> a - b;
        System.out.println("diff is " + subtraction.operation(value1, value2));

        Arithmatic multiplication = (a, b) -> a * b;
        System.out.println("product is " + multiplication.operation(value1, value2));

        Arithmatic division = (a, b) -> a / b;
        System.out.println("divide is : " + division.operation(value1, value2));

        Arithmatic modulus = (a, b) -> a % b;
        System.out.println("modulus is : " + modulus.operation(value1, value2));
    }
}
