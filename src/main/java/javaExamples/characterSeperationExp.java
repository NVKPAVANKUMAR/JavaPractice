package javaExamples;

import java.util.ArrayList;
import java.util.List;

public class characterSeperationExp {
    static List<Character> alphabetsList = new ArrayList<Character>();
    static List<Character> numericalList = new ArrayList<Character>();
    static List<Character> specialCharacterList = new ArrayList<Character>();

    public static void main(String[] args) {
        String str = "ADCVMserfc@#$%^124567";
        char[] chArr = str.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if ((chArr[i] >= 'A' && chArr[i] <= 'Z') || (chArr[i] >= 'a' && chArr[i] <= 'z')) {
                alphabetsList.add(chArr[i]);
            } else if (chArr[i] >= '0' && chArr[i] <= '9') {
                numericalList.add(chArr[i]);
            } else {
                specialCharacterList.add(chArr[i]);
            }
        }
        System.out.println(alphabetsList);
        System.out.println(numericalList);
        System.out.println(specialCharacterList);
    }
}
