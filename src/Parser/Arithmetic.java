package Parser;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Table.NumberTable;
import Table.SymbolTable;


/*
 * 文法：
 * E->Ew0T{GEQ(w0)}|T
 * T->Tw1F{GEQ(w1)}|F
 * F->I{PUSH(I)}|(E)
 *
 *优先关系矩阵
 *		Z	E	T	F	w0	w1	I	(	)	#
 *	Z										>
 *	E					=				=	>
 *	T					>	=			>	>
 *	F					>	>			>	>
 *	w0			<	<			<	<		
 *	w1				=			<	<		
 *	I					>	>			>	>
 *	(		<	<	<			<	<		
 *	)					>	>			>	>
 *	#	<	<	<	<			<	<		
 */

class Matrix{//矩阵的类
	String relation;//有关系属性
	Matrix[][] SPMatrix;//优先关系矩阵
	
	public void SPMatrix(){//构造优先关系矩阵
		SPMatrix=new Matrix[10][10];
		SPMatrix[0][9]=new Matrix();
		SPMatrix[0][9].relation=">";
		SPMatrix[1][4]=new Matrix();
		SPMatrix[1][4].relation="=";
		SPMatrix[1][8]=new Matrix();
		SPMatrix[1][8].relation="=";
		SPMatrix[1][9]=new Matrix();
		SPMatrix[1][9].relation=">";
		SPMatrix[2][4]=new Matrix();
		SPMatrix[2][4].relation=">";
		SPMatrix[2][5]=new Matrix();
		SPMatrix[2][5].relation="=";
		SPMatrix[2][8]=new Matrix();
		SPMatrix[2][8].relation=">";
		SPMatrix[2][9]=new Matrix();
		SPMatrix[2][9].relation=">";
		SPMatrix[3][4]=new Matrix();
		SPMatrix[3][4].relation=">";
		SPMatrix[3][5]=new Matrix();
		SPMatrix[3][5].relation=">";
		SPMatrix[3][8]=new Matrix();
		SPMatrix[3][8].relation=">";
		SPMatrix[3][9]=new Matrix();
		SPMatrix[3][9].relation=">";
		SPMatrix[4][2]=new Matrix();
		SPMatrix[4][2].relation="<";
		SPMatrix[4][3]=new Matrix();
		SPMatrix[4][3].relation="<";
		SPMatrix[4][6]=new Matrix();
		SPMatrix[4][6].relation="<";
		SPMatrix[4][7]=new Matrix();
		SPMatrix[4][7].relation="<";
		SPMatrix[5][3]=new Matrix();
		SPMatrix[5][3].relation="=";
		SPMatrix[5][6]=new Matrix();
		SPMatrix[5][6].relation="<";
		SPMatrix[5][7]=new Matrix();
		SPMatrix[5][7].relation="<";
		SPMatrix[6][4]=new Matrix();
		SPMatrix[6][4].relation=">";
		SPMatrix[6][5]=new Matrix();
		SPMatrix[6][5].relation=">";
		SPMatrix[6][8]=new Matrix();
		SPMatrix[6][8].relation=">";
		SPMatrix[6][9]=new Matrix();
		SPMatrix[6][9].relation=">";
		SPMatrix[7][1]=new Matrix();
		SPMatrix[7][1].relation="<";
		SPMatrix[7][2]=new Matrix();
		SPMatrix[7][2].relation="<";
		SPMatrix[7][3]=new Matrix();
		SPMatrix[7][3].relation="<";
		SPMatrix[7][6]=new Matrix();
		SPMatrix[7][6].relation="<";
		SPMatrix[7][7]=new Matrix();
		SPMatrix[7][7].relation="<";
		SPMatrix[8][4]=new Matrix();
		SPMatrix[8][4].relation=">";
		SPMatrix[8][5]=new Matrix();
		SPMatrix[8][5].relation=">";
		SPMatrix[8][8]=new Matrix();
		SPMatrix[8][8].relation=">";
		SPMatrix[8][9]=new Matrix();
		SPMatrix[8][9].relation=">";
		SPMatrix[9][0]=new Matrix();
		SPMatrix[9][0].relation="<";
		SPMatrix[9][1]=new Matrix();
		SPMatrix[9][1].relation="<";
		SPMatrix[9][2]=new Matrix();
		SPMatrix[9][2].relation="<";
		SPMatrix[9][3]=new Matrix();
		SPMatrix[9][3].relation="<";
		SPMatrix[9][6]=new Matrix();
		SPMatrix[9][6].relation="<";
		SPMatrix[9][7]=new Matrix();
		SPMatrix[9][7].relation="<";
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				if(SPMatrix[i][j]==null){
					SPMatrix[i][j]=new Matrix();
					SPMatrix[i][j].relation="ERR";
				}
	}
	
}

public class Arithmetic extends Matrix{//算术表达式的语法判断，用简单优先分析方法
	
	private String W="";//当前符
	private Queue<String> queue=new LinkedList<String>();//用户输入的表达式队列
	private Stack<String> stack=new Stack<String>();//辅助栈
	
	private Stack<String> SEM=new Stack<String>();//语义栈

	public Arithmetic(Queue<String> q){
		this.queue=q;
	}
	
	private int Code(String s){//判断符号s的标号
		int a = -1;
		switch (s) {
		case "Z":
			a=0;
			break;
		case "E":
			a=1;
			break;
		case "T":
			a=2;
			break;
		case "F":
			a=3;
			break;
		case "+":
		case "-":
			a=4;
			break;
		case "*":
		case "/":
			a=5;
			break;
		case "(":
			a=7;
			break;
		case ")":
			a=8;
			break;
		case "#":
			a=9;
			break;
		default:
			if(NumberTable.number.contains(s)||SymbolTable.name.contains(s))
				a=6;
			break;
		}
		return a;
	}
	
	boolean GEQ(String s){
		if(SEM.size()>1){
			String w=s.substring(1, 2);
			System.out.println("Ope："+w);
			String a2=SEM.pop();
			String a1=SEM.pop();
			String r="t"+(Quadruples.count+1);
			Quadruples.quadruples[Quadruples.count++]=new Quadruples(w, a1, a2, r);
			SEM.push(r);
			return true;
		}
		else
			return false;
	}
	
	private void Reduced(){//归约
		Stack<String> stack0=new Stack<String>();
		while(true){//从stack栈顶向下寻找直到当前符号的前一个符号的优先级小于当前符号
			stack0.push(stack.pop());//将当前的符号以及之后的符号一次从stack中弹出
			int m=Code(stack.peek());//依次放入栈stack0中
			int n=Code(stack0.peek());
			if(SPMatrix[m][n].relation.equals("<"))
				break;
		}
		/*特殊情况处理，“(”和“E”的优先关系有“=”和“<”两种
		 *默认一律按<处理，特殊情况为栈stack0中为“)E”，stack栈顶为“(”
		 *则将“(”弹出入stack0*/
		if(stack0.size()==2&&stack0.get(0).equals(")")&&stack0.get(1).equals("E")
				&&stack.peek().equals("("))
			stack0.push(stack.pop());
		/*特殊情况处理，“+”或“-”和“T”的优先关系有“=”和“<”两种
		 *默认一律按<处理，特殊情况为栈stack0中为“T”，stack栈顶为“+”或“-”
		 *则将“+”或“-”弹出入stack0，再将stack此时的栈顶弹出入stack*/
		if(stack0.size()==1&&stack0.peek().equals("T")&&
				(stack.peek().equals("+")||stack.peek().equals("-"))){
			stack0.push(stack.pop());
			stack0.push(stack.pop());
		}
		String str=new String();
		while(!stack0.isEmpty())//构造字符串
			str+=stack0.pop();
		System.out.print("Reduce:"+str+"->");
		switch(str){//归约
		case "E":
			System.out.println("Z");
			stack.push("Z");
			break;
		case "T":
			System.out.println("E");
			stack.push("E");
			break;
		case "E+T":
		case "E-T":
			System.out.println("E");
			GEQ(str);
			stack.push("E");
			break;
		case "F":
			System.out.println("T");
			stack.push("T");
			break;
		case "T*F":
		case "T/F":
			System.out.println("T");
			GEQ(str);
			stack.push("T");
			break;
		case "(E)":
			System.out.println("F");
			stack.push("F");
			break;
		default:
			if(NumberTable.number.contains(str)||SymbolTable.name.contains(str)){
				System.out.println("F");
				stack.push("F");
				SEM.push(str);
			}
			break;
		}
	}
	
	public boolean Main(){//主函数
		SPMatrix();
		stack.push("#");
		W=queue.poll();
		for(int i=0;i<stack.size();i++)
			System.out.print(stack.get(i)+" ");
		System.out.print("		"+W+"	");
		System.out.print("StackSEM：");
		for(int i=0;i<SEM.size();i++)
			System.out.print(SEM.get(i)+" ");
		System.out.println();
		while(true){
			int m=Code(stack.peek());
			int n=Code(W);
			if(SPMatrix[m][n].relation.equals("ERR"))
				return false;//如果两个字符之间不存在关系，返回false
			if(SPMatrix[m][n].relation.equals(">"))
				Reduced();//如果为>关系，归约
			else{//否则为<或=关系
				stack.push(W);//当前符入栈
				W=queue.poll();//往后读一位
			}
			for(int i=0;i<stack.size();i++)
				System.out.print(stack.get(i)+" ");
			System.out.print("		"+W+"	");
			System.out.print("StackSEM：");
			for(int i=0;i<SEM.size();i++)
				System.out.print(SEM.get(i)+" ");
			System.out.println();
			if(stack.size()==2&&stack.peek().equals("Z")&&W.equals("#"))
				return true;//如果栈中为“#Z”，当前符为“#”，则符合表达式语法规则
		}
	}
	
}




















