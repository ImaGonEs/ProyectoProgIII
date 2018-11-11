package ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class VClas extends JFrame {

    JButton bAtras;
    JTable tabla;

    public VClas() {
    	
    	 Connection c = null;
	     Statement stmt = null;
	     
	     ArrayList<String> names = new ArrayList<String>();
	     ArrayList<Integer> scores = new ArrayList<Integer>();
	     int iee = 0;
    	  try {//-------------------PRINT PLAYERS---------------------
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT NAME_P FROM PLAYERS;" );
	          
	          while ( rs.next() ) {
	             
	             String  name = rs.getString("NAME_P");
	             names.add(name);
	             scores.add(iee);
	             iee++;
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
	      
    	
    	String[] nombres= new String[names.size()];
    	
    	for (int i = 0; i < names.size(); i++) {
			nombres[i]=names.get(i);
		}
    	
    	String[] puntos= new String[scores.size()];
    	
    	for (int i = 0; i < scores.size(); i++) {
			puntos[i]=scores.get(i).toString();
		}
    	
    	String[][] lista99= new String[names.size()][2];

    	for (int i = 0; i < names.size(); i++) {
    		for (int j = 0; j < lista99.length; j++) {
				
			}
	

    /*	for (int i = 0; i < players.size(); i++) {
    		ArrayList<String> array1 = new ArrayList();
				array1.add(names.get(i));
				array1.add((scores.get(i).toString()));
				array.add(array1);
		}*/
    
    	}
		 
         for (int i = 0; i < names.size(); i++) {
        	 
             	//System.out.println(names.get(i));
             	String[][] s= new String[][]{{names.get(i)},{scores.get(i).toString()}};
             	//System.out.println(Arrays.deepToString(s).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
               // model.addRow(s);
             
         }
        
       
         
        // for (int i = 0; i < array.size(); i++) {
 			//model.addRow(array.get(i));
 		//}
        
         String[] xd= new String[2];
		 
		 String column[]={"Nombre","Puntos"};
		   
	         
	    DefaultTableModel model = new DefaultTableModel (column,0);
	    
	  
	         
		for (int j = 0; j < names.size(); j++) {
			xd[0]=names.get(j);
			xd[1]=scores.get(j).toString();
			
			model.addRow(xd);
		}
         tabla =new JTable(model);
         Container cp= this.getContentPane();
         
         
         
         JScrollPane sp=new JScrollPane(tabla);
         tabla.setFillsViewportHeight(true);
         tabla.setRowHeight(40);
         
         JTableHeader header= tabla.getTableHeader();
         header.setBackground(Color.GRAY);
         header.setForeground(Color.BLACK);
         
         header.setFont(new Font("Tahome",Font.BOLD,30));
         
         
         tabla.setBackground(Color.DARK_GRAY);
         tabla.setFont(new Font("Serif", Font.BOLD, 20));
         tabla.setForeground(Color.WHITE);
         
         //sp.setBounds(0, 0, 1000, 600);
         
         cp.add(sp,BorderLayout.CENTER);
         
        
         
        
         this.setSize(1024, 768);
         this.setVisible(true);
         this.setLocationRelativeTo(null);
    }

    
public static void main(String[] args) {
	
		new VClas();
}


}