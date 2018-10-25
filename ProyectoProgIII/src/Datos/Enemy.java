package Datos;

import static weareSupports.Creador.ProjectTQuad;

import java.util.ArrayList;
import static weareSupports.Clock.Delta;
import org.newdawn.slick.opengl.Texture;
public class Enemy {

	
	private int w,h,vel,lp, currentCheckPoint;
	
	private float x,y;
	private Texture tex;
	private MapCell start;
	private Map map;
	private boolean end = false;
	private ArrayList<CheckPoint> checkpoints;
	private int[] directions;
	
	
	private boolean first = true;
	
	
	
	
	
	public Enemy(Texture tex, MapCell start, Map map, int w, int h, int vel, int lp ) {
		super();
		this.start = start;
		this.x = start.getX();
		this.y = start.getY();
		this.w = w;
		this.h = h;
		this.vel = vel;
		this.lp = lp;
		this.tex = tex;
		this.map = map;
		
		this.checkpoints = new ArrayList<CheckPoint>();
		this.directions = new int[2];
		
		//x direction
		this.directions[0] = 0;
		//y direction
		this.directions[1] = 0;
		directions = FindNextD(start);
		this.currentCheckPoint = 0;
		PopulateCheckPointList();
	}
	
	public void Update() {
		if (first) {
			first = false;
		}else {
			
			if (CheckPointReached()) {
				if (currentCheckPoint + 1 == checkpoints.size()) {
					System.out.println("enemmy reached end of maze");
					end = true;
					
				}
				else {
				currentCheckPoint++;
				}
			}else {
				
				
				x += Delta() * checkpoints.get(currentCheckPoint).getxDirection() * vel;
				y += Delta() * checkpoints.get(currentCheckPoint).getyDirection() * vel;
				
			}
//			x += (float) Delta() * directions[0];
//			y += (float) Delta() * directions[1];
		}
	}
	
	private boolean CheckPointReached() {
		boolean reached = false;
		
		MapCell t = checkpoints.get(currentCheckPoint).getMapCell();
		
		//check if position reached tile within variance of 3 (ARBITRARY)
		 if (x > t.getX() - 3 && 
				 x < t.getX() + 3 &&
		 		y > t.getY() -3 && 
		 		y < t.getY() +3) {
			 
		 
		
		reached = true;
		x = t.getX();
		y = t.getY();
		 }
		 
		 return reached;
	}
	
	private void PopulateCheckPointList() {
		
		checkpoints.add(FindNextC(start, directions = FindNextD(start)));
		
		
		int counter = 0;
		boolean cont = true;
		while (cont) {
			int[] currentD = FindNextD(checkpoints.get(counter).getMapCell());
			//check if a next direciton/checkpoint exists, end after 20 checkpoints ARBITRARY
			if (currentD[0] == 2  || counter == 20) {
				
				cont = false;
			}else {
				checkpoints.add(FindNextC(checkpoints.get(counter).getMapCell(),
						directions = FindNextD(checkpoints.get(counter).getMapCell())));
			}
			counter++;
		}
	}
	private CheckPoint FindNextC (MapCell s, int[] dir) {
		MapCell next = null;
		CheckPoint c= null;
		
		//boolean to decide if the next checkpoint is found 
		boolean found = false;
		//int to dincrement each loop
		int counter = 1;
		
		while(!found) {
			//either the xPlace or yPlace parameter you give the getTile(int, int) method is -1. 
			//this should always at least be 0, so your s.getX() or s.getY() is returning -1 at some point.
			if (s.getXPlace() + dir[0] * counter == map.getCellsWide() ||
					s.getYPlace() + dir[1] * counter == map.getCellsHigh() ||
					s.getType() !=
					map.getCell(s.getXPlace() + dir[0] * counter, 
						s.getYPlace() + dir[1] * counter).getType()) {
				
				found = true;
				//move counter back to 1 to find tile before iletype
				counter -=1 ;
				next  = map.getCell(s.getXPlace() +dir[0] * counter, 
						s.getYPlace() + dir[1] * counter);
						
			}	
			
			counter++;
		}
	c= new CheckPoint(next, dir[0], dir[1]);	
	return c;
	
	}
	
	private int[] FindNextD(MapCell s) {
		int[] dir = new int[2];
		MapCell u = map.getCell(s.getXPlace(),s.getYPlace()-1);
		MapCell r = map.getCell(s.getXPlace() + 1,s.getYPlace());
		MapCell d = map.getCell(s.getXPlace(),s.getYPlace()+1);
		MapCell l = map.getCell(s.getXPlace()-1,s.getYPlace());
		
		if (s.getType() == u.getType() && directions[1] != 1) {
			dir[0] = 0;
			dir[1] = -1;
			
		}else if(s.getType() == r.getType()  && directions[0] != -1) {
			dir[0] = 1;
			dir[1] = 0;
			
		}else if(s.getType() == d.getType()  && directions[1] != -1) {
			dir[0] = 0;
			dir[1] = 1;
			
		}else if(s.getType() == l.getType()  && directions[0] != 1) {
			dir[0] = -1;
			dir[1] = 0;
			
		}else{
			dir[0] = 2;
			dir[1] = 2;
			//System.out.println("NO DIRECTION FOUND");
		}
		
		
		return dir;
	}
	
//	private boolean pathContinues() {
//		boolean answer = true;
//		
//		MapCell myCell = map.getCell((int) (x / 32),(int)  (y / 32));
//		MapCell nextCell = map.getCell((int) (x / 32) + 1,(int)  (y / 32));
//	
//		if (myCell.getType() != nextCell.getType())
//		answer = false;
//	
//		return answer;
//	
//	}
	
	
	public void Project() {
		
		ProjectTQuad(tex,x,y,w,h);
		
		
		
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public int getLp() {
		return lp;
	}

	public void setLp(int lp) {
		this.lp = lp;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public MapCell getStart() {
		return start;
	}

	public void setStart(MapCell start) {
		this.start = start;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public Map getMap() {
		
		return map;
	}

	public boolean getEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	
	
	
}
