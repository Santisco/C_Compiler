package Parser;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BoundedRangeModel;

import Scanner.Scanner;
import Table.CharacterTable;
import Table.NumberTable;
import Table.StaticTable;
import Table.SymbolTable;
import Token.Token;

public class Parser {
	
	  String w;
	  int i;
	  private ArrayList<Token> token = new ArrayList<Token>();
	  public Parser(String str){
		  Scanner sc = new Scanner(str);
		  this.token = sc.token;
		  for(int i=0;i<token.size();i++)
				System.out.println(token.get(i).tableName+token.get(i).tableIndex);
		  System.out.println(M());
	  }
	  
	  public String Search(int i){
		  Token t = new Token();
		  t = token.get(i);
		  String name = t.tableName;
		  switch(name){
		  case "NumberTable":
			  return NumberTable.number.get(t.tableIndex);
		  case "KeyWordTable":
			  return StaticTable.keyWord.get(t.tableIndex);
		  case "SymbolTable":
			  return SymbolTable.name.get(t.tableIndex);
		  case "BoundaryWord":
			  return StaticTable.boundaryWord.get(t.tableIndex);
		  case "CharacterTable":
			  return CharacterTable.character.get(t.tableIndex);
		  }
		  return null;
	  }
	  
	  public boolean M(){
		  w = Search(i++);
		  System.out.println(w);
		  if(w.equals("void")){
			  w = Search(i++);
			  System.out.println(w);
			  if(w.equals("main")){
				  w = Search(i++);
				  System.out.println(w);
				  if(w.equals("(")){
					  w = Search(i++);
					  System.out.println(w);
					  if(w.equals(")")){
						  w = Search(i++);
						  System.out.println(w);
						  if(w.equals("{")){
							  w = Search(i++);
							  System.out.println(w);
							  if(A()){
								  if(w.equals("}")){
									  w = Search(i++);
									  System.out.println(w);
									  if(w.equals("#")){
										  return true;
									  }
								  }  
							  }
						  }
					  }
				  }
			  }
		  }
		  return false;
	  }
	  
	  public boolean A(){
		  System.out.println("A()");
		  if(C()){
			  if(A()){
				  return true;
			  }
			  else
				  return false;
		  }
		  return true;
	  }
	  
	  public boolean C(){
		  System.out.println("C()");
		  if(X())
			  return true;
		  else if(B())
			  return true;
		  else if(R())
			  return true;
		  else
			  return false;  
	  }
	  
	  public boolean X(){
		  System.out.println("X()");
		  if(Y()){
			  if(Z()){
				  if(w.equals(";")){
					  w=Search(i++);
					  return true;
				  }
				  else
					  return false;
			  }
			  else
				  return false;
		  }
		  return false;
	  }
	  
	  public boolean Y(){
		  System.out.println("Y()");
		  if(w.equals("int")){
			  w = Search(i++);
			  System.out.println(w);
			  return true;
		  }
		  else if(w.equals("char")){
			  w = Search(i++);
			  System.out.println(w);
			  return true;
		  }
		  else if(w.equals("double")){
			  w = Search(i++);
			  System.out.println(w);
			  return true;
		  }
		  else if(w.equals("float")){
			  w = Search(i++);
			  System.out.println(w);
			  return true;
		  }
		  else if(w.equals("long")){
			  w = Search(i++);
			  System.out.println(w);
			  return true;
		  }
		  else if(w.equals("bool")){
			  w = Search(i++);
			  System.out.println(w);
			  return true;
		  }
		  else
			  return false;
	  }
	  
	  public boolean Z(){
		  System.out.println("Z()");
		  if(V()){
			  if(Z1())
				  return true;
		  }
		  return false;
	  }
	  
	  public boolean Z1(){
		  System.out.println("Z1()");
		  if(w.equals(",")){
			  w = Search(i++);
			  System.out.println(w);
			  if(Z())
				  return true;
			  else
				  return false;
		  }
		  return true;
	  }
	  
	  public boolean V(){
		  System.out.println("V()");
		  if(SymbolTable.name.contains(w)){
			  w = Search(i++);
			  System.out.println(w);
			  if(V1())
				  return true;
			  else
				  return false;
		  }
		  else
			  return false;
	  }
	  
	  public boolean V1(){
		  System.out.println("V1()");
		  if(w.equals("=")){
			  w = Search(i++);
			  System.out.println(w);
			  if(L()){
				  return true;
			  }
			  else
				  return false;
		  }
		  return true;
	  }
	  
	  public boolean R(){
		  System.out.println("R()");
		  if(SymbolTable.name.contains(w)){
			  w = Search(i++);
			  System.out.println(w);
			  if(w.equals("=")){
				  w = Search(i++);
				  System.out.println(w);
				  if(L()){
					  if(w.equals(";")){
						  w=Search(i++);
						  return true;
					  }
					  else
						  return false;
				  }
				  return false;
			  }
			  else if(w.equals("+=")){
				  w = Search(i++);
				  System.out.println(w);
				  if(L()){
					  if(w.equals(";")){
						  w=Search(i++);
						  return true;
					  }
					  else
						  return false;
				  }
				  return false;
			  }
			  else if(w.equals("-=")){
				  w = Search(i++);
				  System.out.println(w);
				  if(L()){
					  if(w.equals(";")){
						  w=Search(i++);
						  return true;
					  }
					  else
						  return false;
				  }
				  return false;
			  }
			  else if(w.equals("*=")){
				  w = Search(i++);
				  System.out.println(w);
				  if(L()){
					  if(w.equals(";")){
						  w=Search(i++);
						  return true;
					  }
					  else
						  return false;
				  }
				  return false;
			  }
			  else if(w.equals("/=")){
				  w = Search(i++);
				  System.out.println(w);
				  if(L()){
					  if(w.equals(";")){
						  w=Search(i++);
						  return true;
					  }
					  else
						  return false;
				  }
				  return false;
			  }
			  else
				  return false;
		  }
		  else if(Q()){
			  if(w.equals(";")){
				  w=Search(i++);
				  return true;
			  }
			  else
				  return false;
		  }
		  else
			  return false;
	  }
	  
	  public boolean Q(){
		  System.out.println("Q()");
		  if(SymbolTable.name.contains(w)){
			  w=Search(i++);
			  System.out.println(w);
			  if(O()){
				  return true;
			  }
			  else
				  return false;
		  }
		  return false;
	  }
	  
	  public boolean O(){
		  System.out.println("O()");
		  if(w.equals("++")){
			  w=Search(i++);
			  System.out.println(w);
			  if(w.equals("--")){
				  w=Search(i++);
				  System.out.println(w);
				  return true;
			  }
			  else
				  return false;
		  }
		  return false;
	  }
	  
	  public boolean L(){
		  System.out.println("L()");
		  
		  LinkedList<String> arithQueue=new LinkedList<String>();
		  while(!w.equals(";")&&!w.equals(",")){
			  arithQueue.add(w);
			  w=Search(i++);
			  if(!NumberTable.number.contains(w)&&!SymbolTable.name.contains(w)
					  &&w.equals("+")&&w.equals("-")&&w.equals("*")&&w.equals("/"))
				  return false;
		  }
		  arithQueue.add("#");
		  
		  Arithmetic arithmetic=new Arithmetic(arithQueue);
		  
		  if(arithmetic.Main()){
			  for(int i=0;i<Quadruples.count;i++)
				  System.out.println("("+Quadruples.quadruples[i].arg1+","+Quadruples.quadruples[i].arg2+","+Quadruples.quadruples[i].ope+","+Quadruples.quadruples[i].res+")");
			  return true;
		  }
		  else
			  return false;
		  
	  }
	  
	  public boolean B(){
		  System.out.println("B()");
		  return false;
	  }
	  
}
