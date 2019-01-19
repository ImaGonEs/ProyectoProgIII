package Datos;



import org.newdawn.slick.opengl.Texture;


public class ProjectilePoison extends Projectile{ 

	public ProjectilePoison(Texture tex, Enemy target, float x, float y, int w, int h, float speed, int damage) {
		super(tex, target, x, y, w, h, speed, damage);
	}
	
	@Override
	public void damage() {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				ProjectilePoison.super.setAlive(false); 
				//Este pryectil aplica un efecto de veneno en los enemigos (les hace daño cada segundo)
				while (ProjectilePoison.this.getTarget().isAlive()) {		
					try {
						ProjectilePoison.super.damage();
						Thread.sleep(500);		
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
				}
				
				
				
				
				
				
			}
		});
		
		
		t.start();
		
		
		
	}
	

}
