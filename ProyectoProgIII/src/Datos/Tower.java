package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.ProjectTQuad;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public abstract class Tower implements Entity{
	
	protected float x, y, timeSinceLastShot, attackSpeed;
	protected int w,h, damage, range;
	protected Enemy target; // si es aoe se puede pasar null;
	private Texture tex;
	private ArrayList<Enemy> enemies;
	protected boolean targeted;
	protected ArrayList<Projectile> projectiles;
	protected String icon;

	public Tower (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		
		this.tex = type.tex;
		this.damage = type.damage;
		this.range = type.range;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.w = startTile.getW();
		this.h= startTile.getH();
		this.enemies = enemies;
		this.targeted = false;
		this.timeSinceLastShot = 0f;
		this.projectiles = new ArrayList<Projectile>();
		this.attackSpeed = type.attackSpeed;
	}
	
	public Tower( int damage, float attackSpeed, int range, String icon) {
		
		
		this.damage = damage;
		this.range = range;
		
		this.attackSpeed = 2;
		this.icon = icon;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

	protected Enemy acquireTarget() { //targetea el mas cercano
		
		Enemy closest = null;
		float ClosestDistance = 10000;
		for (Enemy e : enemies) {
			if (isInRange(e) && findDist(e) < ClosestDistance) {
				ClosestDistance = findDist(e);
				closest = e;
			}
		}
		if (closest != null)
			targeted = true;
		return closest;
	}
	
	private boolean isInRange(Enemy e ) {
		
		float xDist = Math.abs(e.getX() -x);
		float yDist = Math.abs(e.getY() -y);
		
		if (xDist < range && yDist < range)
			return true;
					
		return false;
	}
	
	private float findDist (Enemy e) {
		
		float xDist = Math.abs(e.getX() -x);
		float yDist = Math.abs(e.getY() -y);
		return xDist + yDist;
	}
	
	protected void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new ProjectileIceBall(QuickCast("circle"), target, x, y, 32, 32,600 , 10));
		
	}
	
	public void updateEnemyList (ArrayList<Enemy> newList) {
		enemies= newList;
	}
	
	public void update() {
		
		if (!targeted) {
			target = acquireTarget();
		}
		
		if (target == null  || target.isAlive()  == false)
			targeted = false;
		
		timeSinceLastShot += Delta();
		if (timeSinceLastShot > attackSpeed && targeted)
			shoot();
		
		for (Projectile p : projectiles)
			p.update();
		
		project();
		
	}

	public void project() {
		ProjectTQuad(tex, x, y, w, h);
		
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

	public Enemy getTarget() {
		return target;
	}
	
	

}
