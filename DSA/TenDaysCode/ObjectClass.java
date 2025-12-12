package TenDaysCode;

import java.util.StringTokenizer;

public class ObjectClass {
	public String line;
	public String[] strs;
	public static int key;
	public static String compareType;
	public ObjectClass(String s) {
		this.line=s;
		StringTokenizer st=new StringTokenizer(s," ");
		strs=new String[st.countTokens()];
		int i=0;
		while(st.hasMoreElements())
			strs[i++]=(String) st.nextElement();
	}
	
	 public String toString() 
	 { 
		return this.line;
	 }           
	

	
}
