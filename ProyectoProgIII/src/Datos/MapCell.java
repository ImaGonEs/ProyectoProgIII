package Datos;

import org.newdawn.slick.opengl.Texture;

public class MapCell {

	private int x,y,w,h;
	private Texture tex;
	
	
	
	public MapCell(int x, int y, int w, int h, Texture tex) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tex = tex;
	}
	
	
	
}
