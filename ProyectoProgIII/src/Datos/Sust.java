package Datos;

import org.newdawn.slick.opengl.Texture;

public class Sust {


	Texture tex;
	int damage, range;
	float attackSpeed;
	
	
	
	
	Sust(Texture tex, int damage, int range, float attackSpeed) {
		this.tex = tex;
		this.damage = damage;
		this.range = range;
		this.attackSpeed = attackSpeed;
		
	}




	public Texture getTex() {
		return tex;
	}




	public void setTex(Texture tex) {
		this.tex = tex;
	}




	public int getDamage() {
		return damage;
	}




	public void setDamage(int damage) {
		this.damage = damage;
	}




	public int getRange() {
		return range;
	}




	public void setRange(int range) {
		this.range = range;
	}




	public float getAttackSpeed() {
		return attackSpeed;
	}




	public void setAttackSpeed(float attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	
	
}
