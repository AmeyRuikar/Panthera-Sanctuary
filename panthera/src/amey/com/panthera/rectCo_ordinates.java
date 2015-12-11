package amey.com.panthera;

public class rectCo_ordinates {
	private	String	regionID;
	private	int	topX;
	private	int	topY;
	private	int	width;
	private	int	height;
	
	
	
	public rectCo_ordinates(String regionID, int topX, int topY, int width, int height) {
		super();
		this.regionID = regionID;
		this.topX = topX;
		this.topY = topY;
		this.width = width;
		this.height = height;
	}
	public String getRegionID() {
		return regionID;
	}
	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}
	public int getTopX() {
		return topX;
	}
	public void setTopX(int topX) {
		this.topX = topX;
	}
	public int getTopY() {
		return topY;
	}
	public void setTopY(int topY) {
		this.topY = topY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
