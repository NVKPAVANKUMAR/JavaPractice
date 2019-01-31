package Arrays_Example;

import java.util.Arrays;

public class Sort_Array_Practice {
    public static void main(String[] args) {
        int temp;
        int[] arr = {1, 45, 32, 67, 56, 10};
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
