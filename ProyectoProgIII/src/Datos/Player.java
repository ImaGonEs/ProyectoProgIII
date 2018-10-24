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
	
	public void Update() {
		
		if(Mouse.isButtonDown(0)) {
			
			
			SetTile();
			
			
			
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
