package complex;

import java.util.Stack;

public class StackCheckStr {

	public static void main(String[] args) {
		//���öї��ĸ���Ƚ������ԭ���ж϶�Ӧ�ķ����Ƿ�ɶԳ���  
	    //����һ���ַ�����ջ  
	    String s="(){}[]";  
	    Stack ss=new Stack();  
	    boolean flag=true;  
	    char c;//����һ��char �����ַ�����ʱ�����  
	    //���α����ַ�����ȡ�����ŷ���ջ��  
	    for (int i = 0; i < s.length(); i++) {  
	        c=s.charAt(i);  
	        if (c=='('||c=='['||c=='{') {  
	        	System.out.println("push:"+c);
	            ss.push(c);//�ѷ���ѹ�뵽ջ��  
	        }  
	        if (c==')'||c==']'||c=='}') {  
	            if (ss.isEmpty()) {  
	                flag=false;//ջ�ǿյĴ�������ǳɶԳ��ֵ�  
	                break;  
	            }else {  
	                //ss.peek()�ǵ���ջ�����Ķ��� ss.pop()��һ����ջ�����Ķ���  
	                if ((c==')'&&ss.peek()==(Object)'(')||(c==']'&&ss.peek()==(Object)'[')||(c=='}'&&ss.peek()==(Object)'{')) {  
	                	System.out.println("pop:"+c);
	                    ss.pop();//��ջ  
	                } else {  
	                   flag=false;  
	                   break;  
	                }  
	            }  
	        }   
	    }  
	    //todo�ж��ַ��������ŵ�˳��<]>[��Ч��<>[]��Ч��
	        if (!ss.isEmpty()) {  
	            flag=false;  
	        }  
	        if (flag) {  
	            System.out.println("���ַ���������ԣ������ųɶԳ���");  
	        } else {  
	            System.out.println("���ַ������Ų���ԣ������Ų��ɶԳ���");  
	        }   
	}
}
