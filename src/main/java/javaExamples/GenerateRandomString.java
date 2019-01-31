package javaExamples;

import java.util.Random;

public class GenerateRandomString {
    private static String generate(int n) {
        String atoz = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random(n);
        for (int i = 0; i < n; i++) {
            sb.append(atoz.charAt(rand.nextInt(atoz.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generate(10));
    }
}

