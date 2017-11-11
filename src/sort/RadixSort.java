package sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String... args) {
        int[] arr = new int[5];
        arr[0] = 52;
        arr[1] = 31;
        arr[2] = 24;
        arr[3] = 45;
        arr[4] = 13;

        sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }
    public static int[] sort(int[] arr) {
        int[] newArr = new int[100];
        int[] result = new int[arr.length];
        for (int item : arr) {
            newArr[item] = item;
        }
        int index = 0;
        for (int item : newArr) {
            if (item != 0) {
                result[index++] = item;
            }
        }
        return result;
    }

}
