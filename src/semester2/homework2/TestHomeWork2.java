package semester2.homework2;

public class TestHomeWork2 {
    public static void testHomeWork2() {
        Queue queue = Queue.Create();
        queue.Enqueue(queue, 4);
        queue.Enqueue(queue, 5);
        queue.Enqueue(queue, 7);
        int a = queue.Dequeue(queue);
        int b = queue.Front(queue);
        boolean c = queue.IsEmpty(queue);
        queue.Vypis(queue);
        CycleList cycleList = CycleList.Create();
        cycleList.InsertAfter(cycleList.head, 8);
        cycleList.InsertAfter(cycleList.head, 9);
        cycleList.InsertAfter(cycleList.head, 10);
        //cycleList = cycleList.InsertAfter(cycleList.head.next, 2);
    }
}