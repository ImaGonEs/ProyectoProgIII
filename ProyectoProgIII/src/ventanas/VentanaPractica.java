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

public class VentanaPractica extends JFrame{
	
	JButton b1, b2;
	JPanel p1, p2;
	static JList<String> lista;
	static  JLabel l;
	JTextArea ta;
	static Map<String, ArrayList<String>> mapa ;
	
	public VentanaPractica() {
		
		
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
		p2.setLayout(new BorderLayout());
		
		b1 = new JButton("SAVE");
		b2 = new JButton("DELETE");
		
		String[] data = {"one", "two", "three", "four"};
		lista = new JList<String>(s);
		JScrollPane  bar= new JScrollPane(lista);
		
		p1.add(bar);
		l = new JLabel("asdad");
		
		p2.add(l, BorderLayout.CENTER);
		p2.add(b1, BorderLayout.SOUTH);
		p2.add(b2, BorderLayout.SOUTH);
		
		
		cp.add(lista,BorderLayout.WEST);
		cp.add(l, BorderLayout.EAST);
		cp.add(b1, BorderLayout.SOUTH);

		

		 
		 
		
		

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
		
//		Thread t  = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				while(true) {
//				
//					if (lista.getSelectedValue()=="KIKEXD") {
//						ta.append(mapa.get("KIKEXD").get(0));
//					
//				}
//					try {
//						Thread.sleep(300);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//			}
//			}
//		
//		});
//		ta.append("asdasdsad");
//		t.start();
		
		
		// Runs outside of the Swing UI thread
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(lista.getSelectedValue());
				if (lista.getSelectedValue()=="KIKEXD") {
            		l.setText((mapa.get("KIKEXD").get(0)));
            	}else if (lista.getSelectedValue()=="OTROXD") {
            		l.setText("vacio");
            	}else {
            		l.setText("eeeeeeeeeeeeeeeeeee");
            	}
				    
			}
		});
	    
		Runnable update = new Runnable() {
		    @Override
		    public void run() {
		    	if (lista.getSelectedValue()=="KIKEXD") {
            		l.setText((mapa.get("KIKEXD").get(0)));
            	}else if (lista.getSelectedValue()=="OTROXD") {
            		l.setText("vacio");
            	}else {
            		l.setText("eeeeeeeeeeeeeeeeeee");
            	}
		    	try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		};
		if (SwingUtilities.isEventDispatchThread()) {
		    update.run();
		} else {
		    SwingUtilities.invokeLater(update);
		}
	
	}
		
		
		

		
		
		
	
	
	public static void main(String[] args) {
	new VentanaPractica();	
	}

}
