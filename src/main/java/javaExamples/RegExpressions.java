package javaExamples;

public class RegExpressions {
    public static void main(String[] args) {
        String str = "ABC_DAEC_DFRE_T";
        String s = str.replaceAll("(\\w)([\\_])(\\w)", " ");
        System.out.println(s);
    }
}
