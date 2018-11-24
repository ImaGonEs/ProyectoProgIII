package Datos;
import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class Game {
		
	//private Map grid;
	private Player player;
	//private WManager wave;
	Level l;	
	//temp variables	
	TowerCannon tower;
	
	public Game(int[][] map,int a) {
		
		//grid = new Map(map);
		l = new Level(a);
		

	
		//tower = new TowerCannon(QuickCast("torre"), grid.getCell(15, 15), 10);

		//player = new Player(l.getMap());

		player = new Player(l.getMap(), l.getWave());

		
//		Enemy[] enemies = {(new Enemy(QuickCast("Mob0"),grid.getCell(0,14),grid, 32,32,80,70)),
//							(new Enemy(QuickCast("sans"),grid.getCell(0,14),grid, 32,32,80,70)),
//							(new Enemy(QuickCast("st"),grid.getCell(0,14),grid, 32,32,80,70))};
//				
//				
//		
//		
//		
//		
//		wave = new WManager(enemies,2,2); 
//		
		
		

	//	tower = new TowerCannon(QuickCast("torre"),l.getMap().getCell(15, 15), 10);

		//tower = new TowerCannon(QuickCast("torre"),l.getMap().getCell(15, 15), 10, l.getWave().getEnemies());

	}
	
	public void update() {
		
		l.getMap().project();
		l.getWave().update();
		//tower.update();

		player.Update();
		
		
		//l.getMap().updateT();
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}
	
	
}
