package ventanas;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Datos.Boot;
import weareSupports.BDlocal;
import weareSupports.JLabelGraficoAjustado;
import weareSupports.StandardAudio;

public class Login extends JFrame{
	
	JLabelGraficoAjustado background,usuario,pass,btn;
	JPanel panel;
	JLabelGraficoAjustado title;
	StandardAudio clip;
	private int w = 1000,h=600;
	static JTextField us = new JTextField();
	static JPasswordField pa = new JPasswordField();
	
	static Properties prop = new Properties();
	
	public JTextField getUs() {
		return us;
	}
	
	public void setUs(String a) {
		
		Login.us.setText(a);
		
	}
	
	BDlocal bd = new BDlocal();
	
	HashMap<String, String> mapa;
	
	public Login() {
		
		
		try { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } catch(Exception ignored){}
		
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
		
		
		
		
		us.setBounds(405, ((h/6)/2)+210, 150, 30);
		
		
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
		
		mapa = new HashMap<String, String>();
		

		
	       
		HashMap<String, String> mapa = bd.getPlayerMap();
	    Set<String> set = mapa.keySet();
	    
		
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				btn.setImagen("src/res/play1.png");
				
				String user = us.getText();
				
				
				String passw = pa.getText();
				
				if (user.length()<3||passw.length()<3) {
					
					JOptionPane.showMessageDialog(null, "Intentalo de nuevo");
					
				}else if (!set.contains(user)) {
					
					saveProps(user, passw);
					bd.insert("PLAYERS", "('"+user+"', '"+passw+"', 400 )");	
					
//					Connection c = null;
//					
//					Statement stmt = null;
//					
//				    try { //-----------------INSERT PLAYER-----------------------------
//			          Class.forName("org.sqlite.JDBC");
//			          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
//			          c.setAutoCommit(false);
//			          System.out.println("Opened database successfully");
//			
//			          stmt = c.createStatement();
//			          String sql = "INSERT INTO PLAYERS (NAME_P,PASSWORD,GEMS,POS) " +
//			                         "VALUES ('"+user+"', '"+passw+"', 500, 1 );"; 
//			          stmt.executeUpdate(sql);
//			
//			        
//			          stmt.close();
//			          c.commit();
//			          c.close();
//			          
//			          saveProps(user, passw);
//			       } catch ( Exception ex ) {
//			          System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
//			          System.exit(0);
//			       }
//			       System.out.println("Records created successfully");
						
					
						
			
							
					JOptionPane.showMessageDialog(null, "CUENTA CREADA");
					new LeMenu(false);
					
					frame.dispose();
					
					
				}else if (passw.equals(mapa.get(user))) {
					
					JOptionPane.showMessageDialog(null, "Bienvenido " +user);
					saveProps(user, passw);
					new LeMenu(false);
					frame.dispose();
				}else {				
					JOptionPane.showMessageDialog(null, "Contraseņa Erronea");
				}	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");
			prop.load(input);			
			String lastUs = prop.getProperty("username");
			String lastPass = prop.getProperty("password");
			us.setText(lastUs);
			pa.setText(lastPass);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void saveProps(String u,String p) {
		
		OutputStream output = null;
	
		try {
			output = new FileOutputStream("config.properties");
			prop.setProperty("username", u);
			prop.setProperty("password", p);

			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new Login();

	}
}