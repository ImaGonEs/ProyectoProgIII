package Datos;

import java.sql.*;







public class PruebaSQLite {

	
		
		
	


	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection c = null;
	      Statement stmt = null;
	      
	      
//	      
//	      try { //--------TABLA TOWER--------------
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
//	      try { //--------TABLA tiene--------------
//	          Class.forName("org.sqlite.JDBC");
//	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//	          System.out.println("Opened database successfully");
//
//	          stmt = c.createStatement();
//	          String sql = "CREATE TABLE TIENE " +
//	                         "(ID_T VARCHAR(3)     NOT NULL REFERENCES TOWER(ID)," +
//	                         " NAME_P CHAR(10)   NOT NULL REFERENCES PLAYER(NAME_P), " +
//	                         "PRIMARY KEY(ID_T,NAME_P));"; 
//	          stmt.executeUpdate(sql);
//	          stmt.close();
//	          c.close();
//	       } catch ( Exception e ) {
//	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	          System.exit(0);
//	       }
//	       System.out.println("Table created successfully");
////	      
//	       try { //-----------DROP TAABLE---------------
//	      Class.forName("org.sqlite.JDBC");
//	      c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//	      c.setAutoCommit(false);
//	      System.out.println("Opened database successfully");
//
//	      stmt = c.createStatement();
//	      String sqlCommand = "DROP TABLE 'TIENE' ";
//
//	      System.out.println("output : " + stmt.executeUpdate(sqlCommand));
//
//	      stmt.close();
//	      c.commit();     // commit after execute sql command
//	                      //COMMIT TRANSACTION makes all data modifications performed since 
//	                      //the start of the transaction a permanent part of the database, 
//	      c.close();
//  } catch ( Exception e ) {
//	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	      System.exit(0);
//	   }
//
//	     
//	    System.out.println("Operation done successfully");
//	      
	 
	      
	      
	      
	      
	      
	      
//	      
//	      try { //------------TABLA PLAYERS-------------------
//          Class.forName("org.sqlite.JDBC");
//          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//          System.out.println("Opened database successfully");
//
//          stmt = c.createStatement();
//          String sql = "CREATE TABLE PLAYERS " +
//                         " (NAME_P    CHAR(10) PRIMARY KEY  NOT NULL, " + 
//                         " PASSWORD    CHAR(20)     NOT NULL, " + 
//                         " GEMS NUMBER(10000) DEFAULT 0, " + 
//                         " POS NUMBER(100))"; 
//          stmt.executeUpdate(sql);
//          stmt.close();
//          c.close();
//       } catch ( Exception e ) {
//          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          System.exit(0);
//       }
//       System.out.println("Table created successfully");
      
//     
//	      
//	      
//	      
	      
	      try {//------------------INSERT TOWERS-----------------
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
//	     
	      
//	      
	      try {//------------------INSERT TOWERS-----------------
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          String sql = "INSERT INTO TIENE " +
	                         "VALUES ('T01', 'OTROXD' );"; 
	          stmt.executeUpdate(sql);
	          stmt = c.createStatement();
	           sql = "INSERT INTO TIENE " +
	                         "VALUES ('T01', 'KIKEXD' );"; 
	          stmt.executeUpdate(sql);
	          stmt = c.createStatement();
	           sql = "INSERT INTO TIENE " +
	                         "VALUES ('T02', 'KIKEXD' );"; 
	          stmt.executeUpdate(sql);

	         


	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Records created successfully");
	     
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
//	      
	      try { //-----------------INSERT PLAYERS-----------------------------
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully");

          stmt = c.createStatement();
          String sql = "INSERT INTO PLAYERS (NAME_P,PASSWORD,GEMS,POS) " +
                         "VALUES ('KIKEXD', 'EY123', 999, 1 );"; 
          stmt.executeUpdate(sql);
          sql = "INSERT INTO PLAYERS (NAME_P,PASSWORD,GEMS,POS) " +
        		  "VALUES ('OTROXD', 'LAPASS', 1, 2 );"; 
          stmt.executeUpdate(sql);


          stmt.close();
          c.commit();
          c.close();
       } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
       }
       System.out.println("Records created successfully");
//      
//	      
//	      
//     
	      
	      
//	      
//	      try { //-------------PRINT TOWERS---------------------
//	          Class.forName("org.sqlite.JDBC");
//	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//	          c.setAutoCommit(false);
//	          System.out.println("Opened database successfully");
//
//	          stmt = c.createStatement();
//	          ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS;" );
//	          
//	          while ( rs.next() ) {
//	             String id = rs.getString("ID");
//	             String  name = rs.getString("NAME");
//	             int damage  = rs.getInt("DAMAGE");
//	             int  range = rs.getInt("RANGE");
//	             float atkspeed = rs.getFloat("ATKSPEED");
//	             
//	             System.out.println( "ID = " + id );
//	             System.out.println( "NAME = " + name );
//	             System.out.println( "DAMAGE = " + damage );
//	             System.out.println( "RANGE = " + range );
//	             System.out.println( "AS = " + atkspeed );
//	             System.out.println();
//	          }
//	          rs.close();
//	          stmt.close();
//	          c.close();
//	       } catch ( Exception e ) {
//	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	          System.exit(0);
//	       }
//	       System.out.println("Operation done successfully");
//	       
//	       
//	       try {//-------------------PRINT PLAYERS---------------------
//		          Class.forName("org.sqlite.JDBC");
//		          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//		          c.setAutoCommit(false);
//		          System.out.println("Opened database successfully");
//
//		          stmt = c.createStatement();
//		          ResultSet rs = stmt.executeQuery( "SELECT * FROM PLAYERS;" );
//		          
//		          while ( rs.next() ) {
//		             
//		             String  name = rs.getString("NAME_P");
//		             String pass  = rs.getString("PASSWORD");
//		             int  gems = rs.getInt("GEMS");
//		             int pos = rs.getInt("POS");
//		             
//		       
//		             System.out.println( "NAME_P = " + name );
//		             System.out.println( "PASSWORD = " + pass );
//		             System.out.println( "GEMS = " + gems );
//		             System.out.println( "POS = " + pos );
//		             System.out.println();
//		          }
//		          rs.close();
//		          stmt.close();
//		          c.close();
//		       } catch ( Exception e ) {
//		          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//		          System.exit(0);
//		       }
//		       System.out.println("Operation done successfully");
//		      
//
//	 	       try {//-------------------PRINT TIENE---------------------
//	 		          Class.forName("org.sqlite.JDBC");
//	 		          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//	 		          c.setAutoCommit(false);
//	 		          System.out.println("Opened database successfully");
//	 
//	 		          stmt = c.createStatement();
//	 		          ResultSet rs = stmt.executeQuery( "SELECT * FROM TIENE;" );
//	 		          
//	 		          while ( rs.next() ) {
//	 		             
//	 		             String  name = rs.getString("NAME_P");
//	 		             String t  = rs.getString("ID_T");
//	 		             
//	 		             
//	 		       
//	 		             System.out.println( "NAME_P = " + name );
//	 		             System.out.println( "TORRE = " + t );
//	 		             
//	 		             System.out.println();
//	 		          }
//	 		          rs.close();
//	 		          stmt.close();
//	 		          c.close();
//	 		       } catch ( Exception e ) {
//	 		          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	 		          System.exit(0);
//	 		       }
//	 		       System.out.println("Operation done successfully");
	     
//	 		      try { //-----------------INSERT PLAYERS-----------------------------
//	 		          Class.forName("org.sqlite.JDBC");
//	 		          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//	 		          c.setAutoCommit(false);
//	 		          System.out.println("Opened database successfully");
//	 		
//	 		          stmt = c.createStatement();
//	 		          String sql = "DROP TABLE TIENE;"; 
//	 		          stmt.executeUpdate(sql);
//	 		          
//	 		
//	 		
//	 		          stmt.close();
//	 		          c.commit();
//	 		          c.close();
//	 		       } catch ( Exception e ) {
//	 		          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	 		          System.exit(0);
//	 		       }
//	 		       System.out.println("Records created successfully");
	 		      
	 		       
	
}
}

	
		

	      
	      
	     
	   


