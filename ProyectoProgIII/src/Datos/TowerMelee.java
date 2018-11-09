package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.ProjectTQuad;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TowerMelee {

	private float x, y, attackSpeed;
	private int width, height, damage, range;
	private Texture tex;
	private MapCell startTile;
	private ProjectileMelee p;
	private ArrayList<Enemy> enemies;
	private boolean first = true;
	
	public TowerMelee(Texture tex, MapCell startTile, int damage, ArrayList<Enemy> enemies) {
		
		this.tex = tex;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.damage = damage;
		this.width = (int) startTile.getW();
		this.height = (int) startTile.getH();
		this.attackSpeed = 30;
		this.range = 10000;
		this.enemies = enemies;
		
		
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
		
		
			
			
			if (first == true) {
			p = new ProjectileMelee(QuickCast("circle"), x , y-40,32,32, 500, 3, enemies);
			first = false;
			}
			
			p.setTargets(enemies);
		
		
		
		project();
		p.update();
		
	}
	
	

	
	
	public void updateEenemyList (ArrayList<Enemy> newList) {
		enemies= newList;
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
