 package Datos;

import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class WManager {

	
	private int waveCD, enemiesCD;
	private int waveNumber, enemiesN;
	private Enemy enemyType;
	private Wave cWave;
	
	
	private ArrayList<Enemy> enemyTypes; //----------------
	
	public WManager(ArrayList<Enemy> enemyTypes,int enemiesCD, int enemiesN) {
		
		
		//this.enemyType = enemyType;
		this.enemiesCD = enemiesCD;
		this.enemiesN = enemiesN;
		
		this.waveCD = 0;
		this.waveNumber = 0;
		
		this.cWave = null;
		
		this.enemyTypes = enemyTypes;
		
		ProjectW();
		
		
	}
	
	
	public void update() {
		
		if (!cWave.isCompleted())
			cWave.Update();
		else {
			//System.out.println("wave is over");
			//this.enemyType.setTex(QuickCast("sans"));
			ProjectW();
		}
	}
	
	public void ProjectW() {
		
		if (waveNumber<enemyTypes.size()) {
		
			enemyType = enemyTypes.get(waveNumber);
		cWave = new Wave (enemyType,enemiesCD,enemiesN);
		waveNumber++;
		
		this.enemiesN++;
		
		System.out.println("Beggining wave " + waveNumber);
		}else {
			System.out.println("END OF LEVEL");
		}
	}
	
	public ArrayList<Enemy> getEnemies() {
		return this.enemyTypes;
		
	}
	public Wave getWave() {
		return this.cWave;
	}
	
	
	
	

}
