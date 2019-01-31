package javaExamples;

import java.util.HashMap;
import java.util.Map;

public class CountString {
    public static void main(String[] args) {
        String str = "102042025930110";
        char[] chArr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chArr) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        System.out.println(map);
    }
}

