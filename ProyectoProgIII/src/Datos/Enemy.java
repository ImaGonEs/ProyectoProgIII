package Datos;

import static weareSupports.Creador.*;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import static weareSupports.Clock.Delta;
import org.newdawn.slick.opengl.Texture;

public class Enemy implements Entity{
	
	//ancho, alto y velocidad del enemigo
	private int w,h,vel;
	//posicion (x,y), la vida y la vida al empezar
	private float x,y, lp, startLp;
	//textura de la barra de vida
	private Texture healthBackground, healthForeground, healthBorder;
	//textura del enemigo
	private Texture[] tex;
	//celda inicial
	private MapCell start;
	private static Map map;
	private boolean alive = true;
	private int[] directions;
	//celdas recorridas
	private ArrayList<MapCell> celdasV;
	private boolean first = true;
	private boolean slowed = false;
	private boolean mapkill = false;
	public boolean mapkillseen = true;

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
		this.directions = new int[2];
		//x direction
		this.directions[0] = 0;
		//y direction
		this.directions[1] = 0;
	}
	private int dir1 =0;
	private int dir2 =0;
	
	public void update() {
		if (first) {
			first = false;
		}else {		
				dir1 = setDir(map,map.getCell((int) Math.round((x)/32), (int) Math.round((y)/32)),0,dir1,dir2)[0];
				dir2 = setDir(map,map.getCell((int) Math.round((x)/32), (int) Math.round((y)/32)),0,dir1,dir2)[1];
							
				x += Delta() * dir1  * vel;  				   
				y += Delta() * dir2 * vel;   
		}
	}
	
	private int[] setDir( Map map, MapCell s, int c,int dir1, int dir2) {
		int[] dir = new int[2];
		if(c ==0&&s.getXPlace()<39) {
			//calcular x,y siguiente celda y que sea una condicion     
			if (map.getMap()[s.getXPlace()+1][s.getYPlace()].getType().equals(TileType.Dirt0)
					&&!celdasV.contains(map.getMap()[s.getXPlace()+1][s.getYPlace()]))
			{
//				if(x > (s.getX()-16)-3 && 
//						 x < (s.getX()-16)+3 &&
//				 		y > (s.getY())-3 && 
//				 		y < (s.getY())+3) {
					
				dir[0]=1;
				dir[1]=0;
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
//				}else {
//					if(!primera) {
//						System.out.println("AAAA");
//					dir[0]=dir1;
//					dir[1]=dir2;
//					}else {
//						primera=false;
//					dir[0]=1;
//					dir[1]=0;
//					
//					}
//					return dir;
//				}
			}else {				
				return setDir(map,s,c+1,dir1,dir2);
			}	
		}else if(c==1&&s.getXPlace()<39) {	
			if (map.getMap()[s.getXPlace()][s.getYPlace()-1].getType().equals(TileType.Dirt0)&&!celdasV.contains(map.getMap()[s.getXPlace()][s.getYPlace()-1])) {
//				if(x > (s.getX()) - 3 && 
//						 x < (s.getX()) + 3 &&
//				 		y > (s.getY()) -3 && 
//				 		y < (s.getY()) +3) {
				dir[0]=0;
				dir[1]=-1;
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
//				}else {
//					if(!primera) {
//					dir[0]=dir1;
//					dir[1]=dir2;
//					}else {
//						primera=false;
//					dir[0]=0;
//					dir[1]=-1;
//					
//					}
//					return dir;
//					
//				}
			}else {
				return setDir(map,s,c+1,dir1,dir2);
			}
		}else if(c==2&&s.getXPlace()<39) {
			
			if (map.getMap()[s.getXPlace()][s.getYPlace()+1].getType().equals(TileType.Dirt0)&&!celdasV.contains(map.getMap()[s.getXPlace()][s.getYPlace()+1])) {
//				if(x > (s.getX()-16) - 3 && 
//						 x < (s.getX()-16) + 3 &&
//				 		y > (s.getY()) -3 && 
//				 		y < (s.getY()) +3) {		
				dir[0]=0;
				dir[1]=1;
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
//				}else {
//					if(!primera) {
//					dir[0]=dir1;
//					dir[1]=dir2;
//					}else {
//						primera=false;
//					dir[0]=0;
//					dir[1]=1;
//					
//					}
//					return dir;
//				}			
			}else {
				return setDir(map,s,c+1,dir1,dir2);
			}
		}else if (c==3&&s.getXPlace()<39){	
			if(s.getXPlace()-1>=0) {
			if (map.getMap()[s.getXPlace()-1][s.getYPlace()].getType().equals(TileType.Dirt0)&&!celdasV.contains(map.getMap()[s.getXPlace()-1][s.getYPlace()])) {
//				if(x > (s.getX()) - 3 && 
//						 x < (s.getX()) + 3 &&
//				 		y > s.getY() -3 && 
//				 		y < s.getY() +3) {
				dir[0]=-1;
				dir[1]=0;
				celdasV.add(map.getMap()[s.getXPlace()][s.getYPlace()]);
//				}else {
//					if(!primera) {
//					dir[0]=dir1;
//					dir[1]=dir2;
//					}else {
//						primera=false;
//					dir[0]=-1;
//					dir[1]=0;
//					
//					}
//					return dir;}				
			}else {
				return setDir(map,s,c+1,dir1,dir2);
			}
			}
		}else {		
			mapKill();		
		}	
		return dir;
	
}

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
	public boolean mapKIll() {
		return mapkill;
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
	
	private void mapKill() {
		mapkill = true;
		die();
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
	public boolean isMapkillseen() {
		return mapkillseen;
	}

	public void setMapkillseen(boolean mapkillseen) {
		this.mapkillseen = mapkillseen;
	}
	
}
