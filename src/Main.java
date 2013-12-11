//**********************************************************
// Assignment: ICS-462-50 PA3 JAVA Disk Scheduling Algorithms Simulation
// Author: Romeo Mai
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Main {
	
	private static FileProcessing fp;
	JFileChooser chooser = new JFileChooser();
	InputStreamReader ir = new InputStreamReader(System.in);
	BufferedReader br =  new BufferedReader(ir);
	ArrayList<DiskRequest> mySecond = new ArrayList<DiskRequest>();
	double total = 0;
	
	public void myMain() {

		boolean verbose = false;
		fp = new FileProcessing();
		fp.select();	//user select file
		
		if(fp.getFile() == null){
			return;
		}
		
		int input = JOptionPane.showConfirmDialog(null, "Turn ON Verbose Mode?", "Verbose Mode Option", JOptionPane.YES_NO_OPTION);
		if (input == 0) {	//yes = 0; no = 1
			verbose = true;
		}
		
		fp.load();
		fp.setSummary("File Name: " + fp.getFile().getName());
		
			//handle FCFS
		DiskRequest start = new DiskRequest("00,0.00");
		for (int i=0;i<fp.getTimeLargest();i++) 
		{
			mySecond = fp.getSecondsWorthofData(i);
			if (verbose == true) 
				System.out.println("Second:"+i+" total so far:" +total);
			FCFS fcfs = new FCFS(mySecond,verbose);
			total += fcfs.doSomething(start);
		}
		fp.setSummary("Total FCFS: " + String.format("%1$.3f", total));
		total = 0;
		
			//handle SSTF
		start = new DiskRequest("00,0.00");
		for (int i=0;i<fp.getTimeLargest();i++) 
		{
			mySecond = fp.getSecondsWorthofData(i);
			if (verbose == true) 
				System.out.println("Second:"+i+" total so far:" +total);
			SSTF sstf = new SSTF(mySecond, verbose);
			total += sstf.doSomething(start);
		}
		fp.setSummary("Total SSTF: " + String.format("%1$.3f", total));
		total = 0;
		
			//handle SCAN
		start = new DiskRequest("00,0.00"); 		
		for (int i=0;i<fp.getTimeLargest();i++) 
		{
			mySecond = fp.getSecondsWorthofData(i);
			if (verbose == true) 
				System.out.println("Second:"+i+" total so far:" +total);
			SCAN scan = new SCAN(mySecond, verbose);
			total += scan.doSomething(start);
		}
		fp.setSummary("Total SCAN: " + String.format("%1$.3f", total));
		total = 0;
		}
	
	public static void main(String args[]) {
		Main m = new Main();
		int g = 0;
		while (g <= 0){
			m.myMain();
			if(fp.getFile() == null){
				break;
			}
			System.out.println(fp.getSummary());
			JOptionPane.showMessageDialog(null, fp.getSummary(), "Summary Output",JOptionPane.NO_OPTION);
			g = JOptionPane.showConfirmDialog(null, "Continue Program With Next File?", "Continue Promt", JOptionPane.YES_NO_OPTION);	//return 1 to exit program
		}
		System.out.println("Program Terminated!");
	}
	
	public String getChar() {
		String s=null;
		try {
			if (br.ready() == true) {
				s = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return s;
	}
}
