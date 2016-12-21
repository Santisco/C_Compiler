import Parser.Parser;
import Scanner.Scanner;
import Table.StaticTable;
import Token.Quadruples;
import Token.Token;


public class Main {

	public static void main(String[] args){
	
		
		Parser parser=new Parser("void main(){"
				+ "int j = 0;"
				+ "if(2 || j > 1){"
				+ "}"
				+ "else if(j > 10){"
				+ "}"
				+ "else{"
				+ "}"
				+ "for(int i = 0; i <¡¡10; i++){"
				+ "while(i > 3){"
				+ "}"
				+ "}"		
				+ "}   ");
		
		for(int i=0;i<Quadruples.count;i++)
			System.out.println("("+Quadruples.quadruples[i].ope
					+","+Quadruples.quadruples[i].arg1
					+","+Quadruples.quadruples[i].arg2
					+","+Quadruples.quadruples[i].res+")");
		
	}
}
