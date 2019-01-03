package juanito;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ventanas.Summon;
import weareSupports.BD;

public class MenuTest {

	
	static Summon s;
	static int iGems,expectedFGems,iN,eN;
	static ArrayList<String> iT,expT,iTowersBD,expTowersBD;
	static String lastUs;
	
	
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		s = new Summon();
		iGems = Integer.parseInt(s.getnGems().getText());
		expectedFGems = iGems-100;
		 
		iT= s.getOwnedTNames();
		iN = iT.size();
		 
		
		 
		 
		lastUs = s.getLastUs();
		iTowersBD = BD.arrayTiene(lastUs);
			
		
		s.getButton().doClick();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGems () { //las gemas se restar correctamente
		
		
		if (s.getMissingTNames().size()>0) {
		
		//s.getButton().doClick();
		
		
		assertEquals(expectedFGems, Integer.parseInt(s.getnGems().getText()));
		}
		
	}
	
	@Test
	public void testTowers() { //las torres se insertan correctamente
		
		
		
		
		//s.getButton().doClick();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		expT = s.getOwnedTNames();
		eN = expT.size();
		
		

		if (iT.size()<7) {
			
			assertEquals(iN+1,eN);
		
			
		}else {
			assertEquals(iT,expT);
		}
	
	}
	
	@Test
	public void testBD() {
		
		expTowersBD = BD.arrayTiene(lastUs);
		
		if(iTowersBD.size() < 7)
		assertEquals(iTowersBD.size()+1,expTowersBD.size());
		else 
		assertEquals(iTowersBD.size(),expTowersBD.size());
		
	}
	

}
