import Parser.Parser;
import Scanner.Scanner;
import Table.StaticTable;
import Token.Quadruples;
import Token.Token;


public class Main {

	public static void main(String[] args){
	
		
		Parser parser=new Parser();
		System.out.println(
			parser.Parser(""
					+ ""
					+ "void main(){"
					+ "a[2]=b[a+1][a+vdf];"
					+ "if(1){}"
					+ "}   ")
		);
		
		for(int i=0;i<Quadruples.count;i++)
			System.out.println("("+Quadruples.quadruples[i].ope
					+","+Quadruples.quadruples[i].arg1
					+","+Quadruples.quadruples[i].arg2
					+","+Quadruples.quadruples[i].res+")");
		System.out.println(parser.tagX+","+parser.tagB+","+parser.tagR);
	}
}
