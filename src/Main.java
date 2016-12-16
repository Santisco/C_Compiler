import Parser.Parser;
import Scanner.Scanner;
import Table.StaticTable;
import Token.Token;


public class Main {

	public static void main(String[] args){
	
		
		Parser parser=new Parser("void main(){"
				+ "int j = 0;"
				+ "while(j < 1){"
				+ "j = j+1;"
				+ "}"
				+ "}   ");
		
		
		
		
		
		
		
	}
}
