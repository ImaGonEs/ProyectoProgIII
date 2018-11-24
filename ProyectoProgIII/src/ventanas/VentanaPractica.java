package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Datos.Tower;
import javafx.scene.layout.Border;
import weareSupports.JLabelGraficoAjustado;




//Cada jugador posee una cantidad de torres que luego puede usar en partida
//En la JList se muestran los jugadores en la BD y a la derecha las torres(codigos de torres) que tiene cada uno
//Como ahora mismo solo tenemos dos tipos de torres, podemos añadir o eliminar cualquiera de las dos
//de la BD para cada jugador
//Con lo radioButtons se elige la torre que se quiere añadir o eliminar





public class VentanaPractica extends JFrame{
	
	JButton b1, b2;
	JPanel p1, p2;
	static JList<String> lista, listaT;
	static  JLabel l;
	JTextArea ta;
	static Map<String, ArrayList<String>> mapa ;
	
	JRadioButton t1, t2;
	
	public VentanaPractica() {
		
		
		
		t1 = new JRadioButton("T01");
		t2 = new JRadioButton("T02");
		
		ButtonGroup gr = new ButtonGroup();
		
		gr.add(t1);
		gr.add(t2);
		
		ta = new JTextArea();
		
		
		Connection c = null;
	     Statement stmt = null;
	     
	     ArrayList<String> names = new ArrayList<String>();
	    
	     
	     
	     mapa = new HashMap<String,ArrayList<String>>();
	     
	     int iee = 0;
	     
   	  try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT NAME_P FROM PLAYERS;" );
	          
	          while ( rs.next() ) {
	             
	             String  name = rs.getString("NAME_P");
	             names.add(name);
	            
	             iee++;
	             mapa.put(name, new ArrayList<String>());
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
		
		
		listaT = new JList<String>();
		
		String[] aa = {"Adasd","sadadasd"};
		listaT = new JList<String>(aa);
		
		
		
		
		String[] s = new String[names.size()];  //TOARRAY
		for (int i = 0; i < s.length; i++) {
			s[i] = names.get(i);
		}
		
		
		Container cp = this.getContentPane();
		//cp.setLayout(new GridLayout(1, 2));
		
		
		b1 = new JButton("SAVE");
		b2 = new JButton("DELETE");
		
		
		lista = new JList<String>(s);
		JScrollPane  bar= new JScrollPane(lista);
		
		
	
		p1 = new JPanel();
		p1.setLayout(new GridLayout());
		p2 = new JPanel();
		p2.setLayout(new GridLayout());
		
		p1.add(bar);
		
		l = new JLabel("");
		p1.add(l);
		
		p2.add(b1);
		p2.add(b2);
		p2.add(t1);
		p2.add(t2);
		
		cp.add(p1, BorderLayout.CENTER);

		cp.add(p2, BorderLayout.SOUTH);
		

	

		this.setSize(700, 450);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		 try {//METER LAS TORRES AL MAP
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT ID_T, NAME_P FROM TIENE;" );
	          
	          while ( rs.next() ) {
	             
	             String  name = rs.getString("NAME_P");
	             String torre = rs.getString("ID_T");
	             
	         
	             mapa.get(name).add(torre);
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
		
		System.out.println(mapa);
		
		

		
		Thread t  = new Thread(new Runnable() { 
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				ArrayList<String> as = new ArrayList<String>();
				
				while(true) {
				
					
					
					try {
						
//					
//	            		
						
						
						if (names.contains(lista.getSelectedValue())) {
							for (String n : names) {
									if (lista.getSelectedValue().equals(n)) {
										as = new ArrayList<String>();
										
										for (int i = 0; i < mapa.get(n).size(); i++) {
											
											as.add((mapa.get(n).get(i)));
									}
							}
						
						
							
							
							}
		            		l.setText(as.toString());
		            		
	            		
	            		
//	            	
	            		
	            	}else {
	            		l.setText("VACIO");
	            	}
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			
			}
			}
		});
		
		t.start();
		
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> ns = new ArrayList<String>();
				
				ns = mapa.get(lista.getSelectedValue());
				
				
				if (t1.isSelected()&&!ns.contains(t1.getText())){
			
					addTower(t1.getText(), lista.getSelectedValue());
					
					mapa.get(lista.getSelectedValue()).add(t1.getText());
					try {
						Thread.sleep(60);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (t2.isSelected()&&!ns.contains(t2.getText())){
			
					addTower(t2.getText(), lista.getSelectedValue());
					mapa.get(lista.getSelectedValue()).add(t2.getText());
					try {
						Thread.sleep(60);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				}
			}
		});
		
		
		
		
		
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				ArrayList<String> ns = new ArrayList<String>();
				
				ns = mapa.get(lista.getSelectedValue());
				
				
				if (t1.isSelected()&&ns.contains(t1.getText())){
			
					deleteTower(t1.getText(), lista.getSelectedValue());
					
					mapa.get(lista.getSelectedValue()).remove(t1.getText());
					try {
						Thread.sleep(60);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (t2.isSelected()&&ns.contains(t2.getText())){
			
					deleteTower(t2.getText(), lista.getSelectedValue());
					mapa.get(lista.getSelectedValue()).remove(t2.getText());
					try {
						Thread.sleep(60);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		

	}
		
		
		

	public void addTower(String t, String p) {
		
		try {
			Connection c = null;
		     Statement stmt = null;
		     
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          String sql = "INSERT INTO TIENE  " +
                      "VALUES ('"+t+"', '"+p+"' );"; 
	          stmt.executeUpdate(sql);

	  
	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception ex ) {
	          System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Records created successfully");
	}
	
	public void deleteTower(String t, String p) {
		
		try {
			Connection c = null;
		     Statement stmt = null;
		     
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          String sql = "DELETE FROM TIENE  " +
	        		  "WHERE ID_T = '"+t+"' AND NAME_P='"+p+"'";  
	          stmt.executeUpdate(sql);

	  
	          stmt.close();
	          c.commit();
	          c.close();
	       } catch ( Exception ex ) {
	          System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Records created successfully");
	}
		
		
	
	
	public static void main(String[] args) {
	new VentanaPractica();	
	}

}
