package juanito;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.Boot;
import Datos.Tower;
import Datos.TowerThunder;
import Datos.TowerType;

public class TowersTest {
	
	ArrayList<Tower> towers = new ArrayList<Tower>();
	
	//Level level = new Level(1,"Mapa1"); //grid, wave, enemies
	
	
	
	

	@Before
	public void setUp() throws Exception {
		
		
		
		new Boot(4, "Mapa1");
	
		
		 towers.add(new TowerThunder(TowerType.T01, null,null));
		 //towers.add(new TowerIce(TowerType.T02, level.getMap().getCell(1, 1),level.getWave().getWave().getEnemies()));
//		 towers.add(new TowerFire(TowerType.T03, level.getMap().getCell(2, 2),level.getWave().getWave().getEnemies()));
//		 towers.add(new TowerPoison(TowerType.T04, level.getMap().getCell(3, 3),level.getWave().getWave().getEnemies()));
//		 towers.add(new TowerPurpl(TowerType.T05, level.getMap().getCell(4, 4),level.getWave().getWave().getEnemies()));
//		 towers.add(new TowerRed(TowerType.T06, level.getMap().getCell(5, 5),level.getWave().getWave().getEnemies()));
//		 towers.add(new TowerGreen(TowerType.T07, level.getMap().getCell(6, 6),level.getWave().getWave().getEnemies()));
		 
		 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		assertTrue(towers.get(0).getAttackSpeed()>0);
		
	}

}
