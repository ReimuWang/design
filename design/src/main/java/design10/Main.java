package design10;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 3, 2, 1};
        Sort sort = new QuickSort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}