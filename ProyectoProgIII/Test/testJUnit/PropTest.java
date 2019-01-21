package testJUnit;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ventanas.Login;

public class PropTest {
	
	String userAnterior="";

	
	

	@Before
	public void setUp() throws Exception {
		

		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		
		
		Properties prop = new Properties();
		
		Login miLogin = new Login();
		
		FileInputStream input;
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userAnterior = prop.getProperty("username");
		
		assertEquals(userAnterior, miLogin.getUs().getText());
		
		
		
		
		
		
	}

}
