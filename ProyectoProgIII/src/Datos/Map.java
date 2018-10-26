package Datos;

import static weareSupports.Creador.*;

import java.util.ArrayList;

public class Map {

	
	public MapCell[][] map;
	private int cellsWide, cellsHigh;
	private ArrayList<TowerCannon> towerC;
	private ArrayList<TowerMelee> towerM;
	public Map() {
		
		map = new MapCell[20][15];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				map[i][j] = new MapCell(i*64,j*64,64,64,TileType.Dirt0);
				
				
			}
		}
		
		
	}
	
	public Map(int [][] a) {
	
		this.cellsWide = a[0].length;
		this.cellsHigh = a.length;
		
		map = new MapCell[40][30];
		
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				if (a[j][i]==0) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Grass0);

				}else if (a[j][i]==1) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt0);
					
					
				}else if (a[j][i]==11) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt1);
					
					
				}else if (a[j][i]==12) {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt2);
					
					
					
				}else {
					
					map [i][j] = new MapCell(i*32,j*32,32,32,TileType.Dirt0);
					
				}
				
				
				
			}
		}
		
		towerC = new ArrayList<TowerCannon>();
		towerM = new ArrayList<TowerMelee>();
		
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
	
	public void setTowerC (int x, int y, TowerCannon a) {
		
		
		a = new TowerCannon(QuickCast("torre"),map[x][y],3);
		towerC.add(a);
		
		
	}
	
	public void setTowerM (int x, int y, TowerMelee a) {
		
		
		a = new TowerMelee(QuickCast("Mob0"),map[x][y],3);
		towerM.add(a);
		
		
	}
	
	
	public void UpdateT() {
		
		for (TowerCannon t : towerC) {
			t.update();
			//t.project();
			
		}
		
		for (TowerMelee m : towerM) {
			
			m.update();
			
			
			
		}
		
		
		
	}
	
	
	
	public MapCell getCell(int x, int y) {
		
		
		if (x < cellsWide && y < cellsHigh && x > -1 && y > -1)
			
		return map[x][y];
		
		else
			return new MapCell(0,0,0,0, TileType.Dirt2);
		
		
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
