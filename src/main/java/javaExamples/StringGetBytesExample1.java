package javaExamples;

public class StringGetBytesExample1 {
    public static void main(String[] args) {
        String str = "ABCDEF";
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }
        String s = new String(str);
        System.out.println(s);
    }
}
