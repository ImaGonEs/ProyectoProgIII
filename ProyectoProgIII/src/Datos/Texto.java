package Datos;

import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

import weareSupports.Creador.*;

public class Texto {

	
	
	private int x,y;
	private TrueTypeFont font; 
	private String text;
	
	public Texto(String text, int x, int y) {
		
		this.font = new TrueTypeFont((new Font ("Times New Roman", Font.BOLD,32)), false);
		
		this.text = text;
		
		this.x = x;
		this.y = y;
		
	}
	
	
	public void cambioTexto(int a) {
		
		
		text = Integer.toString(a);
		
		
	}
	
	
	
	public void project() {
		
		
		
		
		
		font.drawString(x, y, text);
		
		
	}
	
	
	
	
	
}
