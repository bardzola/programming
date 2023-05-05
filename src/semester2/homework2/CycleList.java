package semester2.homework2;

public class CycleList {

    public Node head;


    public CycleList(){
        head = null;
    }

    public class Node{
        public int element;

        public Node next;

        public Node previous;

        public Node(int value){
            this.element = value;
            next = null;
            previous = null;
        }
    }

    static CycleList Create(){
        CycleList cycleList = new CycleList();
        cycleList.head = null;
        return cycleList;
    }

    public CycleList InsertAfter(Node positionAfter, int value){
        CycleList cycleList = CycleList.Create();
        cycleList.head = head;
        Node currentNode = cycleList.head;
        Node newNode = new Node(value);
        if (currentNode == null){
            cycleList.head = newNode;
            cycleList.head.next = null;
            cycleList.head.previous = null;
            return cycleList;
        }
        if (currentNode.next == null){
            newNode.previous = currentNode;
            currentNode.next = newNode;
            newNode.next = currentNode;
            currentNode.previous = newNode;
            return cycleList;
        }

        while (currentNode != positionAfter){
            currentNode = currentNode.next;
        }
        newNode.next = currentNode.next;
        newNode.previous = currentNode;
        currentNode.next.previous = newNode;
        currentNode.next = newNode;
        return cycleList;
    }
}
