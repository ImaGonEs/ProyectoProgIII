package Datos;

import static weareSupports.Creador.ProjectTQuad;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;
import static weareSupports.Clock.*;

public class TowerCannon {
	
	private float x, y, timeSinceLastShot, attackSpeed;
	private int width, height, damage;
	private Texture tex;
	private MapCell startTile;
	private ArrayList<Projectile> projectiles;
	
	public TowerCannon(Texture tex, MapCell startTile, int damage) {
		
		this.tex = tex;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.damage = damage;
		this.width = (int) startTile.getW();
		this.height = (int) startTile.getH();
		this.attackSpeed = 30;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}


	private void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(QuickCast("circle"), x , y , 40, 10));
		
		
		
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
		
		timeSinceLastShot += Delta();
		if (timeSinceLastShot > attackSpeed)
			shoot();
		
		for (Projectile p : projectiles)
			p.update();
		
		project();
		
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
