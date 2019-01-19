package Datos;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class Game {
	
	private Player player;
	Level l;	
	
	public Game(int a,String mapa) {
		l = new Level(a,mapa);
		player = new Player(l.getMap(), l.getWave());
	}
	
	public void update() {
		l.getMap().project();
		l.getWave().update();
		player.Update();
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}
	
	
}
