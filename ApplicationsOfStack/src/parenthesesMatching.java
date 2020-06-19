import java.util.Scanner;

class stack
{
    int MAX = 10;
    int top = -1;
    char[] stack = new char[MAX];

    public void PUSH(char ch)
    {
        if(top == MAX-1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        else
        {
            top++;
            stack[top] = ch;
        }
    }
    public void POP()
    {
        if(top < 0)
        {
            System.out.println("Stack Underflow");
            return;
        }
        else
        {
            top--;
        }
    }
}
public class parenthesesMatching extends stack {
    
    public void isBalanced(char[] exp)
    {
        int i = 0;
        while(i < exp.length)
        {
            if(exp[i] == '(' || exp[i] == '{' || exp[i] == '[')
            {
                PUSH(exp[i]);
                i++;
                continue;
            }
             
            if(exp[i] == ')')
            {
                if(stack[top] == '(')
                {
                    POP();
                    i++;
                    continue;
                }
                else
                {
                    System.out.println("Parenthesis are not balanced");
                    return;
                }
                
            }
            if(exp[i] == '}')
            {
                if(stack[top] == '{')
                {
                    POP();
                    i++;
                    continue;
                }
                else
                {
                    System.out.println("Parenthesis are not balanced");
                    return;
                }
            }
            if(exp[i] == ']')
            {
                if(stack[top] == '[')
                {
                    POP();
                    i++;
                    continue;
                }
                else
                {
                    System.out.println("Parenthesis are not balanced");
                    return;
                }  
            } 
        }
        if(top != -1)
        {
            if(stack[top] != '(' || stack[top] != '{' || stack[top] != '[')
            {
                System.out.println("Parentheses are not balanced");
            }
        }
        else
        {
            System.out.println("Paranthesis are balanced");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many expression do you have?");
        int x = sc.nextInt();
        char[] exp = new char[x];
        System.out.println("Enter your expression"); 
        for(int i = 0; i < x; i++)
        {
            exp[i] = sc.next().charAt(0);
        }
        parenthesesMatching obj = new parenthesesMatching();
        obj.isBalanced(exp);
        sc.close();
    }
    
}
