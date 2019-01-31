package Utility;

public class ExtractInt {
    public static void main(String[] args) {
        String str = "THis is 100";
        int s = Integer.parseInt(str.replaceAll("THis is ", ""));
        System.out.println(s);
    }
}
