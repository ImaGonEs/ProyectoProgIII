package Datos;

import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerRed extends Tower{
	
	public TowerRed (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}

	public void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new ProjectileRed(QuickCast("POtro3"), target, x, y, 32, 32,400 , this.getDamage()));
		}
	
	
//public TowerRed( int damage, float attackSpeed, int range, String icon) {
//		
//		super(damage,attackSpeed,range,icon);
//	
//		this.damage = damage;
//		this.range = range;
//		
//		this.attackSpeed = attackSpeed;
//		this.icon = icon;
//		
//		
//		
//		
//	}
}
