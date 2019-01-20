package juanito;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ventanas.Login;
import ventanas.Summon;
import weareSupports.BD;
import weareSupports.BDlocal;

public class MenuTest {

	
	static Summon s;
	static int iGems,expectedFGems,iN,eN;
	static ArrayList<String> iT,expT,iTowersBD,expTowersBD;
	static String lastUs;
	static BDlocal bd = new BDlocal();
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		Login.saveProps("Test", "123");
		
		s = new Summon();
		
		
		
		iGems = Integer.parseInt(s.getnGems().getText());
		if (iGems>100)
		expectedFGems = iGems-100;
		else
		expectedFGems = 0;	
		 
		iT= s.getOwnedTNames(); //torres en propiedad antes del click
		iN = iT.size();
		  
		lastUs = "Test";
		
			
		s.getButton().doClick();
		
		iTowersBD = BDlocal.arrayTiene(lastUs); //torres en propiedad después del click (los dos métodos hacen lo mismo,pero son accedidos de distinta manera)
	}

	@AfterClass
	public static void tearDown() throws Exception {
		
		BDlocal.empty("Test");
		bd.updateGems("Test", "+100");
		
	}

	@Test
	public void testGems () { //las gemas se restar correctamente
		
		
		if (s.getMissingTNames().size()>0) {
		
		
		
		assertEquals(expectedFGems, Integer.parseInt(s.getnGems().getText()));
		}
		
	}
	
	@Test
	public void testTowers() { //las torres se insertan correctamente
				
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		expT = s.getOwnedTNames();
		eN = expT.size();
		
		

		if (iT.size()<7 && iGems>100) {
			
			assertEquals(iN+1,eN);
		
			
		}else {
			assertEquals(iT,expT);
		}
	}
	
	@Test
	public void testBD() { //test de la parte de BD
		
		expTowersBD = BDlocal.arrayTiene(lastUs);
		
		
		if(iTowersBD.size() < 7 && iGems>100)
		assertEquals(iTowersBD.size()+1,expTowersBD.size());
		else 
		assertEquals(iTowersBD.size(),expTowersBD.size());
		
	}
	

}
