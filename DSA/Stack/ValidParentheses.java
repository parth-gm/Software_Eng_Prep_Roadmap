package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean checkMatch(char schar,char stackchar){
        if((schar=='}' && stackchar=='{')|| (schar==']' && stackchar=='[') || (schar==')' && stackchar=='('))
            return true;
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else {
                if(stack.empty() || !checkMatch(s.charAt(i),stack.peek())){
                    return false;
                }
                stack.pop();

            }
        }

        return stack.isEmpty();

    }
}
