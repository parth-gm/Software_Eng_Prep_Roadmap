package Ch01_Arrays_Strings;

public class OneAway {
	
	static void checkOneAway(String strs[]) {
		
		for(int i=0;i<strs.length;i=i+2) {
			int lendiff=strs[i].length()-strs[i+1].length();
			if(lendiff>1 || lendiff<-1 ) System.out.println(strs[i]+" "+strs[i+1]+": "+"False");
			
			if(lendiff==0) {
				for(int j=0;j<strs[i].length();j++)
				{
					if(strs[i].charAt(j)!=strs[i+1].charAt(j)) {
						if (strs[i].substring(j+1).equals(strs[i+1].substring(j+1)))
							System.out.println(strs[i]+" "+strs[i+1]+": "+"True");
						else
							System.out.println(strs[i]+" "+strs[i+1]+": "+"False");
						break;
						
					}
				}
			}
			else {
				String longstr,shortstr;
				if(lendiff==1) {
					longstr=strs[i];
					shortstr=strs[i+1];
				}else
				{
					longstr=strs[i+1];
					shortstr=strs[i];
				}
				boolean check=false;
				int j=0;
				for(j=0;j<shortstr.length();j++)
				{
					if(longstr.charAt(j)!=shortstr.charAt(j)) {
						check=true;
						if (longstr.substring(j+1).equals(shortstr.substring(j)) )
							System.out.println(strs[i]+" "+strs[i+1]+": "+"True");
						else
							System.out.println(strs[i]+" "+strs[i+1]+": "+"False");
						
						break;
					}
					
					
				}
				if(check==false && j==shortstr.length())
					System.out.println(strs[i]+" "+strs[i+1]+": "+"True");
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] test= {"pale","ple","pale","bake","pale","bale","pale","pales","palee","pale","pale","pkle","pse","pale"};
		String[] test= {"a", "b", "", "d","d", "de","pale", "pse","acdsfdsfadsf", "acdsgdsfadsf", "acdsfdsfadsf", "acdsfdfadsf", "acdsfdsfadsf", "acdsfdsfads","acdsfdsfadsf", "cdsfdsfadsf","adfdsfadsf", "acdfdsfdsf", "adfdsfadsf", "bdfdsfadsg", 
			"adfdsfadsf", "affdsfads", 
			"pale", "pkle",
			"pkle", "pable"};
		
		checkOneAway(test);

	}

}
