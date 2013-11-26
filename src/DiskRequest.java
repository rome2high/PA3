
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
