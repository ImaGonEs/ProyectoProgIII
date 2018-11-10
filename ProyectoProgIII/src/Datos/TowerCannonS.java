package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerCannonS extends Tower{
	
	public TowerCannonS (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}
	public void shoot() {
	timeSinceLastShot = 0;   
	projectiles.add(new Projectile(QuickCast("circle"), target, x, y, 32, 32,600 , 10));
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
}
