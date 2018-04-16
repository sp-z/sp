package banker.java;

import java.io.*;

public class banker{
	public static void main(String[] str) throws IOException{
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
		int n,m,k,avail[],allo[][],max[][],need[][],flag[];
		System.out.println("Enter number of processes :-");
		n=Integer.parseInt(read.readLine());
		//page=new int[n];
		System.out.println("Enter number of resouces :-");
		m=Integer.parseInt(read.readLine());
		//frames=new int[f];
		flag=new int[n];
		avail=new int[m];
		
		allo=new int[n][m];
		max=new int[n][m];
		need=new int[n][m];

		System.out.println("Enter Resouces Available :-");
		for(int i=0;i<m;i++){
			System.out.println("Resource "+i+"=");
			k=Integer.parseInt(read.readLine());
			avail[i]=k;
		}
		
		System.out.println("\n\nEnter values for max[][] matrix");
		for(int i=0;i<n;i++){
			flag[i]=0;
			for(int j=0;j<m;j++){
			System.out.println("P"+i+"&R"+j+" = ");
			k=Integer.parseInt(read.readLine());
			max[i][j]=k;
			}
		}	

		System.out.println("\n\nEnter values for allocation[][] matrix");
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			System.out.println("P"+i+"&R"+j+" = ");
			k=Integer.parseInt(read.readLine());
			allo[i][j]=k;
			}
		}

		//calculating need matrix
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
			need[i][j]=max[i][j]-allo[i][j];
		}

//Displaying result
		System.out.println("\n----------------------\nMAX[][] matrix");
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
			System.out.print(max[i][j]+"\t");
			}
			System.out.println();
		}	
		
		System.out.println("\n----------------------\nALLOCATION[][] matrix");
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
			System.out.print(allo[i][j]+"\t");
			}
			System.out.println();
		}	

		System.out.println("\n----------------------\nNEED[][] matrix");
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
			System.out.print(need[i][j]+"\t");
			}
			System.out.println();
		}			

		//finding safe state
		for(int i=0;i<n;i++){
			if(flag[i]==0 && need[i][0]<=avail[0]){
				System.out.println("\nProcess"+(i+1)+" executed");
				for(int j=0;j<m;j++){
					avail[j]=avail[j]+allo[i][j];
					System.out.print(avail[j]+"\t");}
				flag[i]=1;
			}
			
		}

		

	}
	

}
