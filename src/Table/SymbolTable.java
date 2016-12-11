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
	
	public int isInArray(String s){
		if(name.indexOf(s)==-1){
			name.add(s);
			System.out.println(s+" no "+name.indexOf(s));
			return name.indexOf(s);
		}
		else{
			System.out.println(s+" yes "+name.indexOf(s));
			return name.indexOf(s);
		}
		
	}
	
	public SymbolTable(){
		name = new ArrayList<String>();
		type = new ArrayList<String>();
		categary = new ArrayList<String>();
		address = new ArrayList<String>();
	}
}
