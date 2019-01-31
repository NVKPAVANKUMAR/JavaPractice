package javaExamples;


import java.util.Scanner;

public class ArrayExp {
    static int[] test1 = {100, 90, 80};
    static int[] test2 = {60, 70, 90};
    static int[] test3 = {80, 90, 100};


    public ArrayExp(int[] test1, int[] test2, int[] test3) {
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }

    private static int caluclateTotal(Integer[] input) {
        int total = 0;
        for (int i = 0; i < input.length; i++) {
            total += input[i];
        }
        return total;
    }


    private static void receiveMarks() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter person name : ");
            String name = scan.nextLine();
            for (int j = 0; j < 3; j++) {
                int[] marksArray = new int[3];
                System.out.println("Enter " + name + " marks : ");
                marksArray[i] = scan.nextInt();
            }
        }

    }
}
