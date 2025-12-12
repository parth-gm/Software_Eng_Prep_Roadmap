package inmemeorydb;
import java.util.*;
public class Table {
	String tableName;
	ArrayList<Row> rows;
	
	HashMap<String, Class> coloumnTypeMap;
	public Table(HashMap<String, Class> coloumnTypeMap) {
		this.coloumnTypeMap = coloumnTypeMap;
		rows = new ArrayList<>();
	}
	

	public boolean insert(Row row) throws Exception {
	
		if(validateColoumnTypes(row)) {
			rows.add(row);
			return true;
		}
		throw new Exception("Invalid Data type while Inserting!");

	}
	
	public boolean validateColoumnTypes(Row row) {
		for(String coloumn: row.rowMap.keySet()) {
			if(row.rowMap.get(coloumn).getClass() != coloumnTypeMap.get(coloumn)) {
				return false;
			}
		}
		return true;
	}
	
	public void printTable(HashMap<String, Object> filterMap) {
		
		for(int i=0;i<rows.size();i++) {
			Row currentRow = rows.get(i);
			for(String filterColoumn: filterMap.keySet()) {
				if(currentRow.rowMap.get(filterColoumn).getClass() == filterMap.get(filterColoumn).getClass() 
						&& currentRow.rowMap.get(filterColoumn)== filterMap.get(filterColoumn)) 
				{
					System.out.println(currentRow);
				}
			}	
		}
	}

	public void printTable() {
		
		for(int i=0;i<rows.size();i++) {
			Row currentRow = rows.get(i);
			System.out.println(currentRow);	
		}
		
	}
	
	
}
