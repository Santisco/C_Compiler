package Table;

import java.util.ArrayList;

public class ConstantTable extends DynamicTable{
	
	ArrayList<String> value = new ArrayList<String>();

	public String getter(){
		return "00";
	}
	public void setter(){}
	
	public ConstantTable(){}
}
