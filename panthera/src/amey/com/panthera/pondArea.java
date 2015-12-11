package amey.com.panthera;

public class pondArea {

	private	String	pondID;
	private	int	x;
	private	int	y;
	
	public pondArea(String s ,int x1, int y1, int x2, int y2, int x3,int y3){
		
			float X;
			float Y;
		
			this.pondID = s;
			
			int yDiff_a = y2 - y1;
		    int xDiff_a = x2 - x1;
		    int yDiff_b = y3 - y2;
		    int xDiff_b = x3 - x2;
			

		    float aSlope = yDiff_a/xDiff_a;
		    float bSlope = yDiff_b/xDiff_b;  
		    
		    X = (aSlope*bSlope*(y1 - y3) + bSlope*(x1 + x2) - aSlope*(x2+x3) )/(2* (bSlope-aSlope) );
		    
		    Y = -1*( X - (x1 +x2)/2)/aSlope +  (y1 + y2)/2;
		    
		    this.x = (int)X;
		    this.y = (int)Y;
		    
		    System.out.println("x:" + x + "\ty:" + y);
		    
		    
	}
	public pondArea(String pondID, int x, int y) {
		super();
		this.pondID = pondID;
		this.x = x;
		this.y = y;
	}
	public String getPondID() {
		return pondID;
	}
	public void setPondID(String pondID) {
		this.pondID = pondID;
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
