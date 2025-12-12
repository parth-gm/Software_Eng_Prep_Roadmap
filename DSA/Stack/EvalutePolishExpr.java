//public class EvalutePolishExpr {
//
//	static int evalutePolishExpr(String postfixStr, MyStack<Integer> stack) {
//	
//		for(int i=postfixStr.length()-1;i>=0;i--) {
//			char current=postfixStr.charAt(i);
//			if(Character.isDigit(current)) {
//				stack.push(Character.getNumericValue(current));
//			}else {
//				int opr1=stack.pop();
//				int opr2=stack.pop();
//				int result=eval(opr1,opr2,current);
//				stack.push(result);
//			}
//		}
//		return stack.pop();
//	}
//	
//	
//	static int eval(int opr1, int opr2, char current) {
//		 
//		 switch(current) {
//		 	case '+':
//		 		return opr1+opr2;
//		 	case '-':
//		 		return opr1-opr2;
//		 	case '*':
//		 		return opr1*opr2;
//		 	case '/':
//				return opr1/opr2;
//		 	case '^':
//		 		return (int)Math.pow(opr1, opr2);
//		 	default:
//		 		System.out.println("invalid operator");
//		}
//		return Integer.MIN_VALUE; 
//		
//	}
//
//	public static void main(String[] args) {
//		
//		MyStack<Integer> stack=new MyStack<Integer>();
//		String prefixStr="-+*53/847";
//		//String prefixStr1="*+13-23";
//
//		System.out.println(evalutePolishExpr(prefixStr,stack));
//		
//
//	}
//}
