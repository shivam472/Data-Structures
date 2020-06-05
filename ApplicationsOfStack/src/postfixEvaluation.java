public class postfixEvaluation
{
    static int top = -1;
    static int max = 10;
    static int[] stackArray = new int[max];
    
    static class stack
    {
        public void PUSH(int n)
        {
            if(top == max-1)
            {
                System.out.println("Stack Overflow");
                return;
            }
            else
            {
                top++;
                stackArray[top] = n;
            }
        }
        public int POP()
        {
            if(top == -1)
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                return stackArray[top--];
            }
        }
    }
    public int postfixEval(String exp)
    {
        stack newStack = new stack();
        
        for(int i = 0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
            {
                newStack.PUSH(ch - '0');
            }
            else
            {
                int val1 = newStack.POP();
                int val2 = newStack.POP();

                switch(ch)
                {
                    case '+': 
                    newStack.PUSH(val2+val1); 
                    break; 
                      
                    case '-': 
                    newStack.PUSH(val2- val1); 
                    break; 
                      
                    case '/': 
                    newStack.PUSH(val2/val1); 
                    break; 
                      
                    case '*': 
                    newStack.PUSH(val2*val1); 
                    break; 
                }
            }
        }
        return newStack.POP();
    }
    public static void main(String[] args)
    {
        postfixEvaluation obj = new postfixEvaluation();
        String exp="231*+9-"; 
        System.out.println("postfix evaluation: "+ obj.postfixEval(exp)); 
    }
}