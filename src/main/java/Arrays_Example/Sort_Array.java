package Arrays_Example;

import java.util.Arrays;

public class Sort_Array {
    public static void main(String[] args) {
        int temp;
        int[] arr = {10, 70, 50, 19, 89, 32, 45, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
