package Datos;

import org.lwjgl.opengl.Display;
import weareSupports.Clock;
import static weareSupports.Creador.*;


		
		
public class Boot {

	public Boot(int a,String mapa) {
		TraceOn();
		Game game = new Game(a,mapa);
		while (!Display.isCloseRequested()) {		
			Clock.update();		
			game.update();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
}
