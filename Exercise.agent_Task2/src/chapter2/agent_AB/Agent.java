package chapter2.agent_AB;

public class Agent {
	private AgentProgram program;
	private int score;
	public Agent() {
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	public Action execute(Percept p) {
		if (program != null) {
			return program.execute(p);
		}
		return NoOpAction.NO_OP;
	}
	public int getScore() {
		return score;
	}
	public void addScore(int point) {
		score += point;
	}
	
}
