package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack();
		List<Node> explored = new ArrayList<>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node current = frontier.peek();
			if(current == model.getGoalState()) {
				return current;
			} else explored.add(current);
			List<Node> children = model.getSuccessors(current);
			for(Node child : children) {
				if(!frontier.contains(child)&&!explored.contains(child)) {
					child.setG(current.getG() + 1);
					frontier.add(child);
				}
			}
		}
		return null;
	}

}
