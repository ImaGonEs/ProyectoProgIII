package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerCannonR extends Tower{
	
	public TowerCannonR (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}

	public void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new ProjectileFire(QuickCast("fireBall"), target, x, y, 32, 32,400 , 10));
		}
	
	
}
