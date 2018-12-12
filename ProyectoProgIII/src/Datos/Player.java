package Datos;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;



import static weareSupports.Creador.*;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Player {

	private Map map;
	private TileType[] types;
	private int i; //hacer otra clase para el editor
	private WManager wManager;
	private ArrayList<Tower> towerList;
	private ArrayList<TowerMelee> towerList2;
	private int oroint=15000;
	private Texto oro;
	private int nWave ;
	private Texto tWave;
	private ArrayList<String> team = new ArrayList<String>();
	boolean b = true;
	
	public Player (Map map, WManager wManager) {
		
		this.map = map;
		
		this.types = new TileType[2];
		this.types[0] = TileType.Dirt0;
		this.types[1] = TileType.Grass0;
		this.i = 0;
		this.wManager = wManager;
		this.towerList = new ArrayList<Tower>();
		this.towerList2 = new ArrayList<TowerMelee>();
		
		this.oro = new Texto(Integer.toString(oroint), 100, 100);
		
		this.tWave = new Texto(Integer.toString(nWave), 100, 200);
		this.team = leeTeam("Team");
		
		
		
		
			
	}
	
//	public void updateEnemyList (ArrayList<Enemy> newList) { 
//		for (TowerCannon t :towerList)
//			t.updateEenemyList(wManager.getWave().getEnemies());
//			
//	}
	
@SuppressWarnings("unchecked")
protected static ArrayList<String> leeTeam (String name) {
		
		
		FileInputStream fich = null;
		ObjectInputStream l = null;
		ArrayList<String> s = new ArrayList<String>();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("src/res/"+name+".txt"));
			if (br.readLine()!=null) {
				
			fich = new FileInputStream ("src/res/"+name+".txt");
			
			l = new ObjectInputStream(fich);
			
		
			
		
			s = (ArrayList<String>) l.readObject();
			
			fich.close();
			}
			
		} catch ( ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			
			//JOptionPane.showMessageDialog(null, "No has creado tu Team!");
			
			//System.out.println("Ningún archivo de guardado encontrado, ¡se generara uno en cuanto guardes el primero!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
		
		
	}




	public void SetTile() {
		
		map.setCell((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32), types[i],false );
			
	}
	
	//ESTE MOTODO NO SE USA YA, HABRA QUE QUITARLO
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
		
		
	oro.project();
	tWave.project();
	
	
	for (Tower t : towerList) {
		t.update();
		t.project();
		t.updateEnemyList(wManager.getWave().getEnemies());
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
			
			
			//HE PUESTO QUE TODAS VALGAN 500 PORQUE FALTA LA BD
			
			if(oroint >= 500) {
			if(!team.isEmpty()) {
			if ( Keyboard.getEventKey()== Keyboard.KEY_Q && Keyboard.getEventKeyState()){	
				i = 0;
				//setTower();
				//towerList.add(new TowerCannon(QuickCast("torre"),map.getCell((int)(Math.floor(Mouse.getX()) / 32),(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32)),3,1000, wManager.getWave().getEnemies()));
				
				if (getMouseCell().getR()) {
				

					putTower(team.get(0));
//				towerList.add(new TowerFire(TowerType.valueOf(id().get(0)), getMouseCell(),wManager.getWave().getEnemies()));
				getMouseCell().setR(false);

				
				oroint = oroint-500;
				oro.cambioTexto(oroint);
				}
				
			}
			
			if ( Keyboard.getEventKey()== Keyboard.KEY_W && Keyboard.getEventKeyState()){	
				i = 1;
				//towerList2.add(new TowerMelee(QuickCast("Mob0"), map.getCell((int)(Math.floor(Mouse.getX()) / 32),
						//(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32)), 3, wManager.getWave().getEnemies()));

				if (getMouseCell().getR()) {
					
					putTower(team.get(1));
//				towerList.add(new TowerIce(TowerType.valueOf(id().get(1)), map.getCell(Mouse.getX()/32, 
//						(HEIGHT - Mouse.getY() - 1 )/32),wManager.getWave().getEnemies()));
						getMouseCell().setR(false);

				
				oroint = oroint-500;
				oro.cambioTexto(oroint);
				}
				//towerList.add(new TowerCannonS(TowerType.CannonS, map.getCell(10, 10)));
				
				//towerList.add(new TowerCannonS(TowerType.CannonS, map.getCell(10, 10)));
				
			}
			
			if ( Keyboard.getEventKey()== Keyboard.KEY_E && Keyboard.getEventKeyState()){	
			
				//towerList2.add(new TowerCannonS(TowerType.CannonS, map.getCell((int)(Math.floor(Mouse.getX()) / 32),
					//	(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32)), 3, wManager.getWave().getEnemies()));

				if (getMouseCell().getR()) {
					
					putTower(team.get(2));
//				towerList.add(new TowerPoison(TowerType.valueOf(id().get(2)), map.getCell(Mouse.getX()/32, 
//						(HEIGHT - Mouse.getY() - 1 )/32),wManager.getWave().getEnemies()));
					getMouseCell().setR(false);

			
				
				oroint = oroint-500;
				oro.cambioTexto(oroint);
				}
				
			}
			if ( Keyboard.getEventKey()== Keyboard.KEY_R && Keyboard.getEventKeyState()){	
				
				//towerList2.add(new TowerCannonS(TowerType.CannonS, map.getCell((int)(Math.floor(Mouse.getX()) / 32),
					//	(int)( Math.floor(HEIGHT - Mouse.getY()-1)/32)), 3, wManager.getWave().getEnemies()));
				
				//towerList.add(new TowerCannonS(TowerType.CannonS, map.getCell(Mouse.getX()/32, (HEIGHT - Mouse.getY() - 1 /32))));

				if (getMouseCell().getR()) {
					putTower(team.get(3));
//				towerList.add(new TowerThunder(TowerType.valueOf(id().get(3)), map.getCell(Mouse.getX()/32, 
//						(HEIGHT - Mouse.getY() - 1 )/32),wManager.getWave().getEnemies()));
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
		
		
		
		
		
	
		//System.out.println(wManager.getWave().isCompleted());
		
		
		
			if (wManager.getWave().isCompleted()&&wManager.getWaveNumber()<6) {

				System.out.println(wManager.getEnemiesN());
				oroint += 100*(wManager.getEnemiesN()-1);
				oro.cambioTexto(oroint);
		
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
	
	public static ArrayList<String> id() {
		
		
		Connection c = null;
		Statement stmt = null;
		   ArrayList<String> ids = new ArrayList<>();
		   try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
			      c.setAutoCommit(false);
			      System.out.println("Opened database successfully");

			      stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery( "SELECT ID FROM TOWERS;" );
			      
			      while ( rs.next() ) {
			         
			         String  id = rs.getString("id");
			         
			        ids.add(id);
			         
			      }
			      rs.close();
			      stmt.close();
			      c.close();
			   } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			   }
			   System.out.println("Operation done successfully");
		
		return ids;
				
	};
	
	
	
	private void Mindex () {
		
		i++;
		
		if(i > types.length -1) {
			
			i =0;
			
			
		}
		
		
		
	}
	
}