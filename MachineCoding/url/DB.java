package url;

import java.util.HashMap;

public class DB {
	
	HashMap<String , String> map;
	
	DB(){
		map = new HashMap<String, String>();
	}
	
	 boolean isKeyExists(String key){
		return map.containsKey(key);
	}
	
}
