package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			explored.add(current);
			List<Edge> children = current.getChildren();
			for(Edge e : children) {
				Node child = e.getEnd();
				if(!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		boolean started = false;
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			else if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
				current.setH(0);
			} else if(current.getLabel().equals(goal) && started) {
				return current;
			}
			explored.add(current);
			List<Edge> children = current.getChildren();
			for(Edge e : children) {
				Node child = e.getEnd();
				if(!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				
				}
			}
		}
		return null;
	}

}
