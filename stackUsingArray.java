public class stackUsingArray {
    static final int MAX = 5;
    int top;
    int stack[] = new int[MAX];

    stackUsingArray()
    {
        top = -1;
    }

    void PUSH(int ele)
    {
        if(top == MAX-1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        else{
            top++;
            stack[top] = ele;
        }
    }

    void POP()
    {
        if(top < 0)
        {
            System.out.println("Stack Underflow");
            return;
        }
        else
        {
            System.out.println("deleted element =" + stack[top]);
            top--;
        }
    }

    int PEEK()
    {
        if(top < 0)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            int x = stack[top];
            return x;
        }
    }

    void display()
    {
        System.out.print("stack: ");
        while(top >= 0)
        {
            System.out.print(stack[top] + " ");
            top--;
        }
    }
    
    public static void main(String[] args)
    {
        stackUsingArray s = new stackUsingArray();
        s.PUSH(10);
        s.PUSH(20);
        s.PUSH(30);
        s.PUSH(40);
        s.POP();
        s.PEEK();
        s.display();
    }
}
