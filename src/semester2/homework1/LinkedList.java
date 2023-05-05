package semester2.homework1;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public class Node{
        public int element;
        public Node next;

        public Node(int element){
            this.element = element;
            next = null;
        }
    }
    
    public void add(int element){
        Node newNode = new Node(element);
        Node currentNode = head;

        if (head == null)
            head = newNode;
        else {
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = newNode;
        }
        
    }
    public void remove(int element){
        Node currentNode = head;
        Node previous = null;

        while (currentNode.next != null) {
            if (currentNode.element == element){
                if (currentNode == head)
                    head = currentNode.next;
                else
                    previous.next = currentNode.next;
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }
    }
    public void print(){
        Node currentNode = head;
        if (head != null)
            System.out.print(head.element + ", ");
        while (currentNode.next != null){
            currentNode = currentNode.next;
            System.out.print(currentNode.element + ", ");
        }
        System.out.println();
    }
    public int countOfElement(int element){
        Node currentNode = head;
        int count = 0;
        if (head == null) {
            System.out.println("There is no list");
            return count;
        }
        while (currentNode.next != null) {
            if (currentNode.element == element)
                count++;
            currentNode = currentNode.next;
        }
        if (currentNode.element == element)
            count++;
        return count;
    }
    public void deleteLast(int element){
        Node currentNode = head;
        Node previous = null;
        int index = 0;
        int indexFinal = 0;

        while (currentNode.next != null) {
            if (currentNode.element == element)
                index++;
            previous = currentNode;
            currentNode = currentNode.next;
            }
        if (currentNode.element == element)
            previous.next = null;
        else {
            currentNode = head;
            previous = null;
        }
        while (currentNode.next != null) {
            if (currentNode.element == element) {
                indexFinal++;
                if (indexFinal == index)
                    previous.next = currentNode.next;
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void deleteMax(){
        Node currentNode = head;
        Node previous = head;
        int index = 0;
        int max = 0;
        while (currentNode.next != null){
            index++;
            if (max < currentNode.element)
                max = currentNode.element;
            currentNode = currentNode.next;
        }
        if (currentNode.element > max)
            max = currentNode.element;
        currentNode = head;
        while (currentNode.next != null && max != 0){
            if (currentNode.element == max) {
                previous.next = currentNode.next;
                max = 0;
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }
    }
    public LinkedList Copy(){
        LinkedList listCopy = new LinkedList();
        Node currentNode = head;
        while (currentNode.next != null){
            listCopy.add(currentNode.element);
            currentNode = currentNode.next;
        }
        listCopy.add(currentNode.element);
        return listCopy;
    }
}
