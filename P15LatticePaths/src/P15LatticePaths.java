import java.util.HashMap;
import java.util.ArrayList;

public class P15LatticePaths {
	
	static int size = 20; //size x size grid
	static HashMap<ArrayList<Integer>, Long> data = new HashMap<>(); //(rights, downs)

	public static long countPaths(int rights, int downs) {
		
		ArrayList<Integer> curr = new ArrayList<>();
		curr.add(rights);
		curr.add(downs);
		if (data.containsKey(curr)) {
			return data.get(curr);
		}
		
		if (rights > size || downs > size) {
			return 0;
		}
		
		if (rights == size && downs == size) {
			return 1;
		}
		
		long numGoRight = countPaths(rights + 1, downs);
		long numGoDown = countPaths(rights, downs + 1);
		ArrayList<Integer> goRight = new ArrayList<>();
		goRight.add(rights + 1);
		goRight.add(downs);
		ArrayList<Integer> goDown = new ArrayList<>();
		goDown.add(rights);
		goDown.add(downs + 1);
		
		if (rights == size) {
			data.put(goDown, numGoDown);
			return numGoDown;
		}
		if (downs == size) {
			data.put(goRight, numGoRight);
			return numGoRight;
		}
		data.put(goRight, numGoRight);
		data.put(goDown, numGoDown);
		return numGoRight + numGoDown;
		
	}
	
	public static void main(String[] args) {
		System.out.println(countPaths(0, 0));
	}
	
}
