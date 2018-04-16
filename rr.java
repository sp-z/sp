
import java.io.*;

public class Sheduling{
	public static BufferedReader br;
	static int p;
	static int pid[];
	static int pri[];
	static int at[];
	static int bt[];
	static int ct[];
	static int tat[];
	static int wt[];
	static int k[];
	static int i;
	private static float avg;

	//round-robin algorithm
		public static void round(int num) throws IOException{
			int quantum=0;
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter burst time");
				for(int i=0;i<num;i++) { 
				pid[i]=i+1;
				System.out.print("\nP["+(i+1)+"]: "); 
				bt[i] = Integer.parseInt(br.readLine()); 
				k[i] = bt[i]; 
				wt[i]=0;
				} 
				System.out.print("\n\nEnter quantum: "); 
				quantum = Integer.parseInt(br.readLine());
				int rp = num;
				int i=0; 
				int time=0; 
				System.out.println("GianttChart for round robin algorithm =>");
				System.out.print("0"); 
				wt[0]=0; 
				while(rp!=0) { if(k[i]>quantum)
				 {
				   k[i]=k[i]-quantum;
				   System.out.print(" | P["+(i+1)+"] | ");
				   time+=quantum;
				   ct[i]=time;
				   tat[i]=ct[i];
				   System.out.print(time);
				   }
				 else if(k[i]<=quantum && k[i]>0)
				 {time+=k[i];
				ct[i]=time;
				tat[i]=ct[i];
				  k[i]=k[i]-k[i];
				  System.out.print(" | P["+(i+1)+"] | ");
				  rp--;
				System.out.print(time);
				 }
				 
				i++;
				if(i==num)
				{
				i=0;
				}
				 
				}
				 
				for(int j=0;j<num;j++)
					wt[j]=tat[j]-bt[j];
				System.out.println("\n\nProcess\tBT\tCT\tTAT\tWT");
				for (int j=0;j<num;j++)
				{
				System.out.println(pid[j]+"\t"+bt[j]+"\t"+ct[j]+"\t"+tat[j]+"\t"+wt[j]);
				}
	 
				//avg=sum/num;
				//System.out.println("\nAverage Waiting Time = "+ avg);
		}


//main execution
	public static void main(String[] args) throws IOException
	{
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the no of Processes: - ");
			
			p = Integer.parseInt(br.readLine());
				
			at = new int[p];
			bt = new int[p];
			ct = new int[p];
			tat = new int[p];
			wt = new int[p];
			pid = new int[p];
			pri = new int[p];
			k= new int[p];   // it is also stores brust time
			System.out.println("Scheduling Algorithms which are allow to appliy");
			
			 
			 System.out.println("\n******************You are selected Round Robin******************");
				round(p);
			
			
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}

}
