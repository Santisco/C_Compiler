package Table;

import java.util.ArrayList;

public class CharacterTable extends DynamicTable{
	
	ArrayList<String> character = new ArrayList<String>();

	public String getter(){
		return "00";
	}
	public void setter(){}
	
	public int isInArray(String s){
		if(character.indexOf(s)==-1){
			character.add(s);
			System.out.println(s+" no "+character.indexOf(s));
			return character.indexOf(s);
		}
		else{
			System.out.println(s+" yes "+character.indexOf(s));
			return character.indexOf(s);
		}
	}
	
	public CharacterTable(){}
}
