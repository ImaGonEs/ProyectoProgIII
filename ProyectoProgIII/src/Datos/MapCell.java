package Datos;

import org.newdawn.slick.opengl.Texture;

import static weareSupports.Creador.*;

public class MapCell {

	private int x,y,w,h;
	private Texture tex;
	private TileType type;
	
	
	public MapCell(int x, int y, int w, int h, TileType type) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.type = type;
		this.tex = QuickCast(type.name);
	}

	public void Project() {
		
		ProjectTQuad(tex, x, y, w,h);
		
	}

	public int getX() {
		return x;
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
	
	
	
}
