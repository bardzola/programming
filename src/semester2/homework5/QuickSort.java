package semester2.homework5;

public class QuickSort {
    public static void quickSort(int[] a, int l, int r){
        if (l < r){
            int q = partiton(a, l, r);
            quickSort(a, l, q);
            quickSort(a, q + 1, r);
        }
    }

    public static int partiton(int[] a, int l, int r){
        int v = a[(l + r)/2];
        int i = l;
        int j = r;
        while (i <= j){
            while (a[i] < v)
                i++;
            while (a[j] > v)
                j--;
            if (i >= j)
                break;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
        return j;
    }
}
