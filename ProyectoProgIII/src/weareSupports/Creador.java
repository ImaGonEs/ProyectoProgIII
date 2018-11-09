package weareSupports;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2i;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Creador {
	
	public static final int WIDTH = 1280, HEIGHT = 960;
	public static final int TILE_SIZE = 32;
	
	public static void ProjectQuad(int x, int y, int w, int h) {
		
		glBegin(GL_QUADS);
		glVertex2i(x,y); //arriba izk
		glVertex2i(x + w,y); //Arriba españa
		glVertex2i(x+w,y+h); //Abajo Derecha
		glVertex2i(x,y+h); //Abajo izkierda
		glEnd();
		
		
	}
	
	public static boolean checkCollision(float x1, float y1, float w1, float h1, 
			float x2, float y2, float w2, float h2) {
		
		if (x1 + w1 > x2 && x1 < x2 + w2 && y1 + h1 > y2 && y1 < y2 + h2)
			return true;
		return false;
		
	}
	
	public static void  ProjectTQuad(Texture tex,float x, float y, int w, int h) {
		
		tex.bind();
		glTranslatef(x,y,0);
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2i(0,0);
		glTexCoord2f(1,0);
		glVertex2i(w,0);
		glTexCoord2f(1,1);
		glVertex2i(w,h);
		glTexCoord2f(0,1);
		glVertex2i(0,h);
		glEnd();
		glLoadIdentity();
		
		
	}
	public static Texture LoadT(String path, String fileType) {
		
		Texture tex = null;
		
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Tile no encontrada");
		}
		
		return tex;
		
		
		
		
		
		
	}
	
	public static Texture QuickCast(String name) {
		
		Texture tex = null;
		
		tex = LoadT("src\\res\\"+name+".png","PNG");
		
		
		return tex;
		
	}
	
	
	public static String QuickCastIcon(String name) {
		
		String icon = null;
		
		icon = "src\\res\\"+name+".png";
		
		
		return icon;
		
	}
	
	public static void TraceOn() {
		
		Display.setTitle("Pruebita");
		try {
			Display.setDisplayMode(new DisplayMode(1280, 960));
			//Display.setFullscreen(true);
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
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA); // Permite solapar capas!!!
		
	}
	
	
}
