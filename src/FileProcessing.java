//**********************************************************
// Assignment: ICS-462-50 PA3 JAVA Disk Scheduling Algorithms Simulation
// Author: Romeo Mai
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class FileProcessing {
	
	private File file;
	private String summary = "";
	JFileChooser chooser = new JFileChooser();

	ArrayList<DiskRequest> requests = new ArrayList<DiskRequest>();
	int timeLargest = 0;

	ArrayList<DiskRequest> getSecondsWorthofData(int second) {
		ArrayList<DiskRequest> retVal =  new ArrayList<DiskRequest>();
		for(int i=0;i<requests.size();i++) {
			DiskRequest dr = requests.get(i);
			int temp = (int)dr.timeStamp;
			if (temp == second)
				retVal.add(dr);
		}
		return retVal;
	}
	
	public void load() {
		timeLargest = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
			String str;
			while ((str = br.readLine()) != null) {
				DiskRequest dr = new DiskRequest(str);
				int temp = (int)dr.timeStamp;
				if (temp > timeLargest)
					timeLargest = temp;
				requests.add(dr); 
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTimeLargest() {
		return timeLargest;
	}
	
	public void select() {
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Select a Disk Request File");
		chooser.showOpenDialog(null);
		file = chooser.getSelectedFile();
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary += summary + "\n";
	}
	
	public File getFile(){
		return this.file;
	}
}
