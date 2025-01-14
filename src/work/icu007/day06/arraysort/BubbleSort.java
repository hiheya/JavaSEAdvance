package work.icu007.day06.arraysort;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1,3,5,4,2};
//        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("index: " +binarySearch(3, array) + " value: " + array[binarySearch(3, array)]);
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tempNum = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempNum;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] <= min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static int binarySearch(int num, int[] array) {
        int min = 0;
        int max = array.length - 1;
        while (min <= max) {
            int half = (min + max ) / 2;
            if (num > array[half]) {
                min = half + 1;
            } else if(num < array[half]) {
                max = half - 1;
            } else {
                return half;
            }
        }
        return -1;
    }

}
