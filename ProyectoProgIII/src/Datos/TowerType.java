package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;
public enum TowerType {
	
	
	CannonS(QuickCast("torre"), 10);
	
	Texture tex;
	int damage;
	
	TowerType(Texture tex, int damage) {
		this.tex = tex;
		this.damage = damage;
	}

}
