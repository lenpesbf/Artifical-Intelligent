package chapter2.agent_AB;

import java.util.Random;

import chapter2.agent_AB.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
//		if(p.getLocationState() == Environment.LocationState.DIRTY) return Environment.SUCK_DIRT;
//		else if(p.getAgentLocation().equals(Environment.LOCATION_A)) return Environment.MOVE_RIGHT;
//		else if(p.getAgentLocation().equals(Environment.LOCATION_B)) return Environment.MOVE_LEFT;
//		return NoOpAction.NO_OP;
		Random rdAction = new Random();
		int randomAction = rdAction.nextInt(4);
		if(p.getLocationState() == Environment.LocationState.DIRTY)
			return Environment.SUCK_DIRT;
		else {
			switch (randomAction) {
			case 0:
				return Environment.MOVE_UP;
			case 1:
				return Environment.MOVE_DOWN;
			case 2:
				return Environment.MOVE_LEFT;
			case 3: 
				return Environment.MOVE_RIGHT;

			default:
				return NoOpAction.NO_OP;
			}
		}
	}
}