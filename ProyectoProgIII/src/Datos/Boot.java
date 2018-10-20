package Datos;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;
import static weareSupports.Creador.*;
public class Boot {


	
	
	
	int x =100;
	int y = 100;
	
	public Boot() {
		
		TraceOn();
		
		int w = 50;
		int h = 50;
		
		while (!Display.isCloseRequested()) {
			
			ProjectQuad(100,100,50,50);
			
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
