package inmemeorydb;

import java.util.HashMap;

public class Database {
	
	HashMap<String, Table> tableMap;
	
	public Database(HashMap<String, Table> tableMap) {
		this.tableMap = tableMap;
	}
	
	public boolean createTable(String tableName, Table table) throws Exception {
		if(!tableMap.containsKey(tableName)) {
			tableMap.put(tableName, table);
			return true;
		}else
			throw new Exception("Table Already Exist!");
	}
	
	public boolean removeTable(String tableName) throws Exception {
		if(tableMap.containsKey(tableName)) {
			tableMap.remove(tableName);
			return true;
		}else
			throw new Exception("Table Does not Exist!");
	}
	
}
