package javaExamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class characterCount {
    private static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String str = "ABBCCCCDDDDDEEEEEE";
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i) + "") == null) {
                map.put(str.charAt(i) + "", new Integer(1));
            } else {
                Integer count = map.get(str.charAt(i) + "");
                map.put(str.charAt(i) + "", count + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " count is : " + entry.getValue());
        }

        Set<String> keys = map.keySet();
        System.out.println(keys);
    }
}
