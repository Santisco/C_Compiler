package Table;

import java.util.ArrayList;

public class StaticTable {
	
	
	public static final ArrayList<String> keyWord = new ArrayList<String>();
	public static final ArrayList<String> boundaryWord = new ArrayList<String>();
	static{
		keyWord.add("void");
		keyWord.add("main");
		keyWord.add("int");
		keyWord.add("char");
		keyWord.add("float");
		keyWord.add("double");
		keyWord.add("long");
		keyWord.add("bool");
		keyWord.add("return");
		keyWord.add("if");
		keyWord.add("else");
		keyWord.add("while");
		keyWord.add("for");
		keyWord.add("break");
		keyWord.add("continue");
		keyWord.add("switch");
		keyWord.add("case");
		keyWord.add("default");
		keyWord.add("const");
		keyWord.add("struct");
		keyWord.add("static");
		keyWord.add("signed");
		keyWord.add("unsigned");
		keyWord.add("short");
		keyWord.add("union");
		keyWord.add("enum");
		keyWord.add("typedef");
		keyWord.add("sizeof");
		keyWord.add("printf");
		keyWord.add("scanf");
		
		boundaryWord.add("+");
		boundaryWord.add("-");
		boundaryWord.add("*");
		boundaryWord.add("/");
		boundaryWord.add(";");
		boundaryWord.add("\"");
		boundaryWord.add("'");
		boundaryWord.add("(");
		boundaryWord.add(")");
		boundaryWord.add("[");
		boundaryWord.add("]");
		boundaryWord.add("{");
		boundaryWord.add("}");
		boundaryWord.add(",");
		boundaryWord.add("=");
		boundaryWord.add("&");
		boundaryWord.add("&&");
		boundaryWord.add("|");
		boundaryWord.add("||");
		boundaryWord.add("!");
		boundaryWord.add(">");
		boundaryWord.add("<");
		boundaryWord.add(">=");
		boundaryWord.add("<=");
		boundaryWord.add("==");
		boundaryWord.add("!=");
		boundaryWord.add("%");
		boundaryWord.add("+=");
		boundaryWord.add("-=");
		boundaryWord.add("*=");
		boundaryWord.add("/=");
		boundaryWord.add("#");
		
	}
	public StaticTable(){
		
	}
	
	public static int isKeyWord(String s){
		return keyWord.indexOf(s);
	}
	
	public static int isBoundaryWord(String s){
		return boundaryWord.indexOf(s);
	}
	
}
