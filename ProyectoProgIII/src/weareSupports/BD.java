package weareSupports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BD {
	
	private static final String HOST = "ec2-54-75-231-156.eu-west-1.compute.amazonaws.com:5432/dedk9rgba2je42";
	private static final String USERNAME = "bbjwauldhgoetw";
	private static final String PASSWORD = "16fffd7a43d6a6aa0d08be2230ad53489b5c9fe99189737373d22b14a5e5ca8f";
	
	static Connection c = null;
    static Statement stmt = null;
    
    public void insert (String tName, String code) {
    	
    	 try {
	          Class.forName("org.postgresql.Driver");
	          c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          String sql = "INSERT INTO"+tName+
	                         "VALUES"+ code+";"; 
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
    
    public void create (String tName, String code) {
    	
    	
	      try { 
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql = "CREATE TABLE "+tName +
                       "("+code+");"; 
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     System.out.println("Table created successfully");

    	
    }
    
    public String getString(String cName, String tName) {
    	
    	 
    	String s = "";
	      try { 
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT "+cName+" FROM "+tName+";" );
        
        while ( rs.next() ) {
           s = rs.getString(cName); 
        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     System.out.println("Operation done successfully");
     
     
    return s;
    }
    
    public int getInt(String cName, String tName) {
    	
   	 
    	int i = 0;
	      try { 
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT "+cName+" FROM "+tName+";" );
        
        while ( rs.next() ) {
           i = rs.getInt(cName);

        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     System.out.println("Operation done successfully");
     
     
    return i;
    }
    
    public void updatePlayers(String code) {
    	
    	try { 
	          Class.forName("org.postgresql.Driver");
	          c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");
	
	          stmt = c.createStatement();
	          String sql = "UPDATE TOWERS "+code+";"; 
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
    
    public  void printTowers() {
    	
	      try { 
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS;" );
        
        while ( rs.next() ) {
           String id = rs.getString("ID");
           String  name = rs.getString("NAME");
           int damage  = rs.getInt("DAMAGE");
           int  range = rs.getInt("RANGE");
           float atkspeed = rs.getFloat("ATKSPEED");
           
           System.out.println( "ID = " + id );
           System.out.println( "NAME = " + name );
           System.out.println( "DAMAGE = " + damage );
           System.out.println( "RANGE = " + range );
           System.out.println( "AS = " + atkspeed );
           System.out.println();
        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     System.out.println("Operation done successfully");
    }
    
    public void printTiene() {
    	
    	try {//-------------------PRINT TIENE---------------------
	          Class.forName("org.postgresql.Driver");
	          c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT * FROM TIENE;" );
	          
	          while ( rs.next() ) {
	             
	             String  name = rs.getString("NAME_P");
	             String t  = rs.getString("ID_T");
	             
	             
	       
	             System.out.println( "NAME_P = " + name );
	             System.out.println( "TORRE = " + t );
	             
	             System.out.println();
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
    }
   public void printPlayers() {
	   
	   try {//-------------------PRINT PLAYERS---------------------
	          Class.forName("org.postgresql.Driver");
	          c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT * FROM PLAYERS;" );
	          
	          while ( rs.next() ) {
	             
	             String  name = rs.getString("NAME_P");
	             String pass  = rs.getString("PASSWORD");
	             int  gems = rs.getInt("GEMS");
	             int pos = rs.getInt("POS");
	             
	       
	             System.out.println( "NAME_P = " + name );
	             System.out.println( "PASSWORD = " + pass );
	             System.out.println( "GEMS = " + gems );
	             System.out.println( "POS = " + pos );
	             System.out.println();
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
	   
   }
   
   public static ArrayList<String> arrayTiene(String player) {
	   
	ArrayList<String> towers =  new ArrayList<String>();
	    	
	    	try {
		          Class.forName("org.postgresql.Driver");
		          c = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
		          c.setAutoCommit(false);
		          System.out.println("Opened database successfully");

		          stmt = c.createStatement();
		          ResultSet rs = stmt.executeQuery( "SELECT ID_T FROM TIENE WHERE NAME_P = '"+player+"';" );
		          
		          while ( rs.next() ) {
		             
		             
		             String t  = rs.getString("ID_T");
		             towers.add(t);
		             
		       
		             
		          }
		          rs.close();
		          stmt.close();
		          c.close();
		       } catch ( Exception e ) {
		          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		          System.exit(0);
		       }
		       System.out.println("Operation done successfully");
		       return towers;
	   
	   
   }
   public static void main(String[] args) {
	BD b= new BD();
	b.arrayTiene("KIKEXD");
}

}
