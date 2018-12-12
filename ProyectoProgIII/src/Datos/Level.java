package Datos;

import static weareSupports.Creador.QuickCast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Level {
	
	private Map grid;
	private WManager wave;
	ArrayList<Enemy> enemies;
	
	
	
//	int[][] imap = {
//			
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, },
//			{1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
//			{11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11, 11},
//			{11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11, 11},
//			{11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11, 11},
//			};

	
	protected static void guardaFichero(int[] [] y){
		
		FileOutputStream fich = null;
		ObjectOutputStream li = null;
		
		
	
		
		try {
			
			fich = new FileOutputStream("src/res/Mapa3.txt");
			li = new ObjectOutputStream(fich);
			li.writeObject(y);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	           try {
	               
	               if (null != fich)
	                  fich.close();
	               } catch (Exception e2) {
	                  e2.printStackTrace();
	               }
	            }
	}
	
	
	
	protected static int [][] leeFichero (String name) {
		
		
		FileInputStream fich = null;
		ObjectInputStream l = null;
		int[][] s= new int[][] {{1,2,3}};
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("src/res/"+name+".txt"));
			if (br.readLine()!=null) {
				
			fich = new FileInputStream ("src/res/"+name+".txt");
			
			l = new ObjectInputStream(fich);
			
		
			
		
			s = (int[][]) l.readObject();
			
			fich.close();
			}
			
		} catch ( ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, "Ningún archivo de guardado encontrado, ¡se generara uno en cuanto guardes el primer Estado Inicial!");
			
			//System.out.println("Ningún archivo de guardado encontrado, ¡se generara uno en cuanto guardes el primero!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
		
		
	}
	
	
	
	public Level(int a, String mapa) {
		
		
		
		grid = new Map(leeFichero(mapa));
		
		

//		Enemy[] enemies = {(new Enemy(QuickCast("Mob0"),grid.getCell(0,14),grid, 32,32,80,70)),
//				(new Enemy(QuickCast("sans"),grid.getCell(0,14),grid, 32,32,80,70)),
//				(new Enemy(QuickCast("st"),grid.getCell(0,14),grid, 32,32,80,70))};
//	
//
//wave = new WManager(enemies,2,2); 

		
		enemies= new ArrayList<Enemy>();
		
//				enemies.add(new Enemy(QuickCast("monster"),QuickCast("monster"),grid.getCell(0,14),grid, 32,32,80,100*(a+1)));
//				enemies.add(new Enemy(QuickCast("sans"),QuickCast("sans"),grid.getCell(0,14),grid, 32,32,80,300*(a+1)));
				enemies.add(new Enemy(QuickCast("Mob0"),QuickCast("Mob0S"),grid.getCell(0,14),grid, 32,32,80,100*(a+1)));
				enemies.add(new Enemy(QuickCast("seta"),QuickCast("seta"),grid.getCell(0,14),grid, 32,32,80,100*(a+1)));
				enemies.add(new Enemy(QuickCast("crab"),QuickCast("crab"),grid.getCell(0,14),grid, 32,32,80,100*(a+1)));
				enemies.add(new Enemy(QuickCast("SkeletonLight"),QuickCast("SkeletonLight"),grid.getCell(0,14),grid, 32,32,80,100*(a+1)));
				enemies.add(new Enemy(QuickCast("Mob0"),QuickCast("Mob0S"),grid.getCell(0,14),grid, 32,32,80,100*(a+1)));
				enemies.add(new Enemy(QuickCast("seta"),QuickCast("seta"),grid.getCell(0,14),grid, 32,32,80,100*(a+1)));
				
				//(new Enemy(QuickCast("st"),grid.getCell(0,14),grid, 32,32,80,70))};


				wave = new WManager(enemies,1,3); 

	}
//	public int[][] getImap() {
//		return imap;
//	}
//	public void setImap(int[][] imap) {
//		this.imap = imap;
//	}
	public Map getMap() {
		return this.grid;
	}
	public WManager getWave() {
		return this.wave;
	}
	public ArrayList<Enemy> getEnemies() {
		return this.enemies;
	}
	
	
}
