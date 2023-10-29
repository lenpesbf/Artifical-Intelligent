package student;

import java.util.Comparator;

public class NodeComparatorStar implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		double costNode1 = o1.getG() + o1.getH();
		double costNode2 = o2.getG() + o2.getH();
		if (costNode1 == costNode2)
			return o1.getLabel().compareTo(o2.getLabel());
		return Double.compare(costNode1, costNode2);
	}
}
