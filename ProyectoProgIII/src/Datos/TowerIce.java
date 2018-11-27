package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerIce extends Tower{
	
	public TowerIce (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}

	public TowerIce( int damage, float attackSpeed, int range, String icon) {
		
		super(damage,attackSpeed,range,icon);
	
		this.damage = damage;
		this.range = range;
		
		this.attackSpeed = 2;
		this.icon = icon;
		
		
		
		
	}
	public void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new ProjectileIceBall(QuickCast("circle"), target, x, y, 32, 32,600 , 10));
	}

	
	
}
