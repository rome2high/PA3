//**********************************************************
// Assignment: ICS-462-50 PA3 JAVA Disk Scheduling Algorithms Simulation
// Author: Romeo Mai
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

public class DiskRequest {
	
	int track;
	double timeStamp;
	
	public DiskRequest(String request) {
		String[] parts = request.split(",");
		track = Integer.parseInt(parts[0]);
		timeStamp = Double.parseDouble(parts[1]);
	}
	
	public String toString() {
		return timeStamp + "  "+ track;
	}
}
