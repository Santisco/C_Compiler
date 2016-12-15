package Table;

import java.util.ArrayList;

public class NumberTable{

	public static ArrayList<String> number = new ArrayList<String>();

	public String getter(){
		return "00";
	}
	public void setter(){}
	
	public static int isInArray(String s){
		if(number.indexOf(s)==-1){
			number.add(s);
			System.out.println(s+" no "+number.indexOf(s));
			return number.indexOf(s);
		}
		else{
			System.out.println(s+" yes "+number.indexOf(s));
			return number.indexOf(s);
		}
	}
	
	public NumberTable(){}
}
