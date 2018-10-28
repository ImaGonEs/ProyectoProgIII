package Datos;

import java.util.ArrayList;
import static weareSupports.Clock.*;
public class Wave {

	private int cooldown;
	private float timeL;
	private Enemy enemyType;
	private ArrayList<Enemy> wave;
	private int enemiesN;
	
	public Wave( Enemy enemyType, int cooldown, int enemiesN) {
		super();
		this.cooldown = cooldown;
		this.enemyType = enemyType;
		this.enemiesN = enemiesN;
		timeL =0;
		wave = new ArrayList<Enemy>();
	}
	
	public void Update() {
		timeL += Delta();
		if(timeL>cooldown) {
			ProjectW();
			timeL=0;
		}
		
		for (Enemy e : wave) {
			if (e.isAlive()) {
				e.Update();
				e.Project();
			}
		}
	}
	
	private void ProjectW() {
		
		wave.add(new Enemy(enemyType.getTex(),enemyType.getStart(),enemyType.getMap(),32,32,enemyType.getVel(),enemyType.getLp()));
		
		
		
	}
	
}
