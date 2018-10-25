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

	public void update() {
		
	}
	public void project() {
		
		ProjectTQuad(tex,x,y,width,height);
		
	}
	
}
