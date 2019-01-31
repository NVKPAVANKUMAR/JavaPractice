package StreamAPI;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> intOptional = numbers.reduce((i, j) -> i * j);
        intOptional.ifPresent(System.out::println);
        Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(numbers1.count());
        Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
        numbers2.forEach(System.out::println);
    }
}
