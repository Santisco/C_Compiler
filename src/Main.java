import Parser.Parser;
import Scanner.Scanner;
import Table.StaticTable;
import Token.Quadruples;
import Token.Token;


public class Main {


	
		
		public static void main(String[] args){
			
			
			Parser parser=new Parser();
			System.out.println(
				parser.Parser("void main(){"
						+ " int i;"
						+ " int b[3] = {\"21312\", \"waduiog\", \"awd\"};"
						+ "int a = 3+4;"
						+ "int c = 3;"
						+ "c[3] = a+b;"
						+ "for(int m = 0; m < 92; m++){"
						+ "if(a>3){"
						+ "a = a+1;"
						+ "}"
						+ "}"
						+ "if(m&&28){"
						+ "}"
						+ "while(i<1){"
						+ "char b[3][4][5][6] = {\"gaiskuyhdgva\"};"
						+ "}"
						+ "while(i<9){"
						+ "}"	
						+ "}    ")
			);
			System.out.println(parser.tagX);
			System.out.println(parser.tagB);
			System.out.println(parser.tagR);
			for(int i=0;i<Quadruples.count;i++)
				System.out.println("("+Quadruples.quadruples[i].ope
						+","+Quadruples.quadruples[i].arg1
						+","+Quadruples.quadruples[i].arg2
						+","+Quadruples.quadruples[i].res+")");
			
		}
}
