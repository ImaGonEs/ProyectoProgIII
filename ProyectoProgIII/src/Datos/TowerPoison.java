package Datos;

import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerPoison  extends Tower{

	public TowerPoison (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}
	
//	public TowerPoison( int damage, float attackSpeed, int range, String icon) {
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
	
	
	public void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new ProjectilePoison(QuickCast("Pr_e"), target, x, y, 32, 32,600 , this.getDamage()));
	}
}