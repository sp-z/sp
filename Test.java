package mathoperation.java;

//Test.java
import java.io.*;

public class Test {
public static void main(String arg[]) throws IOException{
while(true)
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("\nOperations you may perform :- \n1.ADD\n2.Mulitply\n3.Subtract\n\nEnter Operation: - ");
		
int choice = Integer.parseInt(br.readLine());

switch(choice){
	case 1: MathOPeration.add();
		break;
	case 2: MathOPeration.multiply();
		break;
	case 3: MathOPeration.subtract();
		break;
	default:System.out.println("Invalid choice") ;
		break;
}

}	
}
}

//MathOPeration.java
package mathoperation.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MathOPeration {
public static void add(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Addition is"+(no1+no2));
	}
	catch(Exception e){System.out.println(e);}
}
public static void subtract(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Subtraction is"+(no1-no2));
	}
	catch(Exception e){System.out.println(e);}
}
public static void multiply(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Multiplication is"+(no1*no2));
	}
	catch(Exception e){System.out.println(e);}
}
}



