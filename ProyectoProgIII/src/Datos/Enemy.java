package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;
import static weareSupports.Clock.*;
public class Enemy {

	
	private int y,w,h,vel,lp;
	
	private float x;
	private Texture tex;
	private MapCell start;
	
	
	private boolean first = true;
	
	
	
	
	
	public Enemy(Texture tex, MapCell start, int w, int h, int vel, int lp ) {
		super();
		this.start = start;
		this.x = start.getX();
		this.y = start.getY();
		this.w = w;
		this.h = h;
		this.vel = vel;
		this.lp = lp;
		this.tex = tex;
	}
	
	public void Update() {
		if (first) {
			first = false;
		}else {
			x += Delta() * vel;
		}
		}
	

	
	public void Project() {
		
		ProjectTQuad(tex,x,y,w,h);
		
		
		
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public int getY() {
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
	
	
	
	
	
}
