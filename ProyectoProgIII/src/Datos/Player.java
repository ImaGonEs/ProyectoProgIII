package Datos;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static weareSupports.Creador.*;
public class Player {

	private Map map;
	private TileType[] types;
	private int i;
	
	
	
	public Player (Map map) {
		
		this.map = map;
		
		this.types = new TileType[2];
		this.types[0] = TileType.Dirt0;
		this.types[1] = TileType.Grass0;
		this.i = 0;
		
		
		
	}
	
	public void SetTile() {
		
		map.setCell((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32), types[i] );
		
		
		
	}
	
	public void setTower () { //para poner la torre con el click, no se mantiene
		
		
		TowerCannon a = new TowerCannon();
		
		map.setTower((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32), a);
	
	
		
		
	}
	
	
	private boolean mouseButton1 = false;
	
	public void Update() {
		
		while (Mouse.next()){
		    if (Mouse.getEventButtonState()) {
		        if (Mouse.getEventButton() == 0) {
		            //System.out.println("Left button pressed");
		        }
		    }else {
		        if (Mouse.getEventButton() == 0) {
		            //System.out.println("Left button released");
		            setTower();
		        }
		    }
		}
		
		
		while (Keyboard.next()) {
			
			if ( Keyboard.getEventKey()== Keyboard.KEY_D && Keyboard.getEventKeyState()){	
				Mindex();
				System.out.println(i);
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
