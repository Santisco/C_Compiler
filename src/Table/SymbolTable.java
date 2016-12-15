package Table;

import java.util.ArrayList;

public class SymbolTable {
	
	public static ArrayList<String> name = new ArrayList<String>();
	public static ArrayList<String> type = new ArrayList<String>();
	public static ArrayList<String> categary = new ArrayList<String>();
	public static ArrayList<String> address = new ArrayList<String>();

	public String getter(){
		return "00";
	}
	public void setter(){}
	
	public static int isInArray(String s){
		if(SymbolTable.name.indexOf(s)==-1){
			SymbolTable.name.add(s);
			System.out.println(s+" no "+SymbolTable.name.indexOf(s));
			return SymbolTable.name.indexOf(s);
		}
		else{
			System.out.println(s+" yes "+SymbolTable.name.indexOf(s));
			return SymbolTable.name.indexOf(s);
		}
		
	}
	
	public SymbolTable(){
//		name = new ArrayList<String>();
//		type = new ArrayList<String>();
//		categary = new ArrayList<String>();
//		address = new ArrayList<String>();
	}
}
