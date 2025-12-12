package hackerrank;

public class Trie {

	TriNode root;
	
	public Trie() {
		root=new TriNode();
	}
	
	public void insert(String word) {
		TriNode node=root;
		for(int i=0;i<word.length();i++) {
			if(node.children[word.charAt(i)-'a']==null) {
				node.children[word.charAt(i)-'a']=new TriNode();
			}
			node =node.children[word.charAt(i)-'a'];
		}
		node.isEnd=true;
	}
	
	public boolean search(String word) {
		
		TriNode node=root;
		
		for(int i=0;i<word.length();i++) {
			if(node.children[word.charAt(i)-'a']==null) {
				return false;
			}
			node=node.children[word.charAt(i)-'a'];
		}
		return node.isEnd;
		
	}
	
	public boolean startWith(String word) {
		
		TriNode node=root;
		
		for(int i=0;i<word.length();i++) {
			if(node.children[word.charAt(i)-'a']==null) {
				return false;
			}
			node=node.children[word.charAt(i)-'a'];
		}
		return true;
	}
	
	public boolean delete(String word) {
		
		TriNode node=root;
		
		for(int i=0;i<word.length();i++) {
			char c=word.charAt(i);
			if(node.children[word.charAt(i)-'a']==null) {
				return false;
			}
			node=node.children[c-'a'];
		}
		if(node.isEnd==false) {
			System.out.println("cannot delete");
			return false;
		}else {
			node.isEnd=false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		  String keys[] = {"the", "a", "there", "answer", "any", 
                  "by", "bye", "their"}; 
		
		 String output[] = {"Not present in trie", "Present in trie"}; 
		
		
		 Trie root = new Trie(); 
		 
		 for (int i = 0; i < keys.length ; i++) 
		     root.insert(keys[i]); 
		
		 // Search for different keys 
		 if(root.search("the") == true) 
		     System.out.println("the --- " + output[1]); 
		 else System.out.println("the --- " + output[0]); 
		   
		 if(root.search("these") == true) 
		     System.out.println("these --- " + output[1]); 
		 else System.out.println("these --- " + output[0]); 
		   
		 if(root.search("their") == true) 
		     System.out.println("their --- " + output[1]); 
		 else System.out.println("their --- " + output[0]); 
		   
		 if(root.search("thaw") == true) 
		     System.out.println("thaw --- " + output[1]); 
		 else System.out.println("thaw --- " + output[0]); 

	}

}
