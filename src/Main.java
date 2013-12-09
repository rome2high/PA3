import java.util.ArrayList;


public class Main {
	
	FileProcessing fp;
	ArrayList<DiskRequest> mySecond = new ArrayList<DiskRequest>();
	FCFS fcfs;
	
	public void myMain() {
		fp = new FileProcessing("Sample.txt");
		fp.load();
		
		
		//System.out.println(mySecond);
		for (int i=0;i<fp.getTimeLargest();i++) 
		{
			mySecond = fp.getSecondsWorthofData(1);
			fcfs = new FCFS(mySecond,0);
			fcfs.doSomething();
		}
	}
	
	public static void main(String args[]) {
		Main m = new Main();
		m.myMain();
		System.out.println("complete!");
	}
}
