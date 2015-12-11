package amey.com.panthera;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import controlP5.*;


public class GUIpanthera extends PApplet{
	
	private Connection connection = null;
	private java.sql.Statement	statement;
	private	ArrayList<regionCo> regions;
	private	ArrayList<lionLocation>	lions;
	private	ArrayList<pondArea> ponds;
	private	ControlP5 cp5;
	private	CheckBox checkbox;
	private int	mode;
	private	int	mX;
	private	int mY;
	private	ArrayList<String>	pondLionList;
		
	//override this method
	public void setup(){
		
		
		//set the size of the applet 
		size(800, 700);
		this.background( 190, 190, 190);
		//color
		//check box text
		PFont pfont = createFont("Arial",5, true); // use true/false for smooth/no-smooth
		ControlFont font = new ControlFont(pfont, 20); 
		stroke(0 ,0 ,0);
		
		//control checkbox settings
		cp5 = new ControlP5(this);
		cp5.setFont(font);
		
		checkbox = cp5.addCheckBox("checkBox") 
			               .setPosition( 100, 25) 
				             .setSize(40, 40)
				             .setHeight(150)
				             .addItem("SHOW LIONS AND PONDS IN SELECTED REGION", 0)            
				             .setColorLabels(ARGB);
				                
		
		

		//set mode
		mode = 1;
		pondLionList = new ArrayList<String>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("JDBC driver missing");
			e.printStackTrace();
		}
		
		
		//connect to oracle db
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(connection !=  null){
		
			System.out.println("Connected");
		}
		else{
			System.out.println("No connection");;
		}
		
		try{
			
			//get the regions
			String regionsQuery = "SELECT c.regionID, t.X, t.Y FROM regionTable c, TABLE(SDO_UTIL.GETVERTICES(c.co_ordinates)) t";
			ResultSet rs = null;
			
			statement = connection.createStatement();
			rs = statement.executeQuery(regionsQuery);
			
			regions = new ArrayList<regionCo>();
			int counter = 0;
			int[][] co_or = new int[5][2];
			
			while(rs.next()){
					co_or[counter][0] = rs.getInt("X");
					co_or[counter][1] = rs.getInt("Y");
					counter++;
					
					if( counter%5 == 0){
						
						regions.add(new regionCo(rs.getString("regionID"), co_or));
						//System.out.println(rs.getString("regionID").toString() +":" + co_or[0][0] +" ,"+ co_or[0][1]);
						counter = 0;
					}
			}
			//end-regions
			
			//get the lions
			String lionsQuery = "SELECT c.lionID, t.X, t.Y FROM lionTable c, TABLE(SDO_UTIL.GETVERTICES(c.location)) t";
			ResultSet rs2 = null;
			
			statement = connection.createStatement();
			rs2 = statement.executeQuery(lionsQuery);
			
			lions = new ArrayList<lionLocation>();
			
			while(rs2.next()){
				lions.add(new lionLocation(rs2.getString("lionID"), rs2.getInt("X"), rs2.getInt("Y")));
			}
			//end of lion story;
			
			//ponds
			String pondsQuery = "SELECT c.pondID, t.X, t.Y FROM pondTable c, TABLE(SDO_UTIL.GETVERTICES(c.area)) t";
			ResultSet rs3 = null;
			
			statement = connection.createStatement();
			rs3 = statement.executeQuery(pondsQuery);
			
			ponds = new ArrayList<pondArea>();
			
			while(rs3.next()){
			
				int	x1 = rs3.getInt("X");
				int	y1 = rs3.getInt("Y");
				
				rs3.next();
				
				int	x2 = rs3.getInt("X");
				int	y2 = rs3.getInt("Y");
				
				rs3.next();
				
				ponds.add(new pondArea(rs3.getString("pondID"), x1, y1, x2, y2, rs3.getInt("X"), rs3.getInt("Y")));
				
			}
			
			
			
			//end of ponds
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	}
	
	public void draw(){
		
		//noStroke();
		//noFill();
		int	offset = 100;
		//fill(255,255,255, 50);
		
		//stroke(220, 200, 100);
		
		fill(255, 255, 255);
		rect(100, 100, 500, 500);

		stroke(0,0,0);
		
	if(mode == 1 || mode == 2){
		
		for(int i = 0; i < regions.size(); i++ ){
			
		
			for(int j = 0; j < 4; j++ ){
				
				 line(regions.get(i).getCo_or(j, 0) + offset , regions.get(i).getCo_or(j, 1) + offset , regions.get(i).getCo_or(j + 1, 0) + offset , regions.get(i).getCo_or(j + 1, 1) + offset );
			}
			
		}//outline the regions
		
		fill(0, 102, 153);
		for(int i = 0; i < regions.size(); i++){
			
			
			text(regions.get(i).getRegionID().toString(), regions.get(i).getCo_or(0, 0) + offset + 15 , regions.get(i).getCo_or(0, 1) + offset + 30 );
			
			
		}//naming the regions
		
		//lions
		noStroke();
		for(int i = 0; i < lions.size(); i++ ){
			fill( 46, 226, 58);
			
			System.out.println(pondLionList.size());
			for(String s: pondLionList){
				
				//System.out.println("Lion display"+s);
				
				if(  s.equals(lions.get(i).getLionID()) && mode ==2 ){
					
					fill(255, 0, 0);
					break;
				}
				
				
			}
			
			
			ellipse( lions.get(i).getX() + offset, lions.get(i).getY() + offset, 5, 5);

		}
		
		stroke(0,0,0);
		fill(255, 255, 255);
		for(int i = 0; i < lions.size(); i++){
			
			text(lions.get(i).getLionID().toString(), lions.get(i).getX()+ offset+ 10, lions.get(i).getY() + offset + 10 );
			
		}//naming of the lions
		
		//show ponds
		stroke(0,0,0);
		for(int i = 0; i < ponds.size(); i++ ){
			fill( 22, 156, 246);
			
			
			for(String s: pondLionList){
				
				//System.out.println("Lion display"+s);
				
				if(  s.equals(ponds.get(i).getPondID()) && mode == 2 ){
					fill(255, 0, 0);
					break;
				}
				
				
			}
			ellipse( ponds.get(i).getX() + offset, ponds.get(i).getY() + offset, 15, 15);

		}
		
		stroke(0,0,0);
		stroke(0,0,0);
		fill(255, 255, 255);
		//name the ponds
		for(int i = 0; i < ponds.size(); i++){
				
				text(ponds.get(i).getPondID().toString(), ponds.get(i).getX()+ offset + 12, ponds.get(i).getY() + offset  );
				
		}
		
		//end of ponds
		
	}//end of mode
		 	
	
	}
	
	public void	controlEvent(ControlEvent theEvent){
		
		if(theEvent.isFrom(checkbox)){
			
			if(mode == 1){
				mode = 2;
			}
			else
			{
				
				pondLionList.clear();
				mode = 1;
			}
			
			//text(theEvent.getName().toString(), 200, 200);
		}
		
	}
	
	public void mouseClicked(){
		
		mX = mouseX;
		mY = mouseY;
		
		//pondLionList.clear();
		//getting the cordinates
		//text(mX +", " + mY, 100, 100);
		
		//run a query to find which region does the point belong to.
		if(mode == 2){
			findRegionQuery();
		}
	}
	
	public void	findRegionQuery(){
		
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","root");
			
			pondLionList = new ArrayList<String>();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			 
			//pondLionList.clear();
			 
			PreparedStatement pstmt = connection.prepareStatement("select regionID from regionTable where SDO_CONTAINS(co_ordinates, SDO_GEOMETRY(2001, NULL, SDO_POINT_TYPE( ?, ?, NULL), NULL, NULL)) = 'TRUE'");
		
			
			mX = mX - 100;
			mY = mY - 100;
			pstmt.setInt(1, mX);
			pstmt.setInt(2, mY);
			
			ResultSet pointRegion = null;	
			
			pointRegion = pstmt.executeQuery();
		 
			pointRegion.next();
			String	region = pointRegion.getString("REGIONID");
			System.out.println(region);
			
			
			PreparedStatement pstmt2 =connection.prepareStatement("select l.pondID from table(SDO_JOIN('regionTable','co_ordinates', 'pondTable', 'area', 'mask = anyinteract')) c, regionTable r, pondTable l where c.rowid1=r.rowid AND c.rowid2=l.rowid and r.regionID = ?  union select l.lionID  from table(SDO_JOIN('regionTable','co_ordinates', 'lionTable', 'location', 'mask = anyinteract')) c, regionTable r, lionTable l where c.rowid1=r.rowid AND c.rowid2=l.rowid and r.regionID = ? ") ;
			
			pstmt2.setString(1, region);
			
			pstmt2.setString(2, region);
			
			ResultSet pondLion= null;
			
			pondLion = pstmt2.executeQuery();
			
			//System.out.println("New region selected");
			
			while(pondLion.next()){
				
				pondLionList.add(pondLion.getString("PONDID"));
				//System.out.println(pondLion.getString("PONDID"));
			}
			
			connection.close();
	//		updateMAP(region);
			
			
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		
	}
	
	
	
}


