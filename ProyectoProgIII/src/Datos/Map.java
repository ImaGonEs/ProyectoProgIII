package Datos;

public class Map {

	
	public MapCell[][] map;
	
	public Map() {
		
		map = new MapCell[20][15];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				map[i][j] = new MapCell(i*64,j*64,64,64,TileType.Grass);
				
				
			}
		}
		
		
	}
	
	public void Project() {
		
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				MapCell c = map[i][j];
				
				c.Project();
				
				
				
			}
		}
		
		
		
		
	}
	
	
}
