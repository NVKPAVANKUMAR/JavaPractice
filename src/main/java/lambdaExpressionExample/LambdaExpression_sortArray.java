package lambdaExpressionExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class LambdaExpression_sortArray {
    public static void main(String[] args) {
        String[] arr = {"program", "creek", "is", "a", "java", "site"};
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(arr));

        Stream<String> stream = Stream.of(arr);
        stream.forEach(System.out::println);


    }
}
