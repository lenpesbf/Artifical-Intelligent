package k21;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgoTree implements ISearchAlgo {
//Task3
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while (!(frontier.isEmpty())) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			List<Edge> children = current.getChildren();
			for (Edge child : children) {
				Node tmp = (Node) child.getEnd();
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
		Queue<Node> frontier = new LinkedList<Node>();
		boolean started = false;
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			else if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
			} else if(current.getLabel().equals(goal) && started) {
				return current;
			}
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
