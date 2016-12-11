package Table;

import java.util.ArrayList;

public class SymbolTable extends DynamicTable{
	
	public ArrayList<String> name;
	public ArrayList<String> type;
	public ArrayList<String> categary;
	public ArrayList<String> address;

	public String getter(){
		return "00";
	}
	public void setter(){}
	
	public SymbolTable(){
		name = new ArrayList<String>();
		type = new ArrayList<String>();
		categary = new ArrayList<String>();
		address = new ArrayList<String>();
	}
}
