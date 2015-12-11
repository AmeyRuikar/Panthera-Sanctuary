package amey.com.panthera;

public class regionCo {
	private	String	regionID;
	private	int[][] co_or;
	
	public regionCo(String s, int[][] x){
		
		this.regionID = s;
		this.co_or = new int[5][2];
		
		for(int i = 0; i< 5; i++){

				this.co_or[i][0] = x[i][0];
				this.co_or[i][1] = x[i][1];
			
		}
		
		//System.out.println(co_or[3][0] + ", "+co_or[3][1]);
		
	}

	public String getRegionID() {
		return regionID;
	}

	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}


	public int getCo_or(int i , int j){
		
		return co_or[i][j];
	}
	
	
	
	public void setCo_or(int[][] co_or) {
		this.co_or = co_or;
	}
}
