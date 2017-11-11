package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String... args) {
        int[] arr = {6,4,1,8,9,2,7,5,3};
        arr = solution(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] solution(int[] arr) {
        if (arr == null) return null;
        int maxPos;

        for (int i = 0; i < arr.length - 1; i++) {
            maxPos = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[maxPos] > arr[k]) {
                    maxPos = k;
                }
            }
            arr = swapValue(arr, i, maxPos);
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
