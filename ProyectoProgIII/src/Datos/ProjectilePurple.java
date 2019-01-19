package Datos;

import org.newdawn.slick.opengl.Texture;

public class ProjectilePurple extends Projectile{

	
	public ProjectilePurple(Texture tex, Enemy target, float x, float y, int w, int h, float speed, int damage) {
		super(tex, target, x, y, w, h, speed, damage);
	}

	@Override
	public void damage() {
		//Aturde a los enemigos (los enemigos dejan de moverse
		super.getTarget().setVel(0);
		//Lo ponemos a false porque este proyectil no hace daño a los enemigos
		super.setAlive(false); 
		
	}
}
