package weareSupports;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {
	
	private static final String HOST = "ec2-54-75-231-156.eu-west-1.compute.amazonaws.com:5432/dedk9rgba2je42";
	private static final String USERNAME = "bbjwauldhgoetw";
	private static final String PASSWORD = "16fffd7a43d6a6aa0d08be2230ad53489b5c9fe99189737373d22b14a5e5ca8f";
	
	private static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			System.out.println("Where is your PostheSQL JDBC Driver? " + "Include in your library path!");
			return null;
		}
		Connection conn = DriverManager.getConnection("jdbc:postgresql://"+ HOST + "?sslmode=require", USERNAME , PASSWORD);
		return conn;
		
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("Connection done!!");
		}else {
			System.out.println("Failed connection!");
		}
		Statement stmt = connection.createStatement();
//		try {
//			stmt.executeUpdate("CREATE TABLE TOWERS " +
//            "(ID VARCHAR(3) PRIMARY KEY     NOT NULL," +
//           " NAME           TEXT    NOT NULL, " + 
//           " DAMAGE            INT     NOT NULL, " + 
//           " RANGE        INT NOT NULL, " + 
//           " ATKSPEED         FLOAT NOT NULL)");
//		} catch (Exception e) {
//			System.out.println("La tala ya existe");
//		}
		
//		try {
//			stmt.executeUpdate("ALTER TABLE TIENE RENAME COLUMN ID_T TO ID;");
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM TIENE");
		while (rs.next()) {
			ArrayList<String> ids = new ArrayList<>();
			System.out.println("Read from DB: " + rs.getString("NAME_P"));
		}
		
	}
	
}
