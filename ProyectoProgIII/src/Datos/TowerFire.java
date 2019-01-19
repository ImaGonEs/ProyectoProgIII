package Datos;


import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerFire extends Tower{
	
	public TowerFire (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}

	public void shoot() {
		
		timeSinceLastShot = 0;   

		projectiles.add(new ProjectileFire(QuickCast("fireBall"), target, x, y, 32, 32,400,10));

		projectiles.add(new ProjectileFire(QuickCast("fireBall"), target, x, y, 32, 32,400 , this.damage));

		}

	
//public TowerFire( int damage, float attackSpeed, int range, String icon) {
//		
//		super(damage,attackSpeed,range,icon);
//	
//		this.damage = damage;
//		this.range = range;
//		
//		this.attackSpeed = 2;
//		this.icon = icon;
//		
//		
//		
//		
//	}


}
