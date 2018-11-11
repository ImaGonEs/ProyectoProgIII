package Datos;

import java.sql.*;







public class PruebaSQLite {

	
		
		
	


	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection c = null;
	      Statement stmt = null;
	      
	      
	      
//	      try {
//	          Class.forName("org.sqlite.JDBC");
//	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//	          System.out.println("Opened database successfully");
//
//	          stmt = c.createStatement();
//	          String sql = "CREATE TABLE TOWERS " +
//	                         "(ID VARCHAR(3) PRIMARY KEY     NOT NULL," +
//	                         " NAME           TEXT    NOT NULL, " + 
//	                         " DAMAGE            INT     NOT NULL, " + 
//	                         " RANGE        INT NOT NULL, " + 
//	                         " ATKSPEED         FLOAT NOT NULL)"; 
//	          stmt.executeUpdate(sql);
//	          stmt.close();
//	          c.close();
//	       } catch ( Exception e ) {
//	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	          System.exit(0);
//	       }
//	       System.out.println("Table created successfully");
//	      
//	      
	      
	      
	      
	      
	      try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          String sql = "INSERT INTO TOWERS (ID,NAME,DAMAGE,RANGE,ATKSPEED) " +
	                         "VALUES ('T01', 'IT', 10, 1000, 3 );"; 
	          stmt.executeUpdate(sql);

	          sql = "INSERT INTO TOWERS (ID,NAME,DAMAGE,RANGE,ATKSPEED) " +
	                   "VALUES ('T02', 'TR', 10, 1000, 3 );"; 
	          stmt.executeUpdate(sql);


	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Records created successfully");
	      
	      
	      
	      
	      
	      
	     
	   }

}
