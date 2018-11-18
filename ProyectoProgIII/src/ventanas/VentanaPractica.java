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

import weareSupports.JLabelGraficoAjustado;




//Como esta parte no es muy útil para el proyecto, he metido algunos datos a mano

//La parte derecha muestra las torres disponibles de cada jugador, y es posible elegir que torre añadir con los radiobutotn
//caso del jugador OTROXD: solo tiene la torre T01. Al presionar save con T02 elegido se añade a la base de datos
//el boton delete elimina esa misma torre de la base de datos (para probar)
public class VentanaPractica extends JFrame{
	
	JButton b1, b2;
	JPanel p1, p2;
	static JList<String> lista;
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
		
		
		
		
		
		
		
		
		String[] s = new String[names.size()];
		for (int i = 0; i < s.length; i++) {
			s[i] = names.get(i);
		}
		
		
		Container cp = this.getContentPane();
		//cp.setLayout(new GridLayout(1, 2));
		p1 = new JPanel();
		p2 = new JPanel();
		p2.setLayout(new GridLayout());
		
		b1 = new JButton("SAVE");
		b2 = new JButton("DELETE");
		
		String[] data = {"one", "two", "three", "four"};
		lista = new JList<String>(s);
		JScrollPane  bar= new JScrollPane(lista);
		
		p1.add(bar);
		l = new JLabel("asdad");
		
	
		p2.add(b1);
		p2.add(b2);
		p2.add(t1);
		p2.add(t2);
		
		
		cp.add(lista,BorderLayout.WEST);
		cp.add(l, BorderLayout.EAST);
		cp.add(p2, BorderLayout.SOUTH);
		

		

		 
		 
		
		

		this.setSize(700, 450);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
		
		
		 try {
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
				while(true) {
				try {
						
					if (lista.getSelectedValue().equals("KIKEXD")) {
						ArrayList<String> as = new ArrayList<String>();
						for (int i = 0; i < mapa.get("KIKEXD").size(); i++) {
							as.add((mapa.get("KIKEXD").get(i)));
						}
	            		l.setText(as.toString());
	            	}else if (lista.getSelectedValue().equals("OTROXD")) {
						ArrayList<String> as = new ArrayList<String>();
						for (int i = 0; i < mapa.get("OTROXD").size(); i++) {
							as.add((mapa.get("OTROXD").get(i)));
						}
	            		l.setText(as.toString());
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
		
		
		// Runs outside of the Swing UI thread
		
//		b1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println(lista.getSelectedValue());
//				if (lista.getSelectedValue().equals("KIKEXD")) {
//            		l.setText((mapa.get("KIKEXD").get(0)));
//            	}else if (lista.getSelectedValue().equals("OTROXD")) {
//            		l.setText("vacio");
//            	}else {
//            		l.setText("eeeeeeeeeeeeeeeeeee");
//            	}
//				    
//			}
//		});
	    
//		Runnable update = new Runnable() {
//		    @Override
//		    public void run() {
//		    	if (lista.getSelectedValue().equals("KIKEXD")) {
//            		l.setText((mapa.get("KIKEXD").get(0)));
//            	}else if (lista.getSelectedValue().equals("OTROXD")) {
//            		l.setText("vacio");
//            	}else {
//            		l.setText("eeeeeeeeeeeeeeeeeee");
//            	}
//		    	try {
//					Thread.sleep(300);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		    }
//		};
//		if (SwingUtilities.isEventDispatchThread()) {
//		    update.run();
//		} else {
//		    SwingUtilities.invokeLater(update);
//		}
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (t2.isSelected()&&lista.getSelectedValue().equals("OTROXD")) {
					System.out.println("añadiendo t2 al jugador OTROXD");
					mapa.get("OTROXD").add("T02");
					 try {
						 Connection c = null;
					     Statement stmt = null;
					     
				          Class.forName("org.sqlite.JDBC");
				          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
				          c.setAutoCommit(false);
				          System.out.println("Opened database successfully");
			
				          stmt = c.createStatement();
				          String sql = "INSERT INTO TIENE  " +
				                         "VALUES ('T02', 'OTROXD' );"; 
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
			}
		});
		
		
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					mapa.get("OTROXD").remove(1);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				try {
					Connection c = null;
				     Statement stmt = null;
				     
			          Class.forName("org.sqlite.JDBC");
			          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
			          c.setAutoCommit(false);
			          System.out.println("Opened database successfully");
		
			          stmt = c.createStatement();
			          String sql = "DELETE FROM TIENE  " +
			                         "WHERE ID_T = 'T02' AND NAME_P='OTROXD'"; 
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
		});
		
		
		
		
		
		
	
	}
		
		
		

		
		
		
	
	
	public static void main(String[] args) {
	new VentanaPractica();	
	}

}
