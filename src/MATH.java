//**********************************************************
// Assignment: ICS-462-50 PA3 JAVA Disk Scheduling Algorithms Simulation
// Author: Romeo Mai
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

public class MATH {
	public static double movetime(int L) {
		double t;
		t = .452 + .548 * Math.sqrt(L);
		return t;
	}
}
