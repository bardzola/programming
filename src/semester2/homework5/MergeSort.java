package semester2.homework5;

public class MergeSort {
    public static void merge(int[] a, int left, int middle, int right){
        int it1 = 0;
        int it2 = 0;
        int[] result = new int[right - left];
        while (left + it1 < middle && middle + it2 < right){
            if (a[left + it1] < a[middle + it2]){
                result[it1 + it2] = a[left + it1];
                it1++;
            } else {
                result[it1 + it2] = a[middle + it2];
                it2++;
            }
        }
        while (left + it1 < middle){
            result[it1 + it2] = a[left + it1];
            it1++;
        }
        while (middle + it2 < right){
            result[it1 + it2] = a[middle + it2];
            it2++;
        }
        for (int i = 0; i < it1 + it2; i++)
            a[left + i] = result[i];
    }

    public static void mergeSortIterative(int[] a){
        for (int i = 1; i <= a.length; i *= 2)
            for (int j = 0; j < a.length - i; j += 2 * i)
                merge(a, j, j + i, Math.min(j + 2 * i, a.length));
    }
}
