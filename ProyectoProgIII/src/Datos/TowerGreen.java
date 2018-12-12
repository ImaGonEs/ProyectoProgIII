package Datos;

import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerGreen extends Tower{

	

	public TowerGreen (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}

	public TowerGreen( int damage, float attackSpeed, int range, String icon) {
		
		super(damage,attackSpeed,range,icon);
	
		this.damage = damage;
		this.range = range;
		
		this.attackSpeed = 2;
		this.icon = icon;
		
		
		
		
	}
	public void shoot() {
		
		timeSinceLastShot = 0;   
		projectiles.add(new ProjectileGreen(QuickCast("POtro1"), target, x, y, 32, 32,600 , 10));
	}

}
