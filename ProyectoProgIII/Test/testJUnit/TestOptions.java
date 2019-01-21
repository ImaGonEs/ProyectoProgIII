package testJUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ventanas.Options;

public class TestOptions {

	
	Options o;
	@Before
	public void setUp() throws Exception {
		
		o = new Options();
		o.getbOk().doClick();
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void test() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(o.getSong().isFXPlaying());
		assertEquals(o.getSong().getFXVolume(),1.8,0.0);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.getbMute().doClick();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(o.getSong().isFXPlaying());
	
		
		
	}

}
