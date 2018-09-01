package design10;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] a) {
        Utils.check(a);
        QuickSort.quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int keyIndex = partition(a, low, high);
        quickSort(a, low, keyIndex - 1);
        quickSort(a, keyIndex + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int left = low, right = high;
        int keyValue = a[low];
        while (left < right) {
            while (right > left && a[right] >= keyValue) right--;
            while (left < right && a[left] <= keyValue) left++;
            if (left < right) Utils.swap(a, left, right);
        }
        a[low] = a[left];
        a[left] = keyValue;
        return left;
    }
}