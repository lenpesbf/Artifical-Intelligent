package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Node execute(Node root, String goal, int limitedDepth) {
		limitedDepth = 0;
		Stack<Node> frontier = new Stack<>();
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.peek();
			if(current.getLabel().equals(goal)) return current;
			else if(current.getDepth() < limitedDepth) {
				List<Edge> children = current.getChildren();
				for(Edge child : children) {
					Node tmp = child.getEnd();
					if(!frontier.contains(tmp) && !explored.contains(tmp)) {
						tmp.setDepth(current.getDepth() + 1);
						tmp.setPathCost(child.getWeight() + current.getPathCost());
						tmp.setParent(current);
						frontier.add(tmp);
					}
					limitedDepth++;
				}
			}
		}
		return null;
	}
	
	
	
}
