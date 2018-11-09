package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;

public abstract class Tower implements Entity{
	
	private float x, y;
	private int w,h, damage;
	private Enemy target; // si es aoe se puede pasar null;
	private Texture tex;
	

	public Tower (Texture tex, float x, float y, int w, int h) {
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
		
	}
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return 0;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void update() {
		
		
	}

	public void project() {
		ProjectTQuad(tex, x, y, w, h);
		
	}
	
	

}
