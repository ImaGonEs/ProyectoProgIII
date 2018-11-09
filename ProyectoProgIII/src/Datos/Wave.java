package Datos;

import java.util.ArrayList;
import static weareSupports.Clock.*;
public class Wave {

	private int cooldown;
	private float timeL;
	private Enemy enemyType;
	private ArrayList<Enemy> wave;
	private int enemiesN;
	private boolean waveCompleted;
	
	public Wave( Enemy enemyType, int cooldown, int enemiesN) {
		super();
		this.cooldown = cooldown;
		this.enemyType = enemyType;
		this.enemiesN = enemiesN;
		this.timeL =0;
		this.wave = new ArrayList<Enemy>();
		this.waveCompleted = false;
		
		projectW();
	}
	
	public void update() {
		 
		boolean allEnemiesDead = true;
		
		if (wave.size() < enemiesN) {	
		timeL += Delta();
			if(timeL>cooldown) {
			projectW();
			timeL=0;
			}
		}
		for (Enemy e : wave) {
			if (e.isAlive()) {
				allEnemiesDead = false;
				e.update();
				e.project();
			}
		}
		if (allEnemiesDead)
			waveCompleted = true;
	}
	
	private void projectW() {
		
		wave.add(new Enemy(enemyType.getTex(),enemyType.getStart(),enemyType.getMap(),32,32,enemyType.getVel(),enemyType.getLp()));
		
		
		
	}
	public boolean isCompleted() {
		return waveCompleted;
	}
	public ArrayList<Enemy> getEnemies() {
		return wave;
	}
}
