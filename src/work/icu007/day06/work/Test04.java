package work.icu007.day06.work;

import java.util.Arrays;

public class Test04 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3};
        System.out.println(Arrays.toString(arr));
        System.out.println("----------- 升序：");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
