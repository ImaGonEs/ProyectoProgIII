package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public enum TowerType {
	
	
	
	
	
	
	T01(QuickCast("IT"), 10, 1000, 3), 
	T02(QuickCast("TR"), 10, 1000, 3),
	CannonE(QuickCast("TC"), 10, 1000, 3);
	
	
	Texture tex;
	int damage, range;
	float attackSpeed;
	
	
	
	
	TowerType(Texture tex, int damage, int range, float attackSpeed) {
		this.tex = tex;
		this.damage = damage;
		this.range = range;
		this.attackSpeed = attackSpeed;
		
		
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
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS WHERE ID = "+a+";" );
		      
		      while ( rs.next() ) {
		         
		         String  id = rs.getString("id");
		         
		         String name = rs.getString("name");
		         
		         int dmg = rs.getInt("damage");
		         int range = rs.getInt("range");
		         float atkspd = rs.getFloat("atkspeed");
		        az = new Sust(QuickCast(name),dmg,range,atkspd);
		         
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
