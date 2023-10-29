package student;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.getH()==o2.getH()) {
			return o1.getLabel().compareTo(o2.getLabel());
		}
		return Double.compare(o1.getH(), o2.getH());
	}

}
