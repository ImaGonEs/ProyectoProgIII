package Datos;

import org.newdawn.slick.opengl.Texture;

import static weareSupports.Creador.*;

public class MapCell {

	private int x,y,w,h;
	private Texture tex;
	private TileType type;
	//Booleano que marca si la casilla tiene una torre puesta o no
	boolean r;
	public MapCell(int x, int y, int w, int h, TileType type,boolean r) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.type = type;
		this.tex = QuickCast(type.name);
		this.r = r;
	}

	
	
	public void project() {
		
		ProjectTQuad(tex, x, y, w,h);
		
	}

	public int getX() {
		return x;
	}
	
	public int getXPlace() {
		return (int) x / 32;
	}

	public int getYPlace() {
		return (int) y / 32;
	}

	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getW() {
		return w;
	}


	public void setW(int w) {
		this.w = w;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public Texture getTex() {
		return tex;
	}


	public void setTex(Texture tex) {
		this.tex = tex;
	}


	public TileType getType() {
		return type;
	}


	public void setType(TileType type) {
		this.type = type;
	}
	/* 
	 * @return Devuelve si la celda tiene una torre construida
	 * */
	public boolean getR() {
		return r;
	}

	public void setR(boolean r) {
		this.r = r;
	}
	
	
	
}
