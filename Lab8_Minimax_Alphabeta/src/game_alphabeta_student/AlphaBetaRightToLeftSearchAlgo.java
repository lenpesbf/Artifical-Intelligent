package game_alphabeta_student;

import java.util.ArrayList;
import java.util.List;


public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

	@Override
	public void execute(Node node) {
		// TODO Auto-generated method stub
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println();
		System.out.println("Value: "+v);
	}
	
	// function MAX-VALUE(state, alpha, beta) returns a utility value
		// if TERMINAL-TEST(state) then return UTILITY(state)
		// v <- MIN_VALUE;
		// for each s in SUCCESSORS(state) do
		// v <- MAX(v, MIN-VALUE(s, alpha, beta))
		// if v >= beta then return v
		// alpha <- MAX(alpha, v)
		// return v

		public int maxValue(Node node, int alpha, int beta) {
			// Enter your code here
			List<Node> cut = new ArrayList<>();
			if(node.isTerminal()) {
				return node.getValue();
			}
			int v = Integer.MIN_VALUE;
			List<Node> children = node.getChildren();
			cut.addAll(children);
			for(int i = children.size()-1; i >= 0; i--) {
				Node current = children.get(i);
				cut.remove(current);
				v = Math.max(v, minValue(current, alpha, beta));
				if(v >= beta) {
					for(Node c : cut) {
						printNode(c);
					}
					return v;
				}
				alpha = Math.max(alpha, v);
			}
			return v;
		}
		// function MIN-VALUE(state, alpha , beta) returns a utility value
		// if TERMINAL-TEST(state) then return UTILITY(state)
		// v <- Integer.MAX_VALUE
		// for each s in SUCCESSORS(state) do
		// v <- MIN(v, MAX-VALUE(s, alpha , beta))
		// if v <= alpha then return v
		// beta <- MIN(beta ,v)
		// return v

		public int minValue(Node node, int alpha, int beta) {
			// Enter your code here
			List<Node> cut = new ArrayList<>();
			if(node.isTerminal()) {
				return node.getValue();
			}
			int v = Integer.MAX_VALUE;
			List<Node> children = node.getChildren();
			cut.addAll(children);
			for(int i = children.size()-1; i >= 0; i--) {
				Node current = children.get(i);
				cut.remove(current);
				v = Math.min(v, maxValue(current, alpha, beta));
				if(v <= alpha) {
					for(Node c : cut) {
						printNode(c);
					}
					return v;
				}
				beta = Math.min(beta, v);
			}
			return v;
		}
		public void printNode(Node node) {
			if (node.isTerminal()) {
				System.out.println(node.getLabel() + ":" + node.getValue());
			} else {
				System.out.println(node.getLabel());
				for (Node child : node.getChildren()) {
					if (child.isTerminal()) {
						System.out.print(child.getLabel() + ":" + child.getValue() + "\t");
						continue;
					}
					printNode(child);
				}
			}
		}
}
