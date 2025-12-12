package practice;

import java.util.ArrayList;


public class NewKeyboard {


	//HE*<LL>O
	 public static String receivedTextv1(String S) {
		 
		 ArrayList<Integer> arrl=new ArrayList<Integer>();
		 
		 
		 for(int i=0;i<S.length();i++) {
			 if(S.charAt(i)=='*'|| S.charAt(i)=='<' || S.charAt(i)=='>'|| S.charAt(i)=='#' )
			 {
				 arrl.add(i);
			 }
		 }
		 System.out.println(arrl.toString());
		 
		 
		 
		 return "";
	 }
	
	
	 public static String receivedText(String S) {

		 boolean isNumericLock=true;
		 StringBuffer sb=new StringBuffer();
		 int currentIndex=0;
		 boolean isEndReach=false;
		 while(currentIndex<S.length() && (!isEndReach)) {
			 char cmd=S.charAt(currentIndex);
			 
			 switch(cmd) {
			 	case '*':
			 		if(sb.length()>0)
			 			sb.deleteCharAt(sb.length()-1);
			 		currentIndex++;
			 		break;
			 	case '<':
			 		currentIndex++;
			 		int fromStart=0;
			 		while(currentIndex<S.length() && S.charAt(currentIndex)!='*' && S.charAt(currentIndex)!='<' && S.charAt(currentIndex)!='>' && S.charAt(currentIndex)!='#' )
			 		{
			 			if(Character.isDigit(S.charAt(currentIndex)) ) {
			 				if(isNumericLock)
			 					sb.insert(fromStart, S.charAt(currentIndex));
			 			}else {
			 				sb.insert(fromStart, S.charAt(currentIndex));
			 			}
			 			
			 			
			 			fromStart++;
			 			currentIndex++;
			 		}
			 		if(currentIndex==S.length())
			 			isEndReach=true;
			 		break;
			 	case '>':
			 		
			 		currentIndex++;
			 		while(currentIndex<S.length() && S.charAt(currentIndex)!='*' && S.charAt(currentIndex)!='<' && S.charAt(currentIndex)!='>' && S.charAt(currentIndex)!='#' )
			 		{
			 			if(Character.isDigit(S.charAt(currentIndex)) ) {
			 				if(isNumericLock)
			 					sb.append(S.charAt(currentIndex));
			 			}else {
			 				sb.append(S.charAt(currentIndex));
			 			}
			 			
			 			currentIndex++;
			 		}

			 		if(currentIndex==S.length())
			 			isEndReach=true;
			 		
			 		
			 		break;
			 	case '#':
			 		currentIndex++;
			 		if(isNumericLock)
			 			isNumericLock=false;
			 		else
			 			isNumericLock=true;
			 		break;
			 	default :
			 		if(Character.isDigit(cmd) ) {
		 				if(isNumericLock)
		 					sb.append(cmd);
		 			}else {
		 				sb.append(cmd);
		 			}
			 		currentIndex++;
			 		
			 }
			 
		 }
		 
		
		 return sb.toString();
		 

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(receivedText("HE*<LL>O#123"));
		System.out.println(receivedTextv1("HE*<LL>O#123"));
		

	}

}
