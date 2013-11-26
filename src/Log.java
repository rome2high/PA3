import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Log {
	// You don't need a moving shape.
	// MovingShape may need to know about log, but log does not need to know about moving shape.
	// MovingShape ms = new MovingShape(); 
	//
	String filename;
	
	public Log() {
		filename = "consoleText.txt";
	}
	
	public Log(String _filename) {
		filename = _filename;
	}

	public void log(String message) {
		// instead of printing the message
		// write the message to the log file created in constructor
		try {
			FileWriter fw	= new FileWriter(filename);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(message);
			System.out.println("I got this text");
			pw.close();
			fw.close();
		} catch (Exception e) { 			
			e.printStackTrace();
		}
		System.out.println("This is parameter message: " + message);
	}

	public String getLog()  {
		// print the log
		// so get all the text logged by log which was stored in the file
		// created by the constructor
		String retVal = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str + "\n");
				retVal+=str+"\n";
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Your log is:");  // too late! when you print this
		return retVal;
	}
}