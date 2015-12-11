package amey.com.panthera;

public class lionLocation {
	

	private	String lionID;
	private	int	x;
	private	int y;
	
	public lionLocation(String ID, int X , int Y) {
		super();
		// TODO Auto-generated constructor stub
		
		this.lionID = ID;
		this.x = X;
		this.y = Y;
		
	}
	
	public String getLionID() {
		return lionID;
	}
	public void setLionID(String lionID) {
		this.lionID = lionID;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	

}
