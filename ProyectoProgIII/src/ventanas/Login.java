package ventanas;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Datos.Boot;
import weareSupports.JLabelGraficoAjustado;
import weareSupports.StandardAudio;

public class Login extends JFrame{
	
	JLabelGraficoAjustado background,usuario,pass,btn;
	JPanel panel;
	JLabelGraficoAjustado title;
	StandardAudio clip;
	private int w = 1000,h=600;
	JTextField us;
	JTextField pa;
	
	
	
	
	
	
	public Login() {
		
		
		
//		int w = (int) screenSize.getWidth();
//		int h = (int) screenSize.getHeight();
		
		
		JFrame frame = this;
		
		w = 1000;
		h = 600;
		
		
		
		setSize(w,h);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container cp = this.getContentPane();
		panel = new JPanel();
		panel.setLayout(null);
		
		clip = new StandardAudio("src/res/Evil Mortys Theme.wav",true);
		
		background = new JLabelGraficoAjustado("forest", w, (int) ((int) h*1.5)); //1000,900
		
		title = new JLabelGraficoAjustado("Login", (int) 302, 146); 
		
		usuario = new JLabelGraficoAjustado("Usuario", (int) 100, 60); 
		 
		pass = new JLabelGraficoAjustado("Pass", (int) 100, 60); 
		
		btn = new JLabelGraficoAjustado("play1",(int) (w*0.2),h/6);
		
		
		
		us = new JTextField();
		us.setBounds(405, ((h/6)/2)+210, 150, 30);
		
		pa = new JTextField();
		pa.setBounds(405, ((h/6)/2)+300, 150, 30);
		
		cp.add(background);

	
		
	
		
		title.setLocation(325, (h/6)/2); //100,50   w/10, (w/6)/2
		usuario.setLocation(430,((h/6)/2)+150);
		pass.setLocation(430, ((h/6)/2)+245);
		btn.setLocation(380, ((h/6)/2)+350);
		
		
		background.add(title);
		background.add(usuario);
		background.add(us);
		background.add(pass);
		background.add(pa);
		background.add(btn);
		cp.validate();
		cp.repaint();
		
		Map<String, String> mapa = new HashMap<String, String>();
		
		ArrayList<String> s = new ArrayList<String>();
		
		Connection c = null;
	    Statement stmt = null;
	    
	 
	    try {//-------------------PRINT PLAYERS---------------------
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
	             
	             s.add(name);
	             
	            
	            // System.out.println(pass);
	            // System.out.println(name);
	           
	            
//	            if (name.equals(user) && pass.equals(passw)) {
//	            	
//	            	JOptionPane.showMessageDialog(null, "LOGIN");
//	            	break;
//	            }else {
//	            	JOptionPane.showMessageDialog(null, "wrong password");
//	            	break;
//	            }
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
	       
	       System.out.println(mapa);
		
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				btn.setImagen("src/res/play1.png");
				
				String user = us.getText();
				
				String passw = pa.getText();
				
				if (user.length()<3||passw.length()<3) {
					
					JOptionPane.showMessageDialog(null, "TRY AGAIN XD");
					
				}else if (!s.contains(user)) {
					
					
					
					
					Connection c = null;
					
					Statement stmt = null;
					
				    try { //-----------------INSERT PLAYER-----------------------------
			          Class.forName("org.sqlite.JDBC");
			          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
			          c.setAutoCommit(false);
			          System.out.println("Opened database successfully");
			
			          stmt = c.createStatement();
			          String sql = "INSERT INTO PLAYERS (NAME_P,PASSWORD,GEMS,POS) " +
			                         "VALUES ('"+user+"', '"+passw+"', 0, 1 );"; 
			          stmt.executeUpdate(sql);
			
			        
			          stmt.close();
			          c.commit();
			          c.close();
			       } catch ( Exception ex ) {
			          System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
			          System.exit(0);
			       }
			       System.out.println("Records created successfully");
						
						
						
			
					
					JOptionPane.showMessageDialog(null, "CUENTA CREADA");
					new LeMenu(false);
					
					frame.dispose();
					
					
				}else if (passw.equals(mapa.get(user))) {
					
					JOptionPane.showMessageDialog(null, "login con user: " +user+" pass: "+ passw);
					
					new LeMenu(false);
					frame.dispose();
	
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Wrong password");
				}
			   
			       
			       
			       
			       
			       
			       
		
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("rel");
				btn.setImagen("src/res/play2.png");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	
	
	}
	
	
	
	public static void main(String[] args) {
		new Login();
	}
}