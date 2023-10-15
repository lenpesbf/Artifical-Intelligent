package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

		
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			List<Edge> children = current.getChildren();
			for(Edge child : children) {
				Node tmp = child.getEnd();
				if(!frontier.contains(tmp) && !explored.contains(tmp)) {
					frontier.add(tmp);
					tmp.setParent(current);
					tmp.setPathCost(child.getWeight() + current.getPathCost());
				} else if(!frontier.contains(tmp) && tmp.getPathCost() > current.getPathCost()) {
					tmp.setPathCost(current.getPathCost());
					tmp.setParent(current);
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			else if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
			} else if(current.getLabel().equals(start) && started) return current;
			List<Edge> children = current.getChildren();
			for(Edge child : children) {
				Node tmp = child.getEnd();
				if(!frontier.contains(tmp) && !explored.contains(tmp)) {
					frontier.add(tmp);
					tmp.setParent(current);
					tmp.setPathCost(child.getWeight() + current.getPathCost());
				} else if(!frontier.contains(tmp) && tmp.getPathCost() > current.getPathCost()) {
					tmp.setPathCost(current.getPathCost());
					tmp.setParent(current);
				}
			}
		}
		
		return null;
	}


}
