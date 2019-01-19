 package Datos;

import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;
import java.util.Random;

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
		
		projectW();
		
		
	}
	
	
	public void update() {
		
		if (!cWave.isCompleted())
			cWave.update();
		else {
			//System.out.println("wave is over");
			//this.enemyType.setTex(QuickCast("sans"));
			projectW();
		}
	}
	
	Random r = new Random();
	public void projectW() {
		
		if (waveNumber<enemyTypes.size()) {
		
		enemyType = enemyTypes.get(waveNumber);
		cWave = new Wave (enemyType,enemiesCD,enemiesN);
		waveNumber++;
		
		if (this.enemiesN>2 && this.enemiesN<10) {
			
			int rand = r.nextInt(2);
			if (rand == 0)
				this.enemiesN++;
			else
				this.enemiesN--;
		}else if (this.enemiesN==2)
			this.enemiesN++;
		else if (this.enemiesN == 10)
			this.enemiesN--;
		//this.enemiesN++;
		
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
	public void setWaveMapKill(int mapkill) {
		this.cWave.setMapkill(mapkill);
	}

	public int getWaveNumber() {
		return waveNumber;
	}


	public void setWaveNumber(int waveNumber) {
		this.waveNumber = waveNumber;
	}


	public int getEnemiesN() {
		return enemiesN;
	}


//	public void setEnemiesN(int enemiesN) {
//		this.enemiesN = enemiesN;
//	}
	
	
	
	

}
