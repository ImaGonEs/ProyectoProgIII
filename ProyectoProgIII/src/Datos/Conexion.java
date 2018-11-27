package Datos;

import java.awt.HeadlessException;
import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion extends javax.swing.JFrame {
	
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String url = "jbdc:mysql://127.0.0.1:3306/ggtowerdefense";
	public String user = "ikiggtd";
	public String password = "elmegapush";
	Connection cn;
	Statement stm;
	
	public Conexion() {
		//this.setLocationRelativeTo(null);
		
		try {
			Connection myConnection = DriverManager.getConnection(url);
			Statement myStatement = myConnection.createStatement();
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM PLAYERS");
			while (myResult.next()){
				System.out.println(myResult.getString("NAME_P") + ", " + myResult.getString("PASSWORD"));
			}
//			Class.forName(driver);
//			DriverManager.getConnection(url, user, password);
//			JOptionPane.showMessageDialog(null, "Conexion establecida");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Conexion c = new Conexion();
		
//		try {
//			public String driver = "com.mysql.jdbc.Driver";
//			public String url = "jbdc:mysql://127.0.0.1/ggtowerdefense";
//			public String user = "root";
//			public String password = "";
//			
//			Connection cn = DriverManager.getConnection(url, user, password);
//			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PLAYERS");
//			
//			pst.setString(1, "KIKEXD");
//			
//			ResultSet rs = pst.executeQuery();
//			
//			if (rs.next()) {
//				System.out.println(rs.getString("NAME_P"));
//				System.out.println(rs.getString("PASSWORD"));
//				System.out.println(rs.getString("GEMS"));
//				System.out.println(rs.getString("POS"));
//			}else {
//				System.out.println("REGISTRO NO ENCONTRADO");
//			}
//			
//		} catch (HeadlessException | SQLException e) {
//			
//			System.out.println("Error: " + e);
//			
//		}
		
	}

}
