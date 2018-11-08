package Datos;
import static weareSupports.Creador.*;

public class Game {
		
	private Map grid;
	private Player player;
	private WManager wave;
		
	//temp variables	
	TowerCannon tower;
	
	public Game(int[][] map) {
		
		grid = new Map(map);
		player = new Player(grid);
		wave = new WManager(new Enemy(QuickCast("Mob0"),grid.getCell(0,14),grid, 32,32,40,70),
				4,5); 
		
		
		tower = new TowerCannon(QuickCast("torre"), grid.getCell(15, 15), 10);
	}
	
	public void update() {
		
		grid.Project();
		wave.update();
		player.Update();
		
		grid.UpdateT();
	}
	
	
}
