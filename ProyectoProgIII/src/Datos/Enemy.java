package Datos;

import static weareSupports.Creador.*;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import static weareSupports.Clock.Delta;
import org.newdawn.slick.opengl.Texture;

public class Enemy implements Entity{

	
	private int w,h,vel, currentCheckPoint;
	
	private float x,y, lp, startLp;
	private Texture healthBackground, healthForeground, healthBorder;
	private Texture[] tex;
	private MapCell start;
	private static Map map;
	private static Map mapc;
	private boolean alive = true;
	private ArrayList<CheckPoint> checkpoints;
	private int[] directions;
	private ArrayList<MapCell> celdasV;
	private int dir1L,dir2L;
	private boolean first = true;
	private boolean slowed = false;

	public Enemy(Texture tex, Texture tex2, MapCell start, Map map, int w, int h, int vel, float lp ) {
		
		this.start = start;
		this.x = start.getX()+16;
		this.y = start.getY();
		this.w = w;
		this.h = h;
		this.vel = vel;
		this.lp = lp;
		this.startLp = lp;
		
		this.tex = new Texture[2];
		this.tex[0]= tex;
		this.tex[1]= tex2;
		
		
		
		this.healthBackground = QuickCast("healthBackground");
		this.healthBorder = QuickCast("healthBorder");
		this.healthForeground = QuickCast("healthForeground");
		this.map = map;
		this.celdasV = new ArrayList<MapCell>();
		//this.mapc =new Map(map.getAbc());
		this.checkpoints = new ArrayList<CheckPoint>();
		this.directions = new int[2];
		this.dir1L = 1;
		this.dir1L = 0;
		//x direction
		this.directions[0] = 0;
		//y direction
		this.directions[1] = 0;
		directions = findNextD(start);
		this.currentCheckPoint = 0;
		populateCheckPointList();
	}
	
	public void update() {
		if (first) {
			first = false;
		}else {
			
//			if (checkPointReached()) {
//				if (currentCheckPoint + 1 == checkpoints.size()) {
//					System.out.println("enemmy reached end of maze");
//					die();
//					
//				}
//				else {
//				currentCheckPoint++;
//				}
//			}else {
//				
				
				
				
				int dir1 = setDir(map,map.getCell((int) Math.round((x)/32), (int) Math.round((y)/32)),0)[0];
				int dir2 = setDir(map,map.getCell((int) Math.round((x)/32), (int) Math.round((y)/32)),0)[1];
				
				
					
				x += Delta() * dir1  * vel;  // checkpoints.get(currentCheckPoint).getxDirection() 
				   //
				y += Delta() * dir2 * vel;   // checkpoints.get(currentCheckPoint).getyDirection() 
				   //
				
			//}
//			x += (float) Delta() * directions[0];
//			y += (float) Delta() * directions[1];
//		}
		}
	}
	
	
	private int[] setDir( Map map, MapCell s, int c) {
	
		int[] dir = new int[2];
		
//		System.out.println(s.getXPlace());
//		System.out.println(s.getYPlace());
//		System.out.println(map.getMap()[s.getXPlace()+1][s.getYPlace()].getR());
//		
		
		
		
		if(c ==0&&s.getXPlace()<39) {
			
			
			//aa
			
			
			if (map.getMap()[s.getXPlace()+1][s.getYPlace()].getType().equals(TileType.Dirt0)&&!celdasV.contains(map.getMap()[s.getXPlace()+1][s.getYPlace()])) {
				
//				System.out.println(s.getY());
//				System.out.println(s.getYPlace()*32+16);
				
				//if(s.getX()==(s.getXPlace()*32)+16&&s.getY()==(s.getYPlace()*32)) {
				dir[0]=1;
				dir[1]=0;
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
			//	}
			}else {
//				System.out.println("no hay derecha");
				return setDir(map,s,c+1);
			}
			
		}else if(c==1&&s.getXPlace()<39) {

			
			if (map.getMap()[s.getXPlace()][s.getYPlace()-1].getType().equals(TileType.Dirt0)&&!celdasV.contains(map.getMap()[s.getXPlace()][s.getYPlace()-1])) {


				


//				System.out.println("hola");

				//if(s.getX()==(s.getXPlace()*32)+16&&s.getY()==(s.getYPlace()*32)+16) {
				dir[0]=0;
				dir[1]=-1;
//				System.out.println(dir[0]+" "+dir[1]);
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
				//}
			}else {
//				System.out.println("no hay arriba");
				return setDir(map,s,c+1);
			}


		}else if(c==2&&s.getXPlace()<39) {
			
			if (map.getMap()[s.getXPlace()][s.getYPlace()+1].getType().equals(TileType.Dirt0)&&!celdasV.contains(map.getMap()[s.getXPlace()][s.getYPlace()+1])) {
				//if(s.getX()==(s.getXPlace()*32)+16&&s.getY()==(s.getYPlace()*32)+16) {
				dir[0]=0;
				dir[1]=1;
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
				//}
				
			}else {

				return setDir(map,s,c+1);
			}



		}else if (c==3&&s.getXPlace()<39){
			
			if(s.getXPlace()-1>=0) {
			if (map.getMap()[s.getXPlace()-1][s.getYPlace()].getType().equals(TileType.Dirt0)&&!celdasV.contains(map.getMap()[s.getXPlace()-1][s.getYPlace()])) {
			//	if(s.getX()==(s.getXPlace()*32)+16&&s.getY()==(s.getYPlace()*32)+16) {
				dir[0]=-1;
				dir[1]=0;
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
				//}
				
			}else {

				return setDir(map,s,c+1);
			}
			}
		}else {
			
			die();
			
		}
		
		
		return dir;
		
		
		
		
}
	
	private boolean checkPointReached() {
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
	
	private void populateCheckPointList() {
		
		checkpoints.add(findNextC(start, directions = findNextD(start)));
		
		
		int counter = 0;
		boolean cont = true;
		while (cont) {
			int[] currentD = findNextD(checkpoints.get(counter).getMapCell());
			//check if a next direciton/checkpoint exists, end after 20 checkpoints ARBITRARY
			if (currentD[0] == 2  || counter == 20) {
				
				cont = false;
			}else {
				checkpoints.add(findNextC(checkpoints.get(counter).getMapCell(),
						directions = findNextD(checkpoints.get(counter).getMapCell())));
			}
			counter++;
		}
	}
	private CheckPoint findNextC (MapCell s, int[] dir) {
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
	
	public int[] findNextD(MapCell s) {
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
	
	
	public void project() {
		
		float lpPerc = lp /startLp;
		ProjectTQuad(tex[0],x,y,w,h);
		ProjectTQuad (healthBackground,x,y - 8,w,4);
		ProjectTQuad(healthForeground,x,y - 8 ,32 * lpPerc,8);
		ProjectTQuad(healthBorder,x,y - 8,w,8);
		
		
		
		
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

	public void setY(float y) {
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

	public float getLp() {
		return lp;
	}

	public void setLp(int lp) {
		this.lp = lp;
	}

	public Texture getTex(int x) {
		return tex[x];
	}

	public void setTex(Texture tex) {
		this.tex[0] = tex;
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

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean end) {
		this.alive = end;
	}
	
	public void damage(int amount) {
		lp -= amount;
		if (lp <= 0)
			die();
	}
	
	private void die() {
		alive = false;
	}

	public int[] getDirections() {
		return directions;
	}

	public void setDirections(int[] directions) {
		this.directions[0] = directions[0];
		this.directions[1]= directions[1];
	}

	public void changeTex() {
		
		Texture t3;
		t3 = this.tex[0];
		this.tex[0] = this.tex[1];
		this.tex[1]=t3;
		
		
	}
	
	public boolean isSlowed() {
		return this.slowed;
	}
	public void setSlowed(boolean s) {
		this.slowed = s;
	}
	
}
