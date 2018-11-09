package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.ProjectTQuad;
import static weareSupports.Creador.checkCollision;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class ProjectileMelee {
	private Texture tex;
	private float x, y,w , h, speed;
	private double dir;
	private int damage;
	private ArrayList<Enemy> targets;

	public ProjectileMelee (Texture tex, float x, float y,float w, float h, float speed, int damage,ArrayList<Enemy> targets) {
		
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
		this.speed = speed;
		this.damage = damage;
		this.dir = 0;
		this.targets = targets;
	}
	
	public ArrayList<Enemy> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList<Enemy> targets) {
		this.targets = targets;
	}

	public void update() {
		
		this.setDir(this.getDir()+10);
		x += Delta() * speed*Math.cos(this.getDir()*(Math.PI/180));
		y += Delta() * speed*Math.sin(this.getDir()*(Math.PI/180));
		
		for (Enemy target : targets) {
			if (checkCollision(x, y, w, h, target.getX(), target.getY(), target.getW(), target.getH())) {
				target.damage(damage);
				
			}
		}
		
		
		
		
		project();
	}
	
	public void project() {
		ProjectTQuad(tex, x, y, 32, 32);
		
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

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public double getDir() {
		return dir;
	}

	public void setDir(double dir) {
		this.dir = dir;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}
