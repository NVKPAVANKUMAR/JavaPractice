package javaExamples;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class StringMethods {
    public static void main(String[] args) {
        String str = "$17000";
        String result = str.substring(1);
        System.out.println(result);
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        String s5 = s1.intern();
        String s6 = s3.intern();
        String s7 = new String("World");
        String s8 = s7.intern();

        // == reference comparsion
        System.out.println(s1 == s2); // true
        System.out.println(s2 == s3); // false
        System.out.println(s3 == s4); // false
        System.out.println(s1 == s5); // true
        System.out.println(s2 == s5); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s1 == s6); // true
        System.out.println(s7 == s8); // false
        System.out.println("------------------------------------");

        // content comparsion
        System.out.println(s1.equals(s2)); // true
        System.out.println(s2.equals(s3)); // true
        System.out.println(s3.equals(s4)); // true
        System.out.println(s1.equals(s5)); // true
        System.out.println(s1.equals(s6)); // true


        String joinString = String.join("-", "welcome", "to", "java");
        System.out.println(joinString);


        StringSelection ss = new StringSelection("c:/file.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());

    }
}
