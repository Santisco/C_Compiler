//import Table.CharacterTable;
//import Table.NumberTable;
//import Table.SymbolTable;
//
//public boolean V(){
//	  System.out.println("V()");
//	  if(SymbolTable.name.contains(w)){
//		  ariSEM.push(w);
//		  w = Search(i++);
//		  System.out.println(w);
//		  if(J()){
//			  if(V2()){
//				  return true;
//			  }
//			  else
//				  return false;
//		  }
//		  else if(V1())
//			  return true;
//		  else
//			  return false;
//	  }
//	  else
//		  return false;
//}
//
//  public boolean J(){
//		  System.out.println("J()");
//			  if(w.equals("[")){
//				  w = Search(i++);
//				  if(NumberTable.number.contains(w)){
//					  w = Search(i++);
//					  if(w.equals("]")){
//						  w = Search(i++);
//						  if(J1()){
//							  return true;
//						  }
//					  }
//				  }
//			  }
//		  
//		  return false;
//	  }
//	  
//	  public boolean J1(){
//		  if(w.equals("[")){
//			  w = Search(i++);
//			  if(NumberTable.number.contains(w)){
//				  w = Search(i++);
//				  if(w.equals("]")){
//					  w = Search(i++);
//					  if(J1()){
//						  return true;
//					  }
//					  else
//						  return false;
//				  }
//				  else
//					  return false;
//			  }
//			  else
//				  return false;
//		  }
//		  else
//			  return true;
//	  }
//	  
//	  public boolean V2(){
//		  System.out.println("V2()");
//		  if(w.equals("=")){
//			  w = Search(i++);
//			  if(w.equals("{")){
//				  w = Search(i++);
//				  if(K()){
//					  if(w.equals("}")){
//						w = Search(i++);  
//						return true;
//					  }
//					  else
//						  return false;
//				  }
//				  else 
//					  return false;
//			  }
//			  else
//				  return false;
//		  }
//		  return true;
//	  }
//	  
//	  public boolean K(){
//		  System.out.println("K()");
//		  if(w.equals("\"")){
//			  w = Search(i++);
//			  if(CharacterTable.character.contains(w)){
//				  w = Search(i++);
//				  if(w.equals("\"")){
//					  w = Search(i++);
//					  if(K3()){
//						  return true;
//					  }
//				  }
//			  }
//		  }
//		  else if(NumberTable.number.contains(w)){
//			  w = Search(i++);
//			  if(K2()){
//				  return true;
//			  }
//		  }
//		  return false;
//	  }
//	  
//	  public boolean K2(){
//		  System.out.println("K2()");
//		  if(w.equals(",")){
//			  w = Search(i++);
//			  if(NumberTable.number.contains(w)){
//				  w = Search(i++);
//				  if(K2()){
//					  return true;
//				  }
//				  else
//					  return false;
//			  }
//			  else
//				  return false;
//		  }
//		  else
//			  return true;
//	  }
//	  
//	  public boolean K3(){
//		  System.out.println("K3()");
//		  if(w.equals(",")){
//			  w = Search(i++);
//			  if(w.equals("\"")){
//				  w = Search(i++);
//				  if(CharacterTable.character.contains(w)){
//					  w = Search(i++);
//					  if(w.equals("\"")){
//						  w = Search(i++);
//						  if(K3()){
//							  return true;
//						  }
//						  else
//							  return false;
//					  }
//					  else
//						  return false;
//				  }
//				  else
//					  return false;
//			  }
//			  return false;
//		  }
//		  return true;
//	  }