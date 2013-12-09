
import java.util.ArrayList;


public class SCAN {

	ArrayList<DiskRequest> requests;
	ArrayList<DiskRequest>larger = new ArrayList<DiskRequest>();
	ArrayList<DiskRequest>smaller = new ArrayList<DiskRequest>();
	int startingSector;
	boolean verbose;

	public SCAN(ArrayList<DiskRequest> _requests, boolean _verbose) {
		requests = _requests;
		verbose = _verbose;
	}

	public void  split(int current){
		DiskRequest shortestdr = null;
		int shortest_distance = 9999;

		for (int i=0;i<requests.size();i++) {
			DiskRequest dr = requests.get(i);
			if (dr.track >= current) 
				larger.add(dr);
			else
				smaller.add(dr);
		} 
		return ;
	}
	
	public void sort(ArrayList<DiskRequest> list) {
		ArrayList<DiskRequest>finalList = new ArrayList<DiskRequest>();
		for (int i=0;i<list.size();i++)
			for(int x=1;x<list.size()-i;x++) {
			 if (list.get(x-1).track > list.get(x).track) {
				DiskRequest temp = list.get(x);
				list.set(x-1, list.get(x));
				list.set(x,temp);
			 }
			}
	}
	
	
	

	public double doSomething(DiskRequest start) {
		int current = start.track;
		double totalTime = 0;
		
		split(current);
		sort(larger);
		sort(smaller);
		
		 if (verbose) 
			 System.out.println("New direction  up:");
		
		 for (int i = 0; i < larger.size(); i++) {
			 
				DiskRequest dr = larger.get(i);
				int distance = dr.track - current;
				distance = Math.abs(distance);
				double time = MATH.movetime(distance);
				totalTime += time;
				current = dr.track;
				start.track = dr.track;
				if (verbose == true)
					System.out.println("Current track: "+current);
			}
		 
		 if (verbose) 
			 System.out.println("New direction  down:");
		 
		 for (int i = smaller.size()-	1; i >0; i--) {
				DiskRequest dr = smaller.get(i);
				int distance = dr.track - current;
				distance = Math.abs(distance);
				double time = MATH.movetime(distance);
				totalTime += time;
				current = dr.track;
				start.track = dr.track;
				if (verbose == true)
					System.out.println("Current track: "+current);
			}
		return totalTime;
	}
}
