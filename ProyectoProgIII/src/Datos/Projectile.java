package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Clock.*;
import static weareSupports.Creador.*; 
public class Projectile {
	
	private Texture tex;
	private float x, y, speed;
	private int damage;

	public Projectile (Texture tex, float x, float y, float speed, int damage) {
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
	}
	
	public void update() {
		
		x += Delta() * speed;
		project();
	}
	
	public void project() {
		ProjectTQuad(tex, x, y, 32, 32);
		
	}
}
