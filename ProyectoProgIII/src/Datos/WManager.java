 package Datos;

import static weareSupports.Creador.QuickCast;

public class WManager {

	
	private int waveCD, enemiesCD;
	private int waveNumber, enemiesN;
	private Enemy enemyType;
	private Wave cWave;
	
	
	public WManager(Enemy enemyType,int enemiesCD, int enemiesN) {
		
		
		this.enemyType = enemyType;
		this.enemiesCD = enemiesCD;
		this.enemiesN = enemiesN;
		
		this.waveCD = 0;
		this.waveNumber = 0;
		
		this.cWave = null;
		
		ProjectW();
		
		
	}
	
	
	public void update() {
		
		if (!cWave.isCompleted())
			cWave.Update();
		else {
			//System.out.println("wave is over");
			this.enemyType.setTex(QuickCast("st"));
			ProjectW();
		}
	}
	
	public void ProjectW() {
		
		cWave = new Wave (enemyType,enemiesCD,enemiesN);
		waveNumber++;
		System.out.println("Beggining wave " + waveNumber);
		
	}
	
	
	

}
