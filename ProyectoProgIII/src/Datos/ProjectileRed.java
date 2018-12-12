package Datos;

import org.newdawn.slick.opengl.Texture;

public class ProjectileRed extends Projectile{
	
	public ProjectileRed(Texture tex, Enemy target, float x, float y, int w, int h, float speed, int damage) {
		super(tex, target, x, y, w, h, speed, damage);
	}

	@Override
	public void damage() {
		
		
		super.setAlive(false); //si queremos que no haga daño se cambia esto
		super.damage();
	}

}
