package App;

public class Item {
	Customer dest, exp;
	Road roadPath;
	
	String packType;
	int packWeight;
	
	String status;

	public Item() {}

	public Item(Customer exp, Customer dest, String expLoc, String destLoc, String packType, int packWeight) {
		this.dest = dest;
		this.exp = exp;
		
		this.roadPath = new Road(expLoc, destLoc);
		
		this.packType = packType;
		this.packWeight = packWeight;
		this.status = "ToBeConfirmed";
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Customer getDest() {
		return dest;
	}

	public void setDest(Customer dest) {
		this.dest = dest;
	}

	public Customer getExp() {
		return exp;
	}

	public void setExp(Customer exp) {
		this.exp = exp;
	}

	public Road getRoadPath() {
		return roadPath;
	}

	public void setRoadPath(Road roadPath) {
		this.roadPath = roadPath;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public int getPackWeight() {
		return packWeight;
	}

	public void setPackWeight(int packWeight) {
		this.packWeight = packWeight;
	}
}

