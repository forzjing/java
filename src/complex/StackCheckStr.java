package complex;

import java.util.Stack;

public class StackCheckStr {

	public static void main(String[] args) {
		//利用堆棧的概念，先进后出的原则判断对应的符号是否成对出现  
	    //定义一个字符串和栈  
	    String s="(){}[]";  
	    Stack ss=new Stack();  
	    boolean flag=true;  
	    char c;//定义一个char 遍历字符串的时候接收  
	    //依次遍历字符串，取出符号放入栈中  
	    for (int i = 0; i < s.length(); i++) {  
	        c=s.charAt(i);  
	        if (c=='('||c=='['||c=='{') {  
	        	System.out.println("push:"+c);
	            ss.push(c);//把符号压入到栈中  
	        }  
	        if (c==')'||c==']'||c=='}') {  
	            if (ss.isEmpty()) {  
	                flag=false;//栈是空的代表符号是成对出现的  
	                break;  
	            }else {  
	                //ss.peek()是调用栈顶部的对象 ss.pop()是一处堆栈顶部的对象  
	                if ((c==')'&&ss.peek()==(Object)'(')||(c==']'&&ss.peek()==(Object)'[')||(c=='}'&&ss.peek()==(Object)'{')) {  
	                	System.out.println("pop:"+c);
	                    ss.pop();//出栈  
	                } else {  
	                   flag=false;  
	                   break;  
	                }  
	            }  
	        }   
	    }  
	    //todo判断字符串种括号的顺序<]>[无效，<>[]有效。
	        if (!ss.isEmpty()) {  
	            flag=false;  
	        }  
	        if (flag) {  
	            System.out.println("该字符创串号配对，即符号成对出现");  
	        } else {  
	            System.out.println("该字符创串号不配对，即符号不成对出现");  
	        }   
	}
}
