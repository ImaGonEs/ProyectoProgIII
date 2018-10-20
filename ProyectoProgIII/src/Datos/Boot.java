package Datos;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static weareSupports.Creador.*;
public class Boot {


	
	
	

	
	public Boot() {
		
		TraceOn();
		
		Texture t = LoadT("res\\g1.png", "PNG");
		
		while (!Display.isCloseRequested()) {
			
			ProjectTQuad(t,0,0,64,64);
			
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
