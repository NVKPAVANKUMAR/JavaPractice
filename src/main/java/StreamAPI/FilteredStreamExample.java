package StreamAPI;


import java.util.ArrayList;
import java.util.List;

public class FilteredStreamExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Ajeet");
        names.add("Negan");
        names.add("Aditya");
        names.add("Steve");
        names.forEach(p -> System.out.println(p.length() > 5));
        long count = names.stream().filter(str -> str.length() < 6).count();
        System.out.println(count);

    }


}
