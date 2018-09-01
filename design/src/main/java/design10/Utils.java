package design10;

public class Utils {

    private Utils() {}

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void check(int[] a) {
        if (null == a)
            throw new NullPointerException("a is null");
    }
}