package Datos;

import static weareSupports.Creador.ProjectTQuad;

import java.nio.file.ClosedWatchServiceException;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;
import static weareSupports.Clock.*;

public class TowerCannon {
	
	private float x, y, timeSinceLastShot, attackSpeed;
	private int width, height, damage, range;
	private Texture tex;
	private MapCell startTile;
	private ArrayList<Projectile> projectiles;
	private Enemy target;
	private ArrayList<Enemy> enemies;
	private boolean targeted;
	private String icon;
	public TowerCannon(Texture tex, MapCell startTile, int damage, int range, ArrayList<Enemy> enemies) {
		
		this.tex = tex;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.damage = damage;
		this.range = range;
		this.width = (int) startTile.getW();
		this.height = (int) startTile.getH();
		this.attackSpeed = 2;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
		this.enemies = enemies;
		this.targeted = false; 
		
		//this.target = acquireTarget();
	}
	
public TowerCannon( int damage, float attackSpeed, int range, String icon) {
		
		
		this.damage = damage;
		this.range = range;
		
		this.attackSpeed = 2;
		this.icon = icon;
		
		
		
		
	}
	
	
	

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	private Enemy acquireTarget() { //targetea el mas cercano
		
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
	private void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new Projectile(QuickCast("circle"), target, x, y, 32, 32,600 , 10));
		
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
		
		if (!targeted) {
			target = acquireTarget();
		}
		
		if (target == null  || target.isAlive()  == false)
			targeted = false;
		
		timeSinceLastShot += Delta();
		if (timeSinceLastShot > attackSpeed)
			shoot();
		
		for (Projectile p : projectiles)
			p.update();
		
		project();
		
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

	public float getTimeSinceLastShot() {
		return timeSinceLastShot;
	}

	public void setTimeSinceLastShot(float timeSinceLastShot) {
		this.timeSinceLastShot = timeSinceLastShot;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(float attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public MapCell getStartTile() {
		return startTile;
	}

	public void setStartTile(MapCell startTile) {
		this.startTile = startTile;
	}

	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
	}

	public Enemy getTarget() {
		return target;
	}

	public void setTarget(Enemy target) {
		this.target = target;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public boolean isTargeted() {
		return targeted;
	}

	public void setTargeted(boolean targeted) {
		this.targeted = targeted;
	}
	
	
	
}
