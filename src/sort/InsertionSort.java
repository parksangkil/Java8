package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String... args) {
        int[] arr = {6,4,1,8,9,2,7,5,3};
        arr = solution(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] solution(int[] arr) {
        if (arr == null) return null;
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int k;
            for (k = i - 1; k >= 0; k--) {
                if (temp >= arr[k]) {
                    break;
                }
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = temp;
        }

        return arr;
    }

}
