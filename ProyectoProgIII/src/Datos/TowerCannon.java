package Datos;

import static weareSupports.Creador.ProjectTQuad;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {
	
	private float x, y;
	private int width, height, damage;
	private Texture tex;
	private MapCell startTile;
	public TowerCannon(Texture tex, MapCell startTile, int damage) {
		
		this.tex = tex;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.damage = damage;
		this.width = (int) startTile.getW();
		this.height = (int) startTile.getH();
	}

	
	
	
	
	public TowerCannon() {
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
