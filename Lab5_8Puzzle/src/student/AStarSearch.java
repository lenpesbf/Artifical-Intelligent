package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
		List<Node> explored = new ArrayList<>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getH() == 0) {
				return current;
			} else explored.add(current);
			List<Node> children = model.getSuccessors(current);
			for(Node child : children) {
				if(!frontier.contains(child) && !explored.contains(child)) {
					child.setG(current.getG()+1);
					child.setH(model.computeH1(child));
					frontier.add(child);
				}
			}
		}
		
		
		return null;
	}

}
