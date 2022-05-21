package App;

import java.util.*;

public class Road {
	List<String> nodes;
	int remainingTime;
	
	/////////////////////////////////////////////////////////////////////
	
	public Road() {}
	
	public Road(String expLoc, String destLoc) {
		computeRoad(expLoc, destLoc);
	}

	public void updateLocation(String newLoc) {
		computeRoad(newLoc, this.nodes.get(this.nodes.size() - 1));
	}
	
	public List<String> getNodes() {
		return nodes;
	}

	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	
	/////////////////////////////////////////////////////////////////////

	private void computeRoad(String expLoc, String destLoc) {
		this.remainingTime = 60;
		this.nodes = new ArrayList<String>();
		
		this.nodes.add(expLoc);
		this.nodes.add(destLoc);
	}
}
