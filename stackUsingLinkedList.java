public class stackUsingLinkedList {

    Node top;
    static class Node
    {
        int data;
        Node link;
        Node(int d)
        {
            data = d;
        }
    }
    stackUsingLinkedList()
    {
        top = null;
    }

    public void PUSH(int ele) 
    {
        Node temp = new Node(ele);
        if(top == null)
        {
            top = temp;
        }
        else
        {
            temp.link = top;
            top = temp;
        }
    }

    public void POP() 
    {
        if(top == null)
        {
            System.out.println("stack underflow");
            return;
        }
        else
        {
            top = top.link;
        }
    }

    public int PEEK()
    {
        if(top == null)
        {
            System.out.println("stack underflow");
            return 0;
        }
        else
        {
            int x = top.data;
            return x;
        }
    }

    public void display()
    {
        Node currentNode = top;
        while(currentNode != null)
        {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.link;
        }
    }
    public static void main(String[] args)
    {
        stackUsingLinkedList obj = new stackUsingLinkedList();
        obj.PUSH(10);
        obj.PUSH(5);
        obj.PUSH(15);
        obj.PUSH(20);
        obj.POP();
        System.out.println(obj.PEEK());
        obj.display();
    }
}