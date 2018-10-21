package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;
public class Enemy {

	
	private int x,y,w,h,vel,lp;
	private Texture tex;
	private MapCell start;
	
	
	public Enemy(Texture tex, MapCell start, int w, int h, int vel, int lp ) {
		super();
		this.x = start.getX();
		this.y = start.getY();
		this.w = w;
		this.h = h;
		this.vel = vel;
		this.lp = lp;
		this.tex = tex;
	}
	
	public void Project() {
		
		ProjectTQuad(tex,x,y,w,h);
		
		
		
		
	}
	
	
	
	
	
}
