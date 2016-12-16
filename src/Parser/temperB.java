//package Parser;
//
//import Table.CharacterTable;
//import Table.SymbolTable;
//
//public class temperB {
//	public String w;
//	public int i;
//	public boolean B(){
//		//ifÓï¾ä
//		if(w.equals("if")){
//			w = Search(i++);
//			if(w.equals("(")){
//				w = Search(i++);
//				if(E()){
//					if(w.equals(")")){
//						w = Search(i++);
//						if(w.eqauls("{")){
//							w = Search(i++);
//							if(A()){
//								if(w.equals("}")){
//									w = Search(i++);
//									if(B1()){
//										return true;
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		//whileÓï¾ä
//		else if(w.equals("while")){
//			w = Search(i++);
//			if(w.equals("(")){
//				w = Search(i++);
//				if(E()){
//					if(w.equals(")")){
//						w = Search(i++);
//						if(w.equals("{")){
//							w = Search(i++);
//							if(A()){
//								if(w.equals("}")){
//									w = Search(i++);
//									return true;
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		//forÓï¾ä
//		else if(w.equals("for")){
//			w = Search(i++);
//			if(w.equals("(")){
//				w = Search(i++);
//				if(X()){
//					if(w.equals(";")){
//						w = Search(i++);
//						if(G()){
//							if(w.equals(";")){
//								w = Search(i++);
//								if(Q()){
//									if(w.equals(")")){
//										w = Search(i++);
//										if(w.equals("{")){
//											w = Search(i++);
//											if(A()){
//												if(w.equals("}")){
//													w = Search(i++);
//													return true;
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		//scanfº¯Êý
//		else if(w.equals("scanf")){
//			w = Search(i++);
//			if(w.equals("(")){
//				w = Search(i++);
//				if(SymbolTable.name.contains(w)){
//					w = Search(i++);
//					if(w.equals(")")){
//						w = Search(i++);
//						return true;
//					}
//				}
//			}
//		}
//		//printfº¯Êý
//		else if(w.equals("printf")){
//			w = Search(i++);
//			if(w.equals("(")){
//				w = Search(i++);
//				if(SymbolTable.name.contains(w)){
//					w = Search(i++);
//					if(w.equals(")")){
//						w = Search(i++);
//						return true;
//					}
//				}
//				else if(w.equals("\"")){
//					if(CharacterTable.character.contains(w)){
//						w = Search(i++);
//						if(w.equals("\"")){
//							w = Search(i++);
//							if(w.equals(")")){
//								w = Search(i++);
//								return true;
//							}
//						}
//					}			
//				}	
//			}
//		}
//		else
//			return false;
//	}
//	
//	public boolean B1(){
//		if(w.equals("else")){
//			w = Search(i++);
//			if(w.equals("{")){
//				w = Search(i++);
//				if(A()){
//					if(w.equals("}")){
//						w = Search(i++);
//						return true;
//					}
//					else 
//						return false;
//				}
//				else 
//					return false;
//			}
//			else if(B()){
//				return true;
//			}
//			else
//				return false;
//		}
//		else
//			return true;
//	}
//	
//	public boolean E(){
//		if(H()){
//			if(E1()){
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public boolean E1(){
//		if(w.equals("&&")){
//			w = Search(i++);
//			if(E()){
//				return true;
//			}
//			else
//				return false;
//		}
//		return true;
//	}
//	
//	public boolean H(){
//		if(G()){
//			if(H1()){
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public boolean H1(){
//		if(w.equals("||")){
//			w = Search(i++);
//			if(H()){
//				return true;
//			}
//			else
//				return false;
//		}
//		return true;
//	}
//	
//	public boolean G(){
//		if(L()){
//			if(D()){
//				if(L()){
//					return true;
//				}
//			}
//		}
//		else if(w.equals("(")){
//			w = Search(i++);
//			if(E()){
//				if(w.equals(")")){
//					w = Search(i++);
//					return true;
//				}
//			}
//		}
//		else if(w.equals("!")){
//			w = Search(i++);
//			if(E()){
//				return true;
//			}
//		}
//		else
//			return false;
//	}
//	
//	public boolean D(){
//		if(w.equals(">")){
//			w = Search(i++);
//			return true;
//		}
//		else if(w.equals("<")){
//			w = Search(i++);
//			return true;
//		}
//		else if(w.equals("==")){
//			w = Search(i++);
//			return true;
//		}
//		else if(w.equals("!=")){
//			w = Search(i++);
//			return true;
//		}
//		else 
//			return false;
//	}
//}
