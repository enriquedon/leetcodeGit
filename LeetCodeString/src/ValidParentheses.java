import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class ValidParentheses {
	public static boolean isValid(String s) {
        if(s.length()==0) return true;
        Stack<Character> stack=new Stack<Character>();
        Set<Character> symbol=new HashSet<Character>();
        symbol.add('(');
        symbol.add('{');
        symbol.add('[');
        for(int i=0;i<s.length();i++){
            if(symbol.contains(s.charAt(i))){
                  stack.push(s.charAt(i));
            }else if(stack.size()==0){
            	System.out.println("stack.size()==0");
                return false;
                
            }else{
                char temp=stack.peek();
                if(check(temp,s.charAt(i))){
                    stack.pop();
                }else{
                    return false;
                }
                
            }
            System.out.println("stack.size():"+stack.size());
        }
        
        return stack.size()==0;
    }
    private static boolean check(char temp,char i){
    	System.out.println("temp:"+temp+" i:"+i);
        switch(temp){
            case '[':
                return i==']';
            case '(':
                return i==')';
            case '{':
                return i=='}';
            default:
            	return false;
        }
    }
    public static void main (String args[]) {
		String string="()[]{}";
		System.out.println(isValid(string));
	}
}
