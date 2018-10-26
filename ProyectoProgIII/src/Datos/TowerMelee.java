package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.ProjectTQuad;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TowerMelee {

	private float x, y, attackSpeed;
	private int width, height, damage;
	private Texture tex;
	private MapCell startTile;
	private ProjectileMelee p;
	
	public TowerMelee(Texture tex, MapCell startTile, int damage) {
		
		this.tex = tex;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.damage = damage;
		this.width = (int) startTile.getW();
		this.height = (int) startTile.getH();
		this.attackSpeed = 30;
		p = new ProjectileMelee(QuickCast("circle"), x , y-40, 50, 10);
		
	}



	
	public TowerMelee() {
		super();
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.damage = 0;
		this.tex = null;
		this.startTile = null;
	}


	public void update() {
		
		
		project();
		p.update();
		
	}
	public void project() {
		
		ProjectTQuad(tex,x,y,width,height);
		
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}
	
	
	
	
}
