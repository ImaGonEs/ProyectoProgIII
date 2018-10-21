package Datos;

public class Map {

	
	public MapCell[][] map;
	
	public Map() {
		
		map = new MapCell[20][15];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				map[i][j] = new MapCell(i*64,j*64,64,64,TileType.Dirt0);
				
				
			}
		}
		
		
	}
	
	public Map(int [][] a) {
		
		map = new MapCell[40][30];
		
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				if (a[j][i]==0) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Grass0);

				}else if (a[j][i]==1) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Grass1);
					
					
				}else if (a[j][i]==11) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt1);
					
					
				}else if (a[j][i]==12) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt2);
					
					
					
				}else {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt0);
					
				}
				
				
				
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
	
	public void setCell (int x, int y, TileType type) {
		
		
		map[x][y] = new MapCell(x*32,y*32,32,32,type);
		
		
	}
	
	public MapCell getCell(int x, int y) {
		
		
		
		return map[x][y];
		
		
		
	}
	
	
}
