package Datos;
import static weareSupports.Creador.*;

public class Game {
		
	private Map grid;
	private Player player;
	private Wave wave;
		
	//temp variables	
	TowerCannon tower;
	
	public Game(int[][] map) {
		
		grid = new Map(map);
		player = new Player(grid);
		wave = new Wave(20, new Enemy(QuickCast("mob0"),grid.getCell(0,14),grid, 32,32,20,70)); 
		
		tower = new TowerCannon(QuickCast("torre"), grid.getCell(15, 15), 10);
	}
	
	public void update() {
		
		grid.Project();
		wave.Update();
		player.Update();
		
		grid.UpdateT();
	}
	
	
}
