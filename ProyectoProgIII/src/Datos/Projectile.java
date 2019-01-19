package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Clock.*;
import static weareSupports.Creador.*; 

/* 
 * Todos los proyectiles heredan de esta clase abstract
 * */
public abstract class Projectile implements Entity{
	
	private Texture tex;
	private float x, y, speed, xVel, yVel;
	private int damage, w, h;
	private Enemy target;
	private boolean alive;

	public Projectile (Texture tex, Enemy target, float x, float y, int w, int h, float speed, int damage) {
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
		this.speed = speed;
		this.damage = damage;
		this.target = target;
		this.alive = true;
		this.xVel = 0f;
		this.yVel = 0f;		
		calculateDirection();
	}
	
	public void damage() {
		target.damage(damage);
		alive = false;
	}
	private void calculateDirection() {
		
		float totalAllowedMovement = 1.0f;  //suma de las dos distancias si esta a 45 grados 0.5 + 0.5
		float xDistFromTarget = Math.abs(target.getX() - x); //valor absoluto para la distancia
		float yDistFromTrget = Math.abs(target.getY() - y);
		float totalDistFromTrget = xDistFromTarget + yDistFromTrget;
		float xPercentMovement = xDistFromTarget / totalDistFromTrget;
		xVel = xPercentMovement;
		yVel = totalAllowedMovement - xPercentMovement;
		
		if (target.getX() < x)
			xVel *= -1;
		if (target.getY() < y)
			yVel *= -1;
	}
	public void update() {
		
		if (alive) {
		x += xVel * speed * Delta();
		y += yVel * speed * Delta();
		if (checkCollision(x, y, w, h, target.getX(), target.getY(), target.getW(), target.getH())) {
			damage();
		}
		project();
		}
	}
	
	public void project() {
		ProjectTQuad(tex, x, y, 32, 32);
		
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
		return h;
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
	public void setAlive(boolean status) {
		alive = status;
		
	}
}
