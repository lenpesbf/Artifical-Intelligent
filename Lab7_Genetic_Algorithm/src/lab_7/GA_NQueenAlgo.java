package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;//Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		initPopulation();
		int k = 0;
		while(k++ < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<>();
			for(int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if(rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				if(child.getH() == 0) return child;
				newPopulation.add(child);
			}
			population = newPopulation;
		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		Queen[] state = node.getState();
		Queen queen = state[rd.nextInt(Node.N)];
		int randomIndex = rd.nextInt(Node.N);
		if(randomIndex == queen.getRow()) {
			if(randomIndex <= 8) {
				randomIndex++;
			}
			if(randomIndex >= 1) {
				randomIndex--;
			}
		}
		queen.setRow(randomIndex);
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		// Enter your code here
		Node child = new Node();
		child.generateBoard();
		int c = rd.nextInt(Node.N);
		for(int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for(int i = c; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here
		int k = rd.nextInt(POP_SIZE);
		Node current = null;
		int[] arr = new int[k];
		for(int i = 0; i < arr.length; i++) {
			if(current == null) {
				current = population.get(rd.nextInt(POP_SIZE));
			}
			if(current.getH() > population.get(k).getH()) {
				current = population.get(k);
			}
		}
		return current;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		Node node = new Node();
		node = population.get(rd.nextInt(POP_SIZE));
		return node;
	}
	
	public static void main(String[] args) {
		Node test = new Node();
		test.displayBoard();
		System.out.println(test.toString());
		System.out.println(test.getH());
	}
}
