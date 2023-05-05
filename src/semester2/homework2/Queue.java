package semester2.homework2;

public class Queue {

    private Node head;

    private Node tail;

    public Queue(){
        head = null;

    }

    private class Node{
        public int element;

        public Node next;

        public Node(int value){
            this.element = value;
            next = null;
        }


    }

    static Queue Create(){
        Queue queue = new Queue();
        queue.head = null;
        queue.tail = null;
        return queue;
    }

    public void Enqueue(Queue queue, int value){
        Node tmp = new Node(value);
        Node currentNode = queue.head;

        if (currentNode == null)
            queue.head = tmp;
            else
            queue.tail.next = tmp;

        queue.tail = tmp;
    }

    public int Dequeue(Queue queue){
        int outElement;
        if (queue.head != null){
            outElement = queue.head.element;
            queue.head = queue.head.next;
            return outElement;
        } else throw new NullPointerException("There is no queue");
    }

    public int Front(Queue queue){
        int outElement;
        if (queue.head != null){
            outElement = queue.head.element;
            return outElement;
        } else throw new NullPointerException("There is no queue");
    }

    public boolean IsEmpty(Queue queue){
        boolean isEmpty = false;
        if (queue.head == null)
            isEmpty = true;
        return isEmpty;
    }

    public void Vypis(Queue queue){
        Node tmp = queue.head;
        while (tmp != null){
            System.out.print(tmp.element + ", ");
            tmp = tmp.next;
        }
    }
}
