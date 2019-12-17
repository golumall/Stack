/*package whatever //do not write package name here */

import java.util.*;

class EvaluationExpression {
    static int applyOp(int a,int b,char op)
    {
        switch(op)
        {
            case '+':
                return b+a;
            case '-':
                return b-a;
            case '*':
                return b*a;
            case '/':
                return b/a;
            case '%':
                return b%a;
                
        }
        return -1;
    }
    static boolean isOperator(char op)
    {
        switch(op)
        {
            case '+':
            case '/':
            case '-':
            case '*':
            case '%':
                return true;
        }
        return false;
    }
    private static int evaluate(String s)
    {
        Stack<String>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(isOperator(s.charAt(i)))
              {
                  if(st.size()>=2)
                  {
                  int a=Integer.parseInt(st.pop());
                  int b=Integer.parseInt(st.pop());
                  String res=String.valueOf(applyOp(a,b,s.charAt(i)));
                  st.push(res);
                  }
                 else
                  return -1;
              }
            else
             st.push(Character.toString(s.charAt(i)));
        }
        return Integer.parseInt(st.pop());
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(evaluate(s));
	}
}
