
import java.io.*;

public class FCFS{
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

//fcfs algorithm
	public static void fcfs(int num) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Arrival Time for Each Process: ");
			for(i=0;i<num;i++)
			{
				pid[i]=i+1;
				System.out.println("Enter AT for process "+(i+1));
				at[i] = Integer.parseInt(br.readLine());
			}			
			System.out.println("Enter the BURST Time : ");
			for(i=0;i<num;i++)
			{
				System.out.println("Enter BT for process "+(i+1));
				bt[i] = Integer.parseInt(br.readLine());				
			}
			//calculate completion time
			ct[0] = bt[0];
			for(i=1;i<num;i++)
			{
				//System.out.println("Completion Time for process "+(i+1));
				
				ct[i] = ct[i-1]+bt[i];
				//System.out.println("Completion Time for process "+(i+1)+" = "+ct[i]);
			}
			//calculate Turn Around Time
			
			for(i=0;i<num;i++)
			{	
				tat[i] = ct[i]-at[i];
				//System.out.println("Turn Around Time for process "+(i+1)+ " = "+tat[i]);
			}
			//calculate waiting time
			int sum = 0; 
			for(i=0;i<num;i++)
			{				
				wt[i] = tat[i]-bt[i];
				//System.out.println("Waiting Time for process "+(i+1)+ " = "+wt[i]);
				sum=sum+wt[i];
			}
			System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
			for (int j=0;j<num;j++)
			{
			System.out.println(pid[j]+"\t"+at[j]+"\t"+bt[j]+"\t"+ct[j]+"\t"+tat[j]+"\t"+wt[j]);
			}
 
			avg=sum/num;
			System.out.println("\nAverage Waiting Time = "+ avg);
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
			
			 
			 System.out.println("\n******************You are selected FCFS******************");
				fcfs(p);

			
			
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}

}
