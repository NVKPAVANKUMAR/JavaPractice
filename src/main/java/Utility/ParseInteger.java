package Utility;

public class ParseInteger {
    public static void main(String[] args) {
        String s1 = "a djfnfw100sjdffe kver23 sdc wfqe ";
        String str = s1.replaceAll("[\\D]", "");
        System.out.println(str);
    }
}
