package Datos;

import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerPurpl extends Tower{

	public TowerPurpl (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}

//	public TowerPurpl( int damage, float attackSpeed, int range, String icon) {
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
	public void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new ProjectilePurple(QuickCast("POtro2"), target, x, y, 32, 32,600 , this.getDamage()));
	}

}
