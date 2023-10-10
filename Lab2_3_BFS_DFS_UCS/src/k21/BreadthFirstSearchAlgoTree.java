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
		return null;
	}

}
