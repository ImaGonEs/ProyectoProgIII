package Datos;

import org.newdawn.slick.opengl.Texture;
import static weareSupports.Creador.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public enum TowerType {
	
	

	
	
	T01("IT"), 
	T02("TR"),
	T03("TorreN1"),
	T04("TorreN2"),
	T05("TowerOtro"),
	T06("TowerOtro2"),
	T07("TowerOtro3");
	
	
	
	final String tex;
	int damage, range;
	float attackSpeed;
	
	
	
	
	
	public String getTex() {
		return tex;
	}

	TowerType(String name) {
		
		this.tex = getSust(name).getTex();		
		this.damage = getSust(name).getDamage();
		this.range =getSust(name).getRange();
		this.attackSpeed =getSust(name).getAttackSpeed();;
		
		
	}
	


	public static Sust getSust(String a) {
		
		Connection c = null;
		Statement stmt = null;
		Sust ret = null;
		 try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
		      c.setAutoCommit(false);
		      

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS WHERE NAME = '"+a+"' ;" );
		      
		      while ( rs.next() ) {
		         
		         String  id = rs.getString("id"); 
		         
		         String name = rs.getString("name");
		         System.out.println(name);
		         int dmg = rs.getInt("damage");
		         int range = rs.getInt("range");
		         float atkspd = rs.getFloat("atkspeed");
		        ret = new Sust(id,name,dmg,range,atkspd);
		         
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		return ret;
	}
	
	
	
}
