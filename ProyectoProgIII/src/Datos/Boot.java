package Datos;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static weareSupports.Creador.*;
public class Boot {


	
	
	

	
	public Boot() {
		
		TraceOn();
		
		Map map = new Map();
		
		
		
		while (!Display.isCloseRequested()) {
			
		map.Project();
			
			Display.update();
			Display.sync(120);
		}
		Display.destroy();
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boot();
	}

}
