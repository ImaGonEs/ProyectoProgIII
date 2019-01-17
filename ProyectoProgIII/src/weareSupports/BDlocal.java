package weareSupports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BDlocal {

	static Connection c = null;
    static Statement stmt = null;


    public void insert (String tName, String code) {

    	 try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          String sql = "INSERT INTO "+tName+
	                         " VALUES "+ code+";"; 
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
    
    public HashMap<String,String> getPlayerMap() {
    	
    HashMap<String,String> mapa = new HashMap<String, String>();
    
    try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT NAME_P,PASSWORD FROM PLAYERS;" );
        
        while ( rs.next() ) {
      	  
          
           String name = rs.getString("NAME_P");
           String pass = rs.getString("PASSWORD");
           
           
           mapa.put(name, pass);
           
           
           
          
          // System.out.println(pass);
          // System.out.println(name);
         
          
//          if (name.equals(user) && pass.equals(passw)) {
//          	
//          	JOptionPane.showMessageDialog(null, "LOGIN");
//          	break;
//          }else {
//          	JOptionPane.showMessageDialog(null, "wrong password");
//          	break;
//          }
//          
          
         
        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception exc ) {
        System.err.println( exc.getClass().getName() + ": " + exc.getMessage() );
        System.exit(0);
     }
     System.out.println("Operation done successfully");
    	
    return mapa;	
    	
    }

    public void create (String tName, String code) {


	      try { 
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
    
    public ArrayList<String> getOwnedTowerIDs(String player){
    	
    	ArrayList<String> ids = new ArrayList<>();
    	
    	try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT ID_T FROM TIENE WHERE NAME_P="+"\""+player+"\""+";");
	          
	          while ( rs.next() ) {
	             
	             
	          String torre = rs.getString("ID_T");
	             
	          ids.add(torre);
	            
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
			return ids;
			
    }
    
    public ArrayList<String> getTowerIDs(){
    	
    	ArrayList<String> ids = new ArrayList<>();
    	try { 
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS;" );
	          
	          while ( rs.next() ) {
	             String id = rs.getString("ID");
	             
	             
	             ids.add(id);
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
	       return ids;
    	
    }

   public String getTName(String t){
	   
	   String torre = "";
	   try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          
	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT NAME FROM TOWERS WHERE ID ="+"\""+t+"\""+"; ");
	          
	          while ( rs.next() ) {
	             
	             
	           torre = rs.getString("NAME");
	             
	         
	            
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	   return torre;
	   
   }
    public String getID(String tex) {
    	String ide = "";
    	try { 
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT ID FROM TOWERS WHERE NAME='"+tex+"';" );
	          
	          while ( rs.next() ) {
	             String id = rs.getString("ID");
	            ide = id;
	             
	           
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
	       return ide;
    }
    public String getString(String cName, String tName) {


    	String s = "";
	      try { 
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
    
    public int getGems(String player) {


    	int i = 0;
	      try { 
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT GEMS FROM PLAYERS WHERE NAME_P = '"+player+"';" );

        while ( rs.next() ) {
           i = rs.getInt("GEMS");

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
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
    
    public void updateGems(String player, String cant) {

    	try { 
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          String sql = "UPDATE PLAYERS SET GEMS = GEMS +"+cant+" WHERE NAME_P = '"+player+"';"; 
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
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
		          Class.forName("org.sqlite.JDBC");
		          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
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
	BDlocal b= new BDlocal();
	System.out.println(b.getGems("KIKEXD"));
}



}
