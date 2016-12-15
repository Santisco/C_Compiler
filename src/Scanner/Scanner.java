package Scanner;

import java.util.ArrayList;
import java.util.LinkedList;

import Table.CharacterTable;
import Table.NumberTable;
import Table.StaticTable;
import Table.SymbolTable;
import Token.Token;

public class Scanner {

	public ArrayList<Token> token = new ArrayList<Token>();
	LinkedList<String> Code=new LinkedList<String>();//代码
//	SymbolTable st=new SymbolTable();
//	CharacterTable ct=new CharacterTable();
//	NumberTable nt=new NumberTable();
	public Scanner(String str){
		int i,j;
		for(i=0;i<str.length()-3;i++){
			if(Character.isDigit(str.charAt(i))){
				j=i;
				while(str.charAt(j)!=' '&&StaticTable.isBoundaryWord(str.substring(j, j+1))==-1){
					j++;
				}
				if(isNum(str.substring(i, j)))
					token.add(new Token("NumberTable", NumberTable.isInArray(str.substring(i, j))));
				else
					System.err.println("ERR");
				i=j-1;
			}
			else if(Character.isLetter(str.charAt(i))||str.charAt(i)=='_'){
				j=i;
				while(str.charAt(j)!=' '&&StaticTable.isBoundaryWord(str.substring(j, j+1))==-1)
					j++;
				String string=str.substring(i,j);
				if(StaticTable.isKeyWord(string)!=-1){
					token.add(new Token("KeyWordTable", StaticTable.keyWord.indexOf(string)));
					System.out.println(string+" key "+StaticTable.keyWord.indexOf(string));
				}
				else if(isIdentifier(string)){
					token.add(new Token("SymbolTable", SymbolTable.isInArray(string)));
				}
				else
					System.out.println("Err");
				i=j-1;
			}
			else if(StaticTable.isBoundaryWord(str.substring(i, i+1))!=-1){
				if(str.charAt(i)=='\"'){
					j=i+1;
					while(str.charAt(j)!='\"'){
						if(str.charAt(j)=='\n')
							System.err.println("ERR");
						j++;
					}
					token.add(new Token("BoundaryWord",StaticTable.boundaryWord.indexOf("\"")));
					System.out.println("\""+" bound "+StaticTable.boundaryWord.indexOf("\""));
					token.add(new Token("CharacterTable", CharacterTable.isInArray(str.substring(i+1, j))));
					token.add(new Token("BoundaryWord",StaticTable.boundaryWord.indexOf("\"")));
					System.out.println("\""+" bound "+StaticTable.boundaryWord.indexOf("\""));
					i=j;
				}
				else if(str.substring(i, i+1).equals("'")){
					j=i+1;
					while(str.charAt(j)!='\''){
						if(str.charAt(j)=='\n')
							System.err.println("ERR");
						j++;
					}
					token.add(new Token("BoundaryWord",StaticTable.boundaryWord.indexOf("'")));
					System.out.println("'"+" bound "+StaticTable.boundaryWord.indexOf("'"));
					token.add(new Token("CharacterTable", CharacterTable.isInArray(str.substring(i+1, j))));
					token.add(new Token("BoundaryWord",StaticTable.boundaryWord.indexOf("'")));
					System.out.println("'"+" bound "+StaticTable.boundaryWord.indexOf("'"));
					i=j;
				}
				else{
					if(StaticTable.isBoundaryWord(str.substring(i,i+2))!=-1){
						token.add(new Token("BoundaryWord", StaticTable.boundaryWord.indexOf(str.substring(i,i+2))));
						System.out.println(str.substring(i,i+2)+" bound "+StaticTable.boundaryWord.indexOf(str.substring(i,i+2)));
						i=i+1;
					}
					else if(StaticTable.isBoundaryWord(str.substring(i,i+1))!=-1){
						token.add(new Token("BoundaryWord", StaticTable.boundaryWord.indexOf(str.substring(i,i+1))));
						System.out.println(str.substring(i,i+1)+" bound "+StaticTable.boundaryWord.indexOf(str.substring(i,i+1)));
					}
					else
						System.err.println("ERR");
				}
			}
		}
		token.add(new Token("BoundaryWord", StaticTable.boundaryWord.indexOf("#")));
		token.add(new Token("BoundaryWord", StaticTable.boundaryWord.indexOf("#")));
	}
	
	//是否是标识符
	boolean isIdentifier(String s){
		String a=s.substring(0,1);
		if((a.compareTo("a")>=0&&a.compareTo("a")<=25)
				||(a.compareTo("A")>=0&&a.compareTo("A")<=25)
				||a.equals("_")){
			for(int i=1;i<s.length();i++){
				String b=s.substring(i,i+1);
				if((b.compareTo("a")>=0&&b.compareTo("a")<=25)
						||(b.compareTo("A")>=0&&b.compareTo("A")<=25)
						||(b.compareTo("0")>=0&&b.compareTo("0")<=9)
						||b.equals("_"))
					continue;
				else
					return false;
			}
			return true;
		}
		else
			return false;
	}
	//是否是常数
	boolean isNum(String s){
		String str=s.substring(0, 1);
		int count_point=0;
		for(int i=0;i<s.length()-1;i++){
			String a=s.substring(i, i+1);
			if(a.compareTo("0")>=0&&a.compareTo("0")<=9)
				continue;
			else if(a.equals("."))
				count_point++;
			else
				return false;
		}
		if(count_point==0||count_point==1){
			return true;
		}
		else
			return false;
	}
	
}
