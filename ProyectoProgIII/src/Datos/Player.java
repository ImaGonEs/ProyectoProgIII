package Datos;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import weareSupports.BDlocal;

import static weareSupports.Creador.*;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Player {

	private Map map;
	private TileType[] types;
	
	private int i; //hacer otra clase para el editor
	
	
	private WManager wManager;
	private ArrayList<Tower> towerList;
	private int oroint=2000;
	private int nWave ;
	private ArrayList<String> team = new ArrayList<String>();
	
	boolean b = true;
	
	private Texto textWin = new Texto("", 500, 500,120);
	private Texto oro, tWave, textWave, textGold, tHP, textHP,tQ,tW,tE,tR;
	private int hp;
	Properties prop= new Properties();
	InputStream input=null;
	String player;
	Tower toQ,toW,toE,toR;
	




	public Player (Map map, WManager wManager) {
		
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			player= prop.getProperty("username");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.map = map;
		this.types = new TileType[2];
		this.types[0] = TileType.Dirt0;
		this.types[1] = TileType.Grass0;
		
		this.i = 0;
		
		this.wManager = wManager;
		this.towerList = new ArrayList<Tower>();
		this.hp = 100;
		this.textWave = new Texto("WAVE: ", 50, 50);
		this.tWave = new Texto(Integer.toString(nWave), 250, 50);
		this.textGold = new Texto("GOLD: ", 350, 50);
		this.oro = new Texto(Integer.toString(oroint),500, 50);
		this.textHP = new Texto("HP:", 700, 50);
		this.tHP = new Texto(Integer.toString(hp), 800, 50);
		this.team = leeTeam(player);
		
		this.tQ = new Texto("Q",50, 900);
		this.tW = new Texto("W",150, 900);
		this.tE = new Texto("E",250, 900);
		this.tR = new Texto("R",350, 900);
	
		  toQ =  new TowerThunder(TowerType.valueOf(team.get(0)), map.getCell(3, 28),wManager.getWave().getEnemies());
		  toW =  new TowerThunder(TowerType.valueOf(team.get(1)), map.getCell(6, 28),wManager.getWave().getEnemies());
		  toE =  new TowerThunder(TowerType.valueOf(team.get(2)), map.getCell(9, 28),wManager.getWave().getEnemies());
		  toR =  new TowerThunder(TowerType.valueOf(team.get(3)), map.getCell(12, 28),wManager.getWave().getEnemies());
		
		
		  	toQ.project();
		  	toW.project();
			toE.project();
			toR.project();
	}

	

	
@SuppressWarnings("unchecked")
public static ArrayList<String> leeTeam (String name) {
		

		FileInputStream fich = null;
		ObjectInputStream l = null;
		ArrayList<String> s = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/res/Team"+name+".txt"));
			if (br.readLine()!=null) {
			fich = new FileInputStream ("src/res/Team"+name+".txt");
			l = new ObjectInputStream(fich);
			s = (ArrayList<String>) l.readObject();	
			fich.close();
			}

		} catch ( ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("No has creado tu primer team");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;



	}

	public void SetTile() {

		map.setCell((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32), types[i],false );

	}

	private boolean win = false;

	public void Update() {

		
		
		
	oro.project();
	tWave.project();
	textWin.project();
	textWave.project();
	textGold.project();
	textHP.project();
	tHP.project();
	tQ.project();
	tW.project();
	tE.project();
	tR.project();

	toQ.project();
	toW.project();
	toE.project();
	toR.project();
	
	for (Tower t : towerList) {
		t.update();
		t.project();
		t.updateEnemyList(wManager.getWave().getEnemies());
	}	


		while (Keyboard.next()) {

			if(oroint >= 500) {
				if(!team.isEmpty()) {
					if ( Keyboard.getEventKey()== Keyboard.KEY_Q && Keyboard.getEventKeyState()){	
						i = 0;
						if (getMouseCell().getR()) {
							putTower(team.get(0));
							getMouseCell().setR(false);
							oroint = oroint-500;
							oro.cambioTexto(oroint);
						}
					}

					if ( Keyboard.getEventKey()== Keyboard.KEY_W && Keyboard.getEventKeyState()){	
						i = 1;
						if (getMouseCell().getR()) {
							putTower(team.get(1));
							getMouseCell().setR(false);
							oroint = oroint-500;
							oro.cambioTexto(oroint);
						}
					}

					if ( Keyboard.getEventKey()== Keyboard.KEY_E && Keyboard.getEventKeyState()){	

						if (getMouseCell().getR()) {
							putTower(team.get(2));
							getMouseCell().setR(false);
							oroint = oroint-500;
							oro.cambioTexto(oroint);
						}

					}
					if ( Keyboard.getEventKey()== Keyboard.KEY_R && Keyboard.getEventKeyState()){	
						if (getMouseCell().getR()) {
							putTower(team.get(3));
							getMouseCell().setR(false);
							oroint = oroint-500;
							oro.cambioTexto(oroint);
						}
					}
				}
			}
		}

		nWave = wManager.getWaveNumber();
		tWave.cambioTexto(nWave);
		
			
		if (wManager.getWaveNumber()==6 &&wManager.getWave().isCompleted()) {
			textWin = new Texto("¡VICTORIA! +100 GEMAS! ", 300, 400, 64);
			if(!win) {
				BDlocal bd = new BDlocal();
				bd.updateGems(player, "+100");
				win = true;
			}
		}



		if (wManager.getWave().isCompleted()&&wManager.getWaveNumber()<6) {
			oroint += 1000;
			oro.cambioTexto(oroint);
		}
		
		if(wManager.getWave().mapKill()> 0) {
			hp -= 50*wManager.getWave().mapKill();
			this.wManager.setWaveMapKill(0);
			tHP.cambioTexto(hp);
			if(hp<=0) {
				try {
					
					Display.destroy();
				}catch (Exception e) {

				}
			}

		}
	}

	
	public void putTower(String t) {

		if (t.equals("T01"))
			towerList.add(new TowerThunder(TowerType.valueOf(t), getMouseCell(),wManager.getWave().getEnemies()));

		else if (t.equals("T02")) 
			towerList.add(new TowerFire(TowerType.valueOf(t), getMouseCell(),wManager.getWave().getEnemies()));

		else if (t.equals("T03")) 
			towerList.add(new TowerIce(TowerType.valueOf(t), getMouseCell(),wManager.getWave().getEnemies()));

		else if (t.equals("T04")) 
			towerList.add(new TowerPoison(TowerType.valueOf(t), getMouseCell(),wManager.getWave().getEnemies()));

		else if (t.equals("T05")) 
			towerList.add(new TowerPurpl(TowerType.valueOf(t), getMouseCell(),wManager.getWave().getEnemies()));

		else if (t.equals("T06")) 
			towerList.add(new TowerRed(TowerType.valueOf(t), getMouseCell(),wManager.getWave().getEnemies()));

		else if (t.equals("T07")) 
			towerList.add(new TowerGreen(TowerType.valueOf(t), getMouseCell(),wManager.getWave().getEnemies()));

	}

	public MapCell getMouseCell() {
		return map.getCell(Mouse.getX()/32, (HEIGHT - Mouse.getY() - 1 )/32);
	}


}