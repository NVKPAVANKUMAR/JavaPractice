package lambdaExpressionExample;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionExp_ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ankit");
        list.add("manyak");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                System.out::println
        );

        System.out.println("----------------------------");

        list.forEach(
                n -> System.out.println(n)
        );
        System.out.println("----------------------------");

        for (String s : list) {
            System.out.println(s);
        }

    }
}
