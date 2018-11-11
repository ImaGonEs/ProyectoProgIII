package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public enum TowerType {
	
	

	
	
	T01("IT"), //QuickCast("IT"), 10, 1000, 3
	T02("TR"); //QuickCast("TR"), 10, 1000, 3
	// CannonE(QuickCast("TC"), 10, 1000, 3); QuickCast("IT"), 10, 1000, 3
	
	
	Texture tex;
	int damage, range;
	float attackSpeed;
	
	
	
	
	TowerType(String name) {
		this.tex = QuickCast(hola(name).getTex());
		this.damage = hola(name).getDamage();
		this.range = hola(name).getRange();
		this.attackSpeed = hola(name).getAttackSpeed();;
		
		
	}

	public static Sust hola(String a) {
		
		Connection c = null;
		Statement stmt = null;
		Sust az = null;
		 try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS WHERE NAME = '"+a+"' ;" );
		      
		      while ( rs.next() ) {
		         
		         String  id = rs.getString("id");
		         
		         String name = rs.getString("name");
		         
		         int dmg = rs.getInt("damage");
		         int range = rs.getInt("range");
		         float atkspd = rs.getFloat("atkspeed");
		        az = new Sust(name,dmg,range,atkspd);
		         
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully");
		
		
		
		
		return az;
	}
	
	
	
}
