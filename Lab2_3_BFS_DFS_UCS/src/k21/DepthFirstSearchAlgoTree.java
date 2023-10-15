package k21;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgoTree implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.peek();
			if(current.getLabel().equals(goal)) return current;
			List<Edge> children = current.getChildren();
			for (Edge child : children) {
				Node tmp = child.getEnd();
				tmp.setPathCost(child.getWeight() + current.getPathCost());
				tmp.setParent(current);
				frontier.add(tmp);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		Stack<Node> frontier = new Stack();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.peek();
			if(current.getLabel().equals(goal)) return current;
			else if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
			} if(current.getLabel().equals(goal) && started) return current;
			List<Edge> children = current.getChildren();
			for (Edge child : children) {
				Node tmp = child.getEnd();
				tmp.setPathCost(child.getWeight() + current.getPathCost());
				tmp.setParent(current);
				frontier.add(tmp);
			}
		}
		return null;
	}


}
