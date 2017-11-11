package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String... args) {
        int[] arr = {2,1,4,0,3, 7, 6, 5};
        arr = sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swapValue(arr, i, j);
                }
            }
        }
        return arr;
    }

    public static int[] swapValue(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
