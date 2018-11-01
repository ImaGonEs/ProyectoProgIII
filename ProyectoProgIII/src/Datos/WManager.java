 package Datos;

import static weareSupports.Creador.QuickCast;

import java.util.ArrayList;

public class WManager {

	
	private int waveCD, enemiesCD;
	private int waveNumber, enemiesN;
	private Enemy enemyType;
	private Wave cWave;
	
	
	private Enemy[] enemyTypes; //----------------
	
	public WManager(Enemy[] enemyTypes,int enemiesCD, int enemiesN) {
		
		
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
		
		if (waveNumber<enemyTypes.length) {
		enemyType = enemyTypes[waveNumber
		                       ];
		cWave = new Wave (enemyType,enemiesCD,enemiesN);
		waveNumber++;
		
		this.enemiesN++;
		
		System.out.println("Beggining wave " + waveNumber);
		}else {
			System.out.println("END OF LEVEL");
		}
	}
	
	
	
	

}
