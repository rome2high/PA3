import java.util.ArrayList;


public class FCFS { 
	
	ArrayList<DiskRequest> requests;
	int startingSector;
	boolean verbose = false;
	
	public FCFS(ArrayList<DiskRequest> _requests, boolean _verbose) {
		requests = _requests;
		verbose  = _verbose;
	}
	
	public double doSomething(DiskRequest start ) {
		int current = start.track;
		double totalTime = 0;
		
		 for (int i = 0; i < requests.size(); i++) {
			 
			DiskRequest dr = requests.get(i);
			int distance = dr.track - current;
			distance = Math.abs(distance);
			double time = MATH.movetime(distance);
			totalTime += time;
			current = dr.track;
			start.track = dr.track;
			if (verbose == true)
				System.out.println("Current track: " + current);
		}
		 return totalTime;
	}
}
