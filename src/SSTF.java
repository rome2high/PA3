
import java.util.ArrayList;


public class SSTF {

	ArrayList<DiskRequest> requests;
	int startingSector;

	public SSTF(ArrayList<DiskRequest> _requests) {
		requests = _requests;
		 
	}

	public DiskRequest findShortest(int current){
		DiskRequest shortestdr = null;
		int shortest_distance = 9999;

		for (int i=0;i<requests.size();i++) {
			DiskRequest dr = requests.get(i);
			int distance = dr.track - current;
			distance = Math.abs(distance);
			if (distance <= shortest_distance) 
			{
				shortest_distance = distance;
				shortestdr = dr;
			}
		}
		requests.remove(shortestdr);  //processing it now, remove it
		return shortestdr;
	}

	public double doSomething(DiskRequest start) {
		int current = start.track;
		double totalTime = 0;

		while(requests.size() > 0) {

			DiskRequest dr = findShortest(current);
			int distance = dr.track - current;
			distance = Math.abs(distance);
			double time = MATH.movetime(distance);
			totalTime +=time;
			current = dr.track;
			start.track = dr.track;
			//System.out.println("Moving head "+distance+" tracks time spent:"+time);
		}
		return totalTime;
	}
}
