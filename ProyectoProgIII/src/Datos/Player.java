package Datos;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static weareSupports.Creador.*;

import java.util.ArrayList;
public class Player {

	private Map map;
	private TileType[] types;
	private int i;
	private WManager wManager;
	private ArrayList<TowerCannon> towerList;
	private ArrayList<TowerMelee> towerList2;
	
	
	public Player (Map map, WManager wManager) {
		
		this.map = map;
		
		this.types = new TileType[2];
		this.types[0] = TileType.Dirt0;
		this.types[1] = TileType.Grass0;
		this.i = 0;
		this.wManager = wManager;
		this.towerList = new ArrayList<TowerCannon>();
		this.towerList2 = new ArrayList<TowerMelee>();
		
	}
	
//	public void updateEnemyList (ArrayList<Enemy> newList) { 
//		for (TowerCannon t :towerList)
//			t.updateEenemyList(wManager.getWave().getEnemies());
//			
//	}
	
	public void SetTile() {
		
		map.setCell((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32), types[i],false );
			
	}
	
	public void setTower () { //para poner la torre con el click, no se mantiene
		
		
		if (i==0) {
			
			if(map.getCell(Mouse.getX(), Mouse.getY()).getR()==false) {
				
				
				TowerCannon a = new TowerCannon();
				
				map.setTowerC((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32), a);
				
			
			}
			
	
		}else if (i==1) {
			
			
			if(map.getCell(Mouse.getX(), Mouse.getY()).getR()==false) {
			TowerMelee a = new TowerMelee();
			
			map.setTowerM((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32), a);
			map.getCell(Mouse.getX(), Mouse.getY()).setR(true);
			
			}
		}
		
		
	
	
		
		
	}
	
	
	private boolean mouseButton1 = false;
	
	public void Update() {
		
	for (TowerCannon t : towerList) {
		t.update();
	t.updateEenemyList(wManager.getWave().getEnemies());
	}	
		for (TowerMelee t : towerList2) {
			t.update();
		t.updateEenemyList(wManager.getWave().getEnemies());
		}
		
		while (Mouse.next()){
		    if (Mouse.getEventButtonState()) {
		        if (Mouse.getEventButton() == 0) {
		            //System.out.println("Left button pressed");
		        }
		    }else {
		        if (Mouse.getEventButton() == 0) {
		            //System.out.println("Left button released");
		            
		        }
		    }
		}
		
		
		while (Keyboard.next()) {
			
			if ( Keyboard.getEventKey()== Keyboard.KEY_Q && Keyboard.getEventKeyState()){	
				i = 0;
				//setTower();
				towerList.add(new TowerCannon(QuickCast("torre"),map.getCell((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32)),3,1000, wManager.getWave().getEnemies()));
				
				
			}
			if ( Keyboard.getEventKey()== Keyboard.KEY_W && Keyboard.getEventKeyState()){	
				i = 1;
				towerList2.add(new TowerMelee(QuickCast("Mob0"), map.getCell((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32)), 3, wManager.getWave().getEnemies()));
				
			}


		}

	}
	
	private void Mindex () {
		
		i++;
		
		if(i > types.length -1) {
			
			i =0;
			
			
		}
		
		
		
	}
	
}
