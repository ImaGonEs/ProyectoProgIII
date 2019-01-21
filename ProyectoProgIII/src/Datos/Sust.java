package Datos;


/* 
 * Clase sustituta para almacenar atributos de torres (la usamos en la ventana Gui sobretodo)
 * */

public class Sust { 


	String tex;
	int damage, range;
	float attackSpeed;
	String id;
	
	
	
	public Sust(String id,String tex, int damage, int range, float attackSpeed) {
		this.id = id;
		this.tex = tex;
		this.damage = damage;
		this.range = range;
		this.attackSpeed = attackSpeed;
		
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getTex() {
		return tex;
	}




	public void setTex(String tex) {
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
