package semester2.homework6;

import static semester2.homework6.HeapSort.printArray;

public class TestHomeWork6 {
    public static void main(String[] args) {
        int[] mass = {8, 1, 4, 9, 6, 2, 7, 3, 5, 0};
        HeapSort ob = new HeapSort();
        ob.sort(mass);
        printArray(mass);
    }
}
