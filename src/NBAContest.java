import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class NBAContest {

	public static void main(String[] args) throws IOException {
		PriorityQueue<String> east = new PriorityQueue<String>();
		PriorityQueue<String> west = new PriorityQueue<String>();
		String path = "C:\\Users\\saran\\eclipse-workspace\\Priority Queues\\src\\players.txt";
		String line = null;
		String conf = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				conf = line.substring(0, 1);
				if (conf.equals("E")) {
					east.add(line.substring(2));
				} else {
					west.add(line.substring(2));
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("error");
		}
		while (!east.isEmpty() && !west.isEmpty()) {
			System.out.print(" the 3-pointer shooter contenders will be: ");
			System.out.println(east.poll() + " and " + west.poll());
		}
		if (east.isEmpty()) {
			System.out.print("there are " + west.size());
			System.out.println(" East players waiting to play");
			System.out.println(west.peek() + "is the next east player to play");
		}
		if (west.isEmpty()) {
			System.out.print("there are " + east.size());
			System.out.println(" West players waiting to play");
			System.out.println(east.peek() + " is the next west player to play");
		}
	}

}
