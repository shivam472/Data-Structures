public class circularLinkedList {

    Node head;
    Node tail;

    static class Node
    {
        int data; 
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void add(circularLinkedList list, int data)
    {
        
        Node newNode = new Node(data);
        if(list.head == null)
        {
            list.head = newNode;
            list.tail = newNode;
            newNode.next = list.head;
        }
        else if(list.head != null)
        {
            while(list.tail.next != list.head)
            {
                list.tail = list.tail.next;
            }
            if(list.tail.next == list.head)
            {
                list.tail.next = newNode;
                newNode.next = list.head;
            }
        }       
    }

    public static void insertAtBeg(circularLinkedList list, int data)
    {
        Node newNode = new Node(data);
        if(list.head == null)
        {
            list.head = newNode;
            newNode.next = list.head;
        }
        else
        {
            Node currentNode = list.head;
            while(currentNode.next != list.head)
            {
                currentNode = currentNode.next;
            }
            newNode.next = list.head;
            list.head = newNode;
            currentNode.next = list.head; 
        }
    }

    public static void insertAtEnd(circularLinkedList list, int data)
    {
        Node newNode = new Node(data);
        if(list.head == null)
        {
            list.head = newNode;
            newNode.next = list.head;
        }
        else
        {
            Node currentNode = list.head;
            while(currentNode.next != list.head)
            {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.next = list.head;
        }
    }
    public static void display(circularLinkedList list)
    {
        Node currentNode = list.head;
        System.out.println("List: ");
        do
        {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }while(currentNode != list.head);
    }
    public static void main(String[] args)
    {
        circularLinkedList list = new circularLinkedList();
        add(list,5);
        add(list,10);
        add(list,15);
        add(list,20);
        add(list,25);
        insertAtBeg(list, 2);
        insertAtEnd(list, 30);
        display(list);
    }

}