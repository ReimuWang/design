package design10;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] a) {
        Utils.check(a);
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) Utils.swap(a, j, j + 1);
            }
        }
    }
}