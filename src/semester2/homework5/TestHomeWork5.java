package semester2.homework5;

public class TestHomeWork5 {
    public static void main(String[] args) {
        int[] mass = {8, 1, 4, 9, 6, 2, 7, 3, 5, 0};
        QuickSort.quickSort(mass, 0, mass.length - 1);
        //MergeSort.mergeSortIterative(mass);
        for (int i = 0; i < mass.length; i++)
            System.out.print(mass[i] + ", ");
    }
}
