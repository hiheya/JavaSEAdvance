package work.icu007.day06.work;

import java.util.Arrays;

public class Test03 {
    public static void main(String[] args) {
        int[] arr = {1,2,432,32,54,32,3,7,657,563,25,43,6,463,52};

        System.out.println(Arrays.toString(arr));
        System.out.println("------------- 冒泡排序：");
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
