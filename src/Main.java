import Parser.Parser;
import Scanner.Scanner;
import Table.Quadruples;
import Table.StaticTable;
import Token.Token;


public class Main {

	public static void main(String[] args){
	
		
		Parser parser=new Parser("void main(){"
				+ "int j=0,i;"
<<<<<<< HEAD
				+ "i=(1+2);"
=======
				+ "if(i < 1){"
				+ "int k;"
				+ "}"
				+ "else if(i > 1){"
				+ "k = k+1;"
				+ "}"
				+ "printf(j);"			
>>>>>>> origin/master
				+ "}   ");
		
		for(int i=0;i<Quadruples.count;i++)
			System.out.println("("+Quadruples.quadruples[i].arg1
					+","+Quadruples.quadruples[i].arg2
					+","+Quadruples.quadruples[i].ope
					+","+Quadruples.quadruples[i].res+")");
		
		
		
		
		
	}
}
