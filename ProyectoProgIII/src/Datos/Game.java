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
	
	public Game(int[][] map) {
		
		//grid = new Map(map);
		l = new Level();
		
<<<<<<< HEAD
	
		//tower = new TowerCannon(QuickCast("torre"), grid.getCell(15, 15), 10);

		player = new Player(l.getMap());
=======
		player = new Player(l.getMap(), l.getWave());
>>>>>>> branch 'master' of https://github.com/ImaGonEs/ProyectoProgIII
		
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
		
		
<<<<<<< HEAD
		tower = new TowerCannon(QuickCast("torre"),l.getMap().getCell(15, 15), 10);

=======
		//tower = new TowerCannon(QuickCast("torre"),l.getMap().getCell(15, 15), 10, l.getWave().getEnemies());
>>>>>>> branch 'master' of https://github.com/ImaGonEs/ProyectoProgIII
	}
	
	public void update() {
		
		l.getMap().Project();
		l.getWave().update();
		//tower.update();

		player.Update();
		
		
		l.getMap().UpdateT();
	}
	
	
}
