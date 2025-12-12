package inmemeorydb;

import java.util.HashMap;

public class Row {
	
	HashMap<String, Object> rowMap;
	
	public Row(HashMap<String, Object> map) {
		this.rowMap = map; 
	}
	
	public Class<? extends Object> getType(String coloumn) {
		return rowMap.get(coloumn).getClass();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(String key:rowMap.keySet()) {
			sb.append(key+":");
			sb.append(rowMap.get(key) + ", ");
			
		}
		return sb.toString();
	}
	
}
