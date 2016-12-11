import Scanner.Scanner;

import Table.StaticTable;
import Token.Token;


public class Main {

	public static void main(String[] args){
	
		Scanner scanner=new Scanner("int main(){"
				+ "int i,sum=0;"
				+ "for(i=0;i<1.0.0;i++){"
				+ "    sum+=i;"
				+ "}"
				+ "char a[10]=\"10.0.20\";"
				+ "char b='0';"
				+ "return 0;"
				+ "}   ");
		
		for(int i=0;i<scanner.token.size();i++)
			System.out.println(scanner.token.get(i).tableName+scanner.token.get(i).tableIndex);
		
	}
}
