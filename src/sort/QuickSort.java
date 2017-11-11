package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String... args) {
        int[] arr = {6,4,1,8,0,2,7,5,9,3};
        //int[] arr = {};
        arr = solution(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] solution(int[] arr, int left, int right) {
        if (arr == null) return null;

        if (left >= right) return arr;

        int pivotPos = partition(arr, left, right);

        arr = solution(arr, left, pivotPos - 1);
        arr = solution(arr, pivotPos + 1, right);

        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        if (arr == null || left > 0) return -1;
        int pivotValue = arr[right];
        int endOfLowBlock = left - 1;

        for (int pos = left; pos < right; pos++) {
            if (pivotValue > arr[pos]) {
                endOfLowBlock += 1;
                swapValue(arr, pos, endOfLowBlock);
            }
        }
        endOfLowBlock += 1;
        swapValue(arr, right, endOfLowBlock);

        return endOfLowBlock;
    }

    public static int[] swapValue(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
