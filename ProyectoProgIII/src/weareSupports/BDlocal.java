package weareSupports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Datos.Sust;

public class BDlocal {

	static Connection c = null;
    static Statement stmt = null;

    private static Logger logger = Logger.getLogger( "LoggerBD" );




	static {
    try {
        logger.setLevel( Level.FINEST);
        logger.addHandler( new FileHandler( "LoggerBD.xml") );
    } catch (Exception e) {}
	}
    public static void startBD() {
    	 try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	         logger.log(Level.FINER,"Opened database successfully");
    	 }catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void insert (String tName, String code) {

    	 try {
	         startBD();

	          stmt = c.createStatement();
	          String sql = "INSERT INTO "+tName+
	                         " VALUES "+ code+";"; 
	          stmt.executeUpdate(sql);


	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception e ) {
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Records created successfully");

    }
    
    public static TreeMap<String, Integer> getTree() {
    TreeMap<String, Integer> mapa = new TreeMap<String, Integer>();
    
    try {
    	 startBD();

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT NAME_P,GEMS FROM PLAYERS;" );
        
        while ( rs.next() ) {
           
           String  name = rs.getString("NAME_P");
           String  gems = rs.getString("GEMS");
           mapa.put(name, Integer.parseInt(gems));
          
        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
    	 logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
    logger.log(Level.FINER, "Operation successful");
    return mapa;
}
    public static void empty(String player) {
    	
    	try {
    		 startBD();

	          stmt = c.createStatement();
	          String sql = "DELETE FROM TIENE WHERE NAME_P = '"+player+"';"; 
	          stmt.executeUpdate(sql);


	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception e ) {
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Tabla tiene vaciada para " +player);
	       
    	
    	
    }
    
    public void delete() {
    	
    	try {
    		 startBD();
	          
    		 stmt = c.createStatement();
	          String sql = "CREATE TABLE PLAYERS ( NAME_P VARCHAR(30) NOT NULL PRIMARY KEY,PASSWORD VARCHAR(30) NOT NULL, GEMS NUMBER  DEFAULT 0 );"; 
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
    	 startBD();
    	 
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT NAME_P,PASSWORD FROM PLAYERS;" );
        
        while ( rs.next() ) {
      	  
          
           String name = rs.getString("NAME_P");
           String pass = rs.getString("PASSWORD");        
           
           mapa.put(name, pass);
              
        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception exc ) {
        System.err.println( exc.getClass().getName() + ": " + exc.getMessage() );
        System.exit(0);
     }
     logger.log(Level.FINER, "Operation done successfully");
    	
    return mapa;	
    	
    }

    public void create (String tName, String code) {


	      try { 
	    	  startBD();
        stmt = c.createStatement();
        String sql = "CREATE TABLE "+tName +
                       "("+code+");"; 
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     System.out.println("Table created successfully");


    }
    
   

    public ArrayList<String> getOwnedTowerIDs(String player){
    	
    	ArrayList<String> ids = new ArrayList<>();
    	
    	try {
    		 startBD();
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
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Operation done successfully");
			return ids;
			
    }
    
    public ArrayList<String> getTowerIDs(){
    	
    	ArrayList<String> ids = new ArrayList<>();
    	try { 
    		 startBD();

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
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Operation done successfully");
	       return ids;
    	
    }

   public String getTName(String t){
	   
	   String torre = "";
	   try {
		   startBD();
	          
	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT NAME FROM TOWERS WHERE ID ="+"\""+t+"\""+"; ");
	          
	          while ( rs.next() ) {
	             
	             
	           torre = rs.getString("NAME");
	             
	         
	            
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	   return torre;
	   
   }
    public String getID(String tex) {
    	String ide = "";
    	try { 
    		 startBD();

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
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Operation done successfully");
	       return ide;
    }
    public String getString(String cName, String tName) {


    	String s = "";
	      try { 
	    	  startBD();

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT "+cName+" FROM "+tName+";" );

        while ( rs.next() ) {
           s = rs.getString(cName);



        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     logger.log(Level.FINER, "Operation done successfully");


    return s;
    }

    public int getInt(String cName, String tName) {


    	int i = 0;
	      try { 
	    	  startBD();

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT "+cName+" FROM "+tName+";" );

        while ( rs.next() ) {
           i = rs.getInt(cName);

        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     logger.log(Level.FINER, "Operation done successfully");


    return i;
    }
    
    public int getGems(String player) {


    	int i = 0;
	      try { 
	    	  startBD();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT GEMS FROM PLAYERS WHERE NAME_P = '"+player+"';" );

        while ( rs.next() ) {
           i = rs.getInt("GEMS");

        }
        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     logger.log(Level.FINER, "Operation done successfully");


    return i;
    }

    public void updatePlayers(String code) {

    	try { 
    		 startBD();

	          stmt = c.createStatement();
	          String sql = "UPDATE TOWERS "+code+";"; 
	          stmt.executeUpdate(sql);



	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception e ) {
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Records created successfully");

    }
    
    public void updateGems(String player, String cant) {

    	try { 
    		 startBD();

	          stmt = c.createStatement();
	          String sql = "UPDATE PLAYERS SET GEMS = GEMS "+cant+" WHERE NAME_P = '"+player+"';"; 
	          stmt.executeUpdate(sql);



	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception e ) {
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Records created successfully");

    }

    public  void printTowers() {

	      try { 
	    	  startBD();
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
        logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     logger.log(Level.FINER, "Operation done successfully");
    }

    public void printTiene() {

    	try {//-------------------PRINT TIENE---------------------
    		 startBD();
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
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Operation done successfully");
    }
   public void printPlayers() {

	   try {//-------------------PRINT PLAYERS---------------------
		   startBD();
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
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Operation done successfully");

   }

   public static ArrayList<String> arrayTiene(String player) {

	ArrayList<String> towers =  new ArrayList<String>();

	    	try {
	    		 startBD();
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
		          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
		          System.exit(0);
		       }
		       logger.log(Level.FINER, "Operation done successfully");
		       return towers;


   }
   
   
   public Sust createSust(String s) {
	   
	   Sust az = null;
	   try {
		   startBD();

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS WHERE ID='"+s+"';" );
       
        while ( rs.next() ) {

           String  id = rs.getString("id"); 

          String name = rs.getString("name");

           int dmg = rs.getInt("damage");
           int range = rs.getInt("range");
           float atkspd = rs.getFloat("atkspeed");
          az = new Sust(id,name,dmg,range,atkspd);

        }

        rs.close();
        stmt.close();
        c.close();
     } catch ( Exception e ) {
        logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     logger.log(Level.FINER, "Operation done successfully");
     return az;

     
     
     
     
     }
   
   public static void update12() {
	   


   	try { 
   		 startBD();

	          stmt = c.createStatement();
	          String sql = "UPDATE TOWERS SET DAMAGE = 35,ATKSPEED = 2  WHERE ID = 'T07';"; 
	          stmt.executeUpdate(sql);



	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception e ) {
	          logger.log(Level.SEVERE,  e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       logger.log(Level.FINER, "Records created successfully");


     
   }

	
    	 
   
   

   public static void main(String[] args) {
	BDlocal b= new BDlocal();
	//System.out.println(b.getGems("KIKEXD"));
	update12();
	
	
	b.printTowers();
}



}
