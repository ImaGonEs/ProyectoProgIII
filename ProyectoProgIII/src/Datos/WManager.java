 package Datos;


import java.util.ArrayList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WManager {

	
	private int enemiesCD;
	private int waveNumber, enemiesN;
	private Enemy enemyType;
	private Wave cWave;
	private ArrayList<Enemy> enemyTypes; 
	
	private static Logger logger = Logger.getLogger( "LoggerOleadas" );



		static {
        try {
            logger.setLevel( Level.FINEST);
            logger.addHandler( new FileHandler( "LoggerOleadas.xml") );
        } catch (Exception e) {}
		}
	
	public WManager(ArrayList<Enemy> enemyTypes,int enemiesCD, int enemiesN) {
		
		
		
		this.enemiesCD = enemiesCD;
		this.enemiesN = enemiesN;
		
		this.waveNumber = 0;
		
		this.cWave = null;
		
		this.enemyTypes = enemyTypes;
		
		projectW();
		
		
	}
	
	
	public void update() {
		
		if (!cWave.isCompleted())
			cWave.update();
		else {
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
		
		
		logger.log(Level.FINER,"Beggining wave " + waveNumber);
		
		}else {
			logger.log(Level.FINEST,"END OF LEVEL");
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



	
	
	
	

}
