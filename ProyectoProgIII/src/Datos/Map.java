package Datos;


public class Map {

	
	public MapCell[][] map;
	private int cellsWide, cellsHigh;
	int [][] abc;
	public int oro;
	
	public Map() {
		map = new MapCell[30][40];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {	
				map[i][j] = new MapCell(i*64,j*64,64,64,TileType.Dirt0,  TileType.Dirt0.cc);	
			}
		}		
	}
	
	public Map(int [][] a) {

		this.cellsWide = a[0].length;
		this.cellsHigh = a.length;

		abc = a;
		map = new MapCell[40][30];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

				if (a[j][i]==0) {

					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Grass0,TileType.Grass0.cc);

				}else if (a[j][i]==1) {

					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt0, TileType.Dirt0.cc);


				}else if (a[j][i]==3) {

					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt0, TileType.Dirt0.cc);


				}else if (a[j][i]==4) {

					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Grass0, TileType.Grass0.cc);

				}else {

					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Grass0, TileType.Grass0.cc);

				}			
			}
		}

	}
	
	/* 
	 * @return Devuelve el array de enteros del Mapa
	 * */
	public int[][] getAbc() {
		return abc;
	}

	public void setAbc(int[][] abc) {
		this.abc = abc;
	}

	public void project() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {			
				MapCell c = map[i][j];			
				c.project();
			}
		}
	}
	
	public void setCell (int x, int y, TileType type, boolean r) {	
		map[x][y] = new MapCell(x*32,y*32,32,32,type,r);
	}

	public MapCell getCell(int x, int y) {
		if (x < cellsWide && y < cellsHigh && x > -1 && y > -1)	
		return map[x][y];
		else
			return new MapCell(0,0,0,0, TileType.Dirt0, TileType.Dirt0.cc);	
	}
	
	
	public MapCell[][] getMap() {
		return map;
	}

	public void setMap(MapCell[][] map) {
		this.map = map;
	}

	public int getCellsWide() {
		return cellsWide;
	}

	public void setCellsWide(int cellsWide) {
		this.cellsWide = cellsWide;
	}

	public int getCellsHigh() {
		return cellsHigh;
	}

	public void setCellsHigh(int cellsHigh) {
		this.cellsHigh = cellsHigh;
	}
	
	
}
