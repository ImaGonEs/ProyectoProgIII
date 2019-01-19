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
	private int enemiesSpawned;
	private int mapkill;
	
	public Wave( Enemy enemyType, int cooldown, int enemiesN) {
		super();
		this.cooldown = cooldown;
		this.enemyType = enemyType;
		this.enemiesN = enemiesN;
		this.timeL =0;
		this.wave = new ArrayList<Enemy>();
		this.waveCompleted = false;
		this.enemiesSpawned = 0;
		this.mapkill = 0;
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
			if (e.mapKIll()&&e.mapkillseen) {
				mapkill++;
				e.setMapkillseen(false);
			}
		}
		if (allEnemiesDead)
			waveCompleted = true;
	}
	
	private void projectW() {
		
		wave.add(new Enemy(enemyType.getTex(0),enemyType.getTex(1),enemyType.getStart(),enemyType.getMap(),32,32,enemyType.getVel(),enemyType.getLp()));
		
		//enemiesSpawned++;
		
		
	}
	public boolean isCompleted() {
		return waveCompleted;
	}
	public int mapKill() {
		return mapkill;
	}
	public void setMapkill(int mapkill) {
		this.mapkill = mapkill;
	}
	public ArrayList<Enemy> getEnemies() {
		return wave;
	}
}
