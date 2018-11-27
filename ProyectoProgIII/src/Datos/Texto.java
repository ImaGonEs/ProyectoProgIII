package Datos;

import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

import weareSupports.Creador.*;

public class Texto {

	
	
	private int x,y;
	private TrueTypeFont font; 
	private String text;
	
	public Texto(String text) {
		
		this.font = new TrueTypeFont((new Font ("Times New Roman", Font.BOLD,32)), false);
		
		this.text = text;
		
		this.x = 500;
		this.y = 500;
		
	}
	
	
	public void cambioTexto(int a) {
		
		
		text = Integer.toString(a);
		
		
	}
	
	
	
	public void project() {
		
		
		
		
		
		font.drawString(x, y, text);
		
		
	}
	
	
	
	
	
}
