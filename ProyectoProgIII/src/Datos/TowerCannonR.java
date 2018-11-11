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
	
public TowerCannonR( int damage, float attackSpeed, int range, String icon) {
		
		super(damage,attackSpeed,range,icon);
	
		this.damage = damage;
		this.range = range;
		
		this.attackSpeed = 2;
		this.icon = icon;
		
		
		
		
	}
}
