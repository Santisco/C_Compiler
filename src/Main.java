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
						+ "struct A{"
						+ "int a;"
						+ "}a,b;"
						+ "int DAD(int a, int b){"
						+ "int a[3][2] = {2,3,4,5};"
						+ "int a[3] = {3};"

						+ "}"
						+ "void main(){"
						+ "int a[3][2] = {2,3,4,5};"
						+ "a[2*2][3+9][8][9] = 3;"	
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
			parser.ariSEM.forEach((i) -> System.out.println(i));
			
		}
}
