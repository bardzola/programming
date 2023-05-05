package semester2.homework1;

public class TestHomeWork1 {
    public static void testHomeWork1() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println(list.countOfElement(5));
        list.deleteLast(4);
        list.print();
        list.deleteMax();
        list.print();
        LinkedList newList = list.Copy();
        newList.print();
    }



}