package student;

public class HillClimbing {
	public Node execute(Node initialState) {
		// Enter your code here.
		Node current = initialState;
		Node neighbor = null;
		while(true) {
			neighbor = current.getBestCandidates();
			if(neighbor.getH() < current.getH()) {
				current = neighbor;
			}else {
				return current;
			}
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		// Enter your code here.
		Node current = execute(initialState);
		while (current.getH() != 0) {
			Node randomStart = new Node();
			randomStart.generateBoard();
			Node result = execute(randomStart); 
			if (result.getH() == 0) {
				return result; 		}
			if (result.getH() < current.getH()) {
				current = result; 
			}
		}
		return current; 
	}

}
