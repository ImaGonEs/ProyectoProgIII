package weareSupports;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

public class Creador {
	
	public static final int WIDTH = 1280, HEIGHT = 960;
	
	public static void ProjectQuad(int x, int y, int w, int h) {
		
		glBegin(GL_QUADS);
		glVertex2i(x,y); //arriba izk
		glVertex2i(x + w,y); //Arriba españa
		glVertex2i(x+w,y+h); //Abajo Derecha
		glVertex2i(x,y+h); //Abajo izkierda
		glEnd();
		
		
	}
	
	public static void  ProjectTQuad(Texture tex,int x, int y, int w, int h) {
		
		tex.bind();
		glTranslatef(x,y,0);
		
		
		
	}
	
	
	
	public static void TraceOn() {
		
		Display.setTitle("Pruebita");
		try {
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,WIDTH,HEIGHT,0,1,-1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		
	}
	
	
}
