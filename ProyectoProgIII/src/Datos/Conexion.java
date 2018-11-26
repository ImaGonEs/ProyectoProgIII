package Datos;

import java.awt.HeadlessException;
import java.sql.*;

public class Conexion extends javax.swing.JFrame {
	
	public Conexion() {
		this.setLocationRelativeTo(null);
				
	}
	
	
	public static void main(String[] args) {
		
		try {
			String url = "jbdc:mysql://sql7.freesqldatabase.com/sql7267016";
			String user = "sql7267016";
			String password = "g4xXgfljeE";	
			
			Connection cn = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PLAYERS");
			
			pst.setString(1, "KIKEXD");
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("NAME_P"));
				System.out.println(rs.getString("PASSWORD"));
				System.out.println(rs.getString("GEMS"));
				System.out.println(rs.getString("POS"));
			}else {
				System.out.println("REGISTRO NO ENCONTRADO");
			}
			
		} catch (HeadlessException | SQLException e) {
			
			System.out.println("Error: " + e);
			
		}
		
	}

}
