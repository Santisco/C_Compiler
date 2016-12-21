package Parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.BoundedRangeModel;

import Scanner.Scanner;
import Table.CharacterTable;
import Table.NumberTable;
import Table.StaticTable;
import Table.SymbolTable;
import Token.Quadruples;
import Token.Token;

public class Parser {
	  //表达式栈
	  public Stack<String> ariSEM = new Stack<String>();
	  public int tagX = 0;
	  public int tagB = 0;
	  public int tagR = 0;
	  String w;
	  int i;
	  int flag = -1;
	  private ArrayList<Token> token = new ArrayList<Token>();
	  public boolean Parser(String str){
		  Scanner sc = new Scanner();
		  if(!sc.Scanner(str))
			  return false;
		  this.token = sc.token;
		  for(int i=0;i<token.size();i++)
				System.out.println(token.get(i).tableName+token.get(i).tableIndex);
		  return M();
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
										  if(tagX == 0 && tagB == 0 && tagR ==0)
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
//				  if(tagX == 0 && tagB == 0 && tagR ==0)
//					  return true;
//				  else 
					  return true;
			  }
			  else
				  return false;
		  }
		  return true;
	  }
	  
	  public boolean C(){
		  System.out.println("C()");
		  if(X()){
			  tagX--;
			  return true;
		  }
		  else if(B()){
			  tagB--;
			  return true;
		  }
		  else if(R()){
			  tagR--;
			  return true;
		  }
		  else
			  return false;  
	  }
	  
	  public boolean X(){
		  System.out.println("X()");
		  if(Y()){
			  tagX++;
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
			  ariSEM.push(w);
			  w = Search(i++);
			  System.out.println(w);
			  if(J()){
				  if(V2()){
					  return true;
				  }
				  else
					  return false;
			  }
			  else if(V1())
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
				  Quadruples.quadruples[Quadruples.count++] = new Quadruples("=", ariSEM.pop(), "$", ariSEM.pop());
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
			  tagR++;
			  ariSEM.push(w);
			  w = Search(i++);
			  System.out.println(w);
			  if(w.equals("=")){
				  w = Search(i++);
				  System.out.println(w);
				  if(L()){
					  Quadruples.quadruples[Quadruples.count++] = new Quadruples("=", ariSEM.pop(), "$", ariSEM.pop());
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
					  Quadruples.quadruples[Quadruples.count++] = new Quadruples("+=", ariSEM.pop(), "$", ariSEM.pop());
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
					  Quadruples.quadruples[Quadruples.count++] = new Quadruples("-=", ariSEM.pop(), "$", ariSEM.pop());
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
					  Quadruples.quadruples[Quadruples.count++] = new Quadruples("*=", ariSEM.pop(), "$", ariSEM.pop());
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
					  Quadruples.quadruples[Quadruples.count++] = new Quadruples("/=", ariSEM.pop(), "$", ariSEM.pop());
					  if(w.equals(";")){
						  w=Search(i++);
						  return true;
					  }
					  else
						  return false;
				  }
				  return false;
			  }
			  else if(O()){
				  Quadruples.quadruples[Quadruples.count++] = new Quadruples("=", ariSEM.pop(), "$", ariSEM.pop());
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
//		  else if(Q()){
//			  if(w.equals(";")){
//				  w=Search(i++);
//				  return true;
//			  }
//			  else
//				  return false;
//		  }
		  else
			  return false;
	  }
	  
	  public boolean Q(){
		  System.out.println("Q()");
		  if(SymbolTable.name.contains(w)){
			  ariSEM.push(w);
			  w=Search(i++);
			  System.out.println(w);
			  if(O()){
				  Quadruples.quadruples[Quadruples.count++] = new Quadruples("=", ariSEM.pop(), "$", ariSEM.pop());  
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
			  Quadruples.quadruples[Quadruples.count++] = new Quadruples("+", ariSEM.peek(), "1", "t" + (Quadruples.count+1));
			  ariSEM.push("t" + (Quadruples.count+1));
			  w=Search(i++);
			  System.out.println(w);
			  return true;
		  }
		  else  if(w.equals("--")){
			  Quadruples.quadruples[Quadruples.count++] = new Quadruples("-", ariSEM.peek(), "1", "t" + (Quadruples.count+1));
			  ariSEM.push("t" + (Quadruples.count+1));
			  w=Search(i++);
			  System.out.println(w);
			  return true;
			  }
		  return false;
	  }
	  
	  private boolean ariGEQ(String s){
			System.out.println("ope："+s);
			if(ariSEM.size()>1){
				String a2=ariSEM.pop();
				String a1=ariSEM.pop();
				String r="t"+(Quadruples.count+1);
				Quadruples.quadruples[Quadruples.count++]=new Quadruples(s, a1, a2, r);
				ariSEM.push(r);
				return true;
			}
			else{
				return false;
			}
		}
	  
	  public boolean L(){
		  System.out.println("L()");
		  boolean flag=false;
		  if(ariE())
			  return true;
		  else
			  return flag;
	  }
	  
	  private boolean ariE() {//E->T{+T{GEQ(+)}|-T{GEQ(-)}}子程序
		  System.out.println("ariE()");
		  boolean flag=false;
		  if(!ariT())
			  return flag;
		  while(true){
			  if(w.equals("+")){
				  w=Search(i++);
				  System.out.println(w);
				  if(!ariT())
					  return flag;
				  if(!ariGEQ("+"))
					  return flag;
			  }
			  else if(w.equals("-")){
				  w=Search(i++);
				  System.out.println(w);
				  if(!ariT())
					  return flag;
				  if(!ariGEQ("-"))
					  return flag;
			  }
			  else
				  return true;
		  }
	  }

		private boolean ariT() {//T->F{*F{GEQ(*)}|/T{GEQ(/)}}子程序
			System.out.println("ariT()");
			boolean flag=false;
			if(!ariF())
				return flag;
			while(true){
				if(w.equals("*")){
					w=Search(i++);
					  System.out.println(w);
					if(!ariF())
						return flag;
					if(!ariGEQ("*"))
						return flag;
				}
				else if(w.equals("/")){
					w=Search(i++);
					  System.out.println(w);
					if(!ariF())
						return flag;
					if(!ariGEQ("/"))
						return flag;
				}
				else
					return true;
			}
		}

		private boolean ariF() {//F->I{PUSH(I)}|(E)子程序
			System.out.println("ariF()");
			boolean flag=false;
			if(w.equals("(")){
				w=Search(i++);
				System.out.println(w);
				if(!ariE())
					return flag;
				if(w.equals(")")){
					w=Search(i++);
					System.out.println(w);
					return true;
				}
				else
					return flag;
			}
			else if(NumberTable.number.contains(w)||SymbolTable.name.contains(w)){
				ariSEM.push(w);
				w=Search(i++);
				System.out.println(w);
				return true;
			}
			else
				return flag;
		}

	  public boolean B(){
			//if语句
		  	System.out.println("B()");
			if(w.equals("if")){
				tagB++;
				w = Search(i++);
				if(w.equals("(")){
					w = Search(i++);
					if(E()){
						if(w.equals(")")){
							w = Search(i++);
							Quadruples.quadruples[Quadruples.count++] = new Quadruples("if", ariSEM.pop(), "$", "$");
							if(w.equals("{")){
								w = Search(i++);
								if(A()){
									if(w.equals("}")){
										w = Search(i++);
										if(B1()){
											Quadruples.quadruples[Quadruples.count++] = new Quadruples("ifEnd", "$", "$", "$");
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
			//while语句
			else if(w.equals("while")){
				tagB++;
				w = Search(i++);
				Quadruples.quadruples[Quadruples.count++] = new Quadruples("while", "$", "$", "$");
				if(w.equals("(")){
					w = Search(i++);
					if(E()){
						if(w.equals(")")){
							Quadruples.quadruples[Quadruples.count++] = new Quadruples("do", ariSEM.pop(), "$", "$");
							w = Search(i++);
							if(w.equals("{")){
								w = Search(i++);
								if(A()){
									if(w.equals("}")){
										Quadruples.quadruples[Quadruples.count++] = new Quadruples("whileEnd", "$", "$", "$");
										w = Search(i++);
										return true;
									}
									else 
										return false;
								}
								else 
									return false;
							}
							else 
								return false;
						}
						else 
							return false;
					}
					else 
						return false;
				}
				else 
					return false;
			}
			//for语句
			else if(w.equals("for")){
				tagB++;
				Stack<Quadruples> temp = new Stack<Quadruples>();
				System.out.println("for开始");
				w = Search(i++);
				Quadruples.quadruples[Quadruples.count++] = new Quadruples("for", "$", "$", "$");
				if(w.equals("(")){
					w = Search(i++);
					if(X()){
						System.out.println("X判别成功");
							if(E()){
								System.out.println("E判别成功");
								if(w.equals(";")){
									w = Search(i++);
									Quadruples.quadruples[Quadruples.count++] = new Quadruples("do", ariSEM.pop(), "$", "$");
									if(Q()){
										System.out.println("Q判别成功");
										temp.add(Quadruples.quadruples[Quadruples.count - 1]);
										temp.add(Quadruples.quadruples[Quadruples.count - 2]);
										Quadruples.count = Quadruples.count - 2;
										if(w.equals(")")){
											w = Search(i++);
											if(w.equals("{")){
												w = Search(i++);
												if(A()){
													if(w.equals("}")){
														w = Search(i++);
														Quadruples.quadruples[Quadruples.count++] = temp.pop();
														Quadruples.quadruples[Quadruples.count++] = temp.pop();
														Quadruples.quadruples[Quadruples.count++] = new Quadruples("forEnd", "$", "$", "$");
														return true;
													}
												}
											}
										}
									}
								}
							}
						
					}
				}
			}
			//scanf函数
			else if(w.equals("scanf")){
				tagB++;
				w = Search(i++);
				if(w.equals("(")){
					w = Search(i++);
					if(SymbolTable.name.contains(w)){
						w = Search(i++);
						if(w.equals(")")){
							w = Search(i++);
							if(w.equals(";")){
								w =Search(i++);							
								return true;
							}
						}
					}
				}
			}
			//printf函数
			else if(w.equals("printf")){
				tagB++;
				w = Search(i++);
				if(w.equals("(")){
					System.out.println("识别（");
					w = Search(i++);
					if(SymbolTable.name.contains(w)){
						System.out.println("识别变量");
						w = Search(i++);
						if(w.equals(")")){
							w = Search(i++);
							if(w.equals(";")){
								w = Search(i++);
								return true;
							}
						}
					}
					else if(w.equals("\"")){
						w = Search(i++);
						if(CharacterTable.character.contains(w)){
							w = Search(i++);
							if(w.equals("\"")){
								w = Search(i++);
								if(w.equals(")")){
									w = Search(i++);
									if(w.equals(";")){
										w = Search(i++);
										return true;
									}
								}
							}
						}			
					}	
				}
			}
			return false;
		}
		
		public boolean B1(){
			System.out.println("B1()");
			if(w.equals("else")){
				Quadruples.quadruples[Quadruples.count++] = new Quadruples("else", "$", "$", "$");
				w = Search(i++);
				if(w.equals("{")){
					w = Search(i++);
					if(A()){
						if(w.equals("}")){
							w = Search(i++);
							return true;
						}
						else 
							return false;
					}
					else 
						return false;
				}
				else if(B()){
					return true;
				}
				else
					return false;
			}
			else
				return true;
		}
		
		public boolean E(){
			System.out.println("E()");
			if(H()){
				if(E1()){
					return true;
				}
			}
			return false;
		}
		
		public boolean E1(){
			System.out.println("E1()");
			if(w.equals("&&")){
				w = Search(i++);
				if(E()){
					Quadruples.quadruples[Quadruples.count++] = new Quadruples("&&", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
					ariSEM.push("t" + (Quadruples.count+1));
					return true;
				}
				else
					return false;
			}
			return true;
		}
		
		public boolean H(){
			System.out.println("H()");
			if(G()){
				if(H1()){
					return true;
				}
			}
			return false;
		}
		
		public boolean H1(){
			System.out.println("H1()");
			if(w.equals("||")){
				w = Search(i++);
				if(H()){
					Quadruples.quadruples[Quadruples.count++] = new Quadruples("||", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
					ariSEM.push("t" + (Quadruples.count+1));
					return true;
				}
				else
					return false;
			}
			return true;
		}
		
		public boolean G(){
			System.out.println("G()");
			if(ariF()){
				if(D()){
					if(ariF()){
						switch(flag){
						case 0:
							Quadruples.quadruples[Quadruples.count++] = new Quadruples(">", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
							ariSEM.push("t" + (Quadruples.count+1));
							break;
						case 1:
							Quadruples.quadruples[Quadruples.count++] = new Quadruples("<", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
							ariSEM.push("t" + (Quadruples.count+1));
							break;
						case 2:
							Quadruples.quadruples[Quadruples.count++] = new Quadruples("==", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
							ariSEM.push("t" + (Quadruples.count+1));
							break;
						case 3:
							Quadruples.quadruples[Quadruples.count++] = new Quadruples("!=", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
							ariSEM.push("t" + (Quadruples.count+1));
							break;
						case 4:
							Quadruples.quadruples[Quadruples.count++] = new Quadruples(">=", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
							ariSEM.push("t" + (Quadruples.count+1));
							break;
						case 5:
							Quadruples.quadruples[Quadruples.count++] = new Quadruples("<=", ariSEM.pop(), ariSEM.pop(), "t" + (Quadruples.count+1));
							ariSEM.push("t" + (Quadruples.count+1));
							break;
						}
						return true;
					}
					else 
						return false;
				}
				return true;
			}
			else if(w.equals("(")){
				w = Search(i++);
				if(E()){
					if(w.equals(")")){
						w = Search(i++);
						return true;
					}
				}
			}
			else if(w.equals("!")){
				w = Search(i++);
				if(E()){
					Quadruples.quadruples[Quadruples.count++] = new Quadruples("!", ariSEM.pop(), "$", "t" + (Quadruples.count+1));
					ariSEM.push("t" + (Quadruples.count+1));
					return true;
				}
			}
			return false;
		}
		
		public boolean D(){
			System.out.println("D()");
			if(w.equals(">")){
				w = Search(i++);
				flag = 0;
				return true;
			}
			else if(w.equals("<")){
				w = Search(i++);
				flag = 1;
				return true;
			}
			else if(w.equals("==")){
				w = Search(i++);
				flag = 2;
				return true;
			}
			else if(w.equals("!=")){
				w = Search(i++);
				flag = 3;
				return true;
			}
			else if(w.equals(">=")){
				w = Search(i++);
				flag = 4;
				return true;
			}
			else if(w.equals("<=")){
				w = Search(i++);
				flag = 5;
				return true;
			}
			else 
				return false;
		}
		  public boolean J(){
			  System.out.println("J()");
				  if(w.equals("[")){
					  w = Search(i++);
					  if(NumberTable.number.contains(w)){
						  w = Search(i++);
						  if(w.equals("]")){
							  w = Search(i++);
							  if(J1()){
								  return true;
							  }
						  }
					  }
				  }
			  
			  return false;
		  }
		  
		  public boolean J1(){
			  if(w.equals("[")){
				  w = Search(i++);
				  if(NumberTable.number.contains(w)){
					  w = Search(i++);
					  if(w.equals("]")){
						  w = Search(i++);
						  if(J1()){
							  return true;
						  }
						  else
							  return false;
					  }
					  else
						  return false;
				  }
				  else
					  return false;
			  }
			  else
				  return true;
		  }
		  
		  public boolean V2(){
			  System.out.println("V2()");
			  if(w.equals("=")){
				  w = Search(i++);
				  if(w.equals("{")){
					  w = Search(i++);
					  if(K()){
						  if(w.equals("}")){
							w = Search(i++);  
							return true;
						  }
						  else
							  return false;
					  }
					  else 
						  return false;
				  }
				  else
					  return false;
			  }
			  return true;
		  }
		  
		  public boolean K(){
			  System.out.println("K()");
			  if(w.equals("\"")){
				  w = Search(i++);
				  if(CharacterTable.character.contains(w)){
					  w = Search(i++);
					  if(w.equals("\"")){
						  w = Search(i++);
						  if(K3()){
							  return true;
						  }
					  }
				  }
			  }
			  else if(NumberTable.number.contains(w)){
				  w = Search(i++);
				  if(K2()){
					  return true;
				  }
			  }
			  return false;
		  }
		  
		  public boolean K2(){
			  System.out.println("K2()");
			  if(w.equals(",")){
				  w = Search(i++);
				  if(NumberTable.number.contains(w)){
					  w = Search(i++);
					  if(K2()){
						  return true;
					  }
					  else
						  return false;
				  }
				  else
					  return false;
			  }
			  else
				  return true;
		  }
		  
		  public boolean K3(){
			  System.out.println("K3()");
			  if(w.equals(",")){
				  w = Search(i++);
				  if(w.equals("\"")){
					  w = Search(i++);
					  if(CharacterTable.character.contains(w)){
						  w = Search(i++);
						  if(w.equals("\"")){
							  w = Search(i++);
							  if(K3()){
								  return true;
							  }
							  else
								  return false;
						  }
						  else
							  return false;
					  }
					  else
						  return false;
				  }
				  return false;
			  }
			  return true;
		  }
}
