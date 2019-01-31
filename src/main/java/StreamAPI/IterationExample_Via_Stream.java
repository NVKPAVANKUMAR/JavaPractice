package StreamAPI;

import java.util.stream.Stream;

public class IterationExample_Via_Stream {
    public static void main(String[] args) {
        Stream.iterate(1, count -> count + 1).
                filter(num -> num % 3 == 0).
                limit(6).
                forEach(System.out::println);
    }
}
