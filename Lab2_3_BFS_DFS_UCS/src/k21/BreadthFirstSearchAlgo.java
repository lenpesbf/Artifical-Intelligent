package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	//Task1
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal)) {
				return currentNode;
			}
			List<Node> children = currentNode.getChildrenNodes();
			for (Node child : children) {
				frontier.add(child);
				child.setParent(currentNode);
			}
		}
		return null;
	}
	//Task2
	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			explored.add(currentNode);
			System.out.println(currentNode.getLabel() + "\t");
			if(currentNode.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
			} else if(currentNode.getLabel().equals(goal) && started) return currentNode;
			if(currentNode.getLabel().equals(goal)) return currentNode;
			List<Node> children = currentNode.getChildrenNodes();
			for (Node child : children) {
				if(!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					child.setParent(currentNode);
				}
			}
		}
		return null;
	}

}
