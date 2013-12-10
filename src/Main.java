import java.util.ArrayList;


public class Main {
	
	FileProcessing fp;
	ArrayList<DiskRequest> mySecond = new ArrayList<DiskRequest>();
	FCFS fcfs;
	double total = 0;
	
	public void myMain() {
		boolean verbose = false;
		fp = new FileProcessing("Sample.txt");
		fp.load();
		
		
		//System.out.println(mySecond);
		DiskRequest start = new DiskRequest("500,0.00");
		
		for (int i=0;i<fp.getTimeLargest();i++) 
		{
			mySecond = fp.getSecondsWorthofData(i);
			if (verbose == true) 
				System.out.println("Second:"+i+" total so far:" +total);
			fcfs = new FCFS(mySecond,verbose);
		
			total += fcfs.doSomething(start);
		}
		System.out.println("Total FCFS " + total);
		total = 0;
		start = new DiskRequest("200,0.00");
		 		
		for (int i=0;i<fp.getTimeLargest();i++) 
		{
			mySecond = fp.getSecondsWorthofData(i);
			SSTF sstf = new SSTF(mySecond);
			total += sstf.doSomething(start);
			
		}
		System.out.println("Total SSTF " + total);
		total = 0;
		
		total = 0;
		start = new DiskRequest("00,0.00");
		 		
		for (int i=0;i<fp.getTimeLargest();i++) 
		{
			mySecond = fp.getSecondsWorthofData(i);
			SCAN scan = new SCAN(mySecond, verbose);
			total += scan.doSomething(start);
			
		}
		System.out.println("Total SCAN " + total);
		total = 0;
		}
	
	public static void main(String args[]) {
		Main m = new Main();
		m.myMain();
	}
}
