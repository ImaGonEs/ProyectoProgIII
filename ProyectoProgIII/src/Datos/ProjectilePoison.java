package Datos;

import static weareSupports.Creador.QuickCast;

import org.newdawn.slick.opengl.Texture;
import weareSupports.*;

public class ProjectilePoison extends Projectile{ 

	public ProjectilePoison(Texture tex, Enemy target, float x, float y, int w, int h, float speed, int damage) {
		super(tex, target, x, y, w, h, speed, damage);
	}
	
	public void poison() {
		
		
		
	}
	@Override
	public void damage() {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				ProjectilePoison.super.setAlive(false); //si queremos que no haga daño se cambia esto
				
				while (ProjectilePoison.this.getTarget().isAlive()) {
					
					try {
						ProjectilePoison.super.damage();
						Thread.sleep(1000);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
				}
				
				
				
				
				
				
			}
		});
		
		
		t.start();
		
		
		
	}
	

}
