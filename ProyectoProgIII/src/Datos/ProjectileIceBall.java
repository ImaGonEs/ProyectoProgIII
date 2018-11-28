package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;

public class ProjectileIceBall extends Projectile{ //SLOW

	public ProjectileIceBall(Texture tex, Enemy target, float x, float y, int w, int h, float speed, int damage) {
		super(tex, target, x, y, w, h, speed, damage);
	}
	
	@Override
	public void damage() {
		
		super.getTarget().setVel(4);
		if (!super.getTarget().isSlowed()) {
		super.getTarget().changeTex();
		}
		
		super.getTarget().setSlowed(true);
		super.setAlive(false); //si queremos que no haga daño se cambia esto
		super.damage();
	}
	
	

}
