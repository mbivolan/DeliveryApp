package App;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

@JsonIgnoreProperties(value = { "jsonNode" })
public class Road {
	List<String> nodes;
	int remainingTime;
	JsonNode jsonNode;
	
	/////////////////////////////////////////////////////////////////////
	
	public Road() {
		initInventory();
	}

	public void updateLocation() throws Exception {
		//computeRoad(newLoc, this.nodes.get(this.nodes.size() - 1));
		
		this.nodes = this.nodes.subList(1, this.nodes.size());
		this.remainingTime --;
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

	
	private void initInventory() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			jsonNode = objectMapper.readTree(new File("path.json"));
			
		} catch (MismatchedInputException e) {
		} catch (DatabindException e) {
		} catch (IOException e) {
		}
		
	}

	public void computeRoad(String expLoc, String destLoc) throws Exception {
		this.remainingTime = 0;
		this.nodes = new ArrayList<String>();
		boolean found = false;
		
		//
		//;
		
		Iterator<String> color = jsonNode.fieldNames();
		
		JsonNode next = jsonNode.get(expLoc);
		
		this.nodes.add(expLoc);
		
		for (JsonNode lol : next) {
			JsonNode dest = lol.get(destLoc);
			
			if (dest == null) {
				continue;
			}
			
			for (JsonNode drums: dest.get("drum")) {
				this.nodes.add(drums.toString().replaceAll("\"", ""));
			}
			
			found = true;
			
			
		}
		
		if (! found) {
			throw new Exception("Whaterev");
		}
		
		this.nodes.add(destLoc);
		this.remainingTime = this.nodes.size() - 1;
		
		
		List<String> test = new ArrayList<String>();
		color.forEachRemaining(e -> test.add(e));
		System.out.println("ASD:" + this.nodes);
		System.out.println("ASD:" + this.remainingTime);
	}
}
