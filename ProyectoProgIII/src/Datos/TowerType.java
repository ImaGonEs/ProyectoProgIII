package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;
public enum TowerType {
	
	
	CannonS(QuickCast("IT"), 10, 1000, 3),
	CannonR(QuickCast("TR"), 10, 1000, 3),
	CannonE(QuickCast("TC"), 10, 1000, 3);
	
	Texture tex;
	int damage, range;
	float attackSpeed;
	
	TowerType(Texture tex, int damage, int range, float attackSpeed) {
		this.tex = tex;
		this.damage = damage;
		this.range = range;
		this.attackSpeed = attackSpeed;
		
	}

}
