import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;


public class FileProcessing {
	
	private File file;
	JFileChooser chooser = new JFileChooser();

	ArrayList<DiskRequest> requests = new ArrayList<DiskRequest>();
	int timeLargest = 0;

	//String filename;
//	public FileProcessing(String _filename) {
//		filename = _filename;
//	}

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
				System.out.println(str + "\n");
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
		chooser.setDialogTitle("Select a Matrix File");
		chooser.showOpenDialog(null);
		file = chooser.getSelectedFile();
	}

}
