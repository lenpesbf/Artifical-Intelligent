package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
	//Task1
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while(!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			if(currentNode.getLabel().equals(goal)) return currentNode;
			else explored.add(currentNode);
			List<Node> children = currentNode.getChildrenNodes();
			for (Node child : children) {
				if(!frontier.contains(child)&&!explored.contains(child)) {
					frontier.add(child);
					child.setParent(currentNode);
				}
			}
		}
		return null;
	}
	//Task2
	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while(!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			explored.add(currentNode);
			if(currentNode.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
			} else if(currentNode.getLabel().equals(goal) && started) {
				return currentNode;
			}
			if(currentNode.getLabel().equals(goal)) return currentNode;
			List<Node> children = currentNode.getChildrenNodes();
			for (Node child : children) {
				if(!frontier.contains(child)&&!explored.contains(child)) {
					frontier.add(child);
					child.setParent(currentNode);
				}
			}
		}
		return null;
	}

}
