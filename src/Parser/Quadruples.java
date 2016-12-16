package Parser;

import java.util.LinkedList;

public class Quadruples extends LinkedList<Quadruples>{

	public String ope;
	public String arg1;
	public String arg2;
	public String res;
	public static Quadruples[] quadruples=new Quadruples[100000];
	public static int count=0;
	
	public Quadruples(String o,String a1,String a2,String r){
		this.ope=o;
		this.arg1=a1;
		this.arg2=a2;
		this.res=r;
	}
	
}
