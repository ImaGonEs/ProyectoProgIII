package Datos;

import static weareSupports.Clock.Delta;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class TowerCannonS extends Tower{
	
	public TowerCannonS (TowerType type, MapCell startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		
	}

public TowerCannonS( int damage, float attackSpeed, int range, String icon) {
		
		super(damage,attackSpeed,range,icon);
	
		this.damage = damage;
		this.range = range;
		
		this.attackSpeed = 2;
		this.icon = icon;
		
		
		
		
	}
	
	
}
