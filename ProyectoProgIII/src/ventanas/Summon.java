package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Datos.TowerType;
import weareSupports.JLabelGraficoAjustado;

public class Summon extends JFrame{
	
	
	JPanel panel;
	ImageIcon icon;
	JButton b;
	JLabel label;
	JLabelGraficoAjustado lChar;
	JLabelGraficoAjustado lChar2;
	JLabelGraficoAjustado lGems;
	JLabel nGems;
	

	Connection c = null;
    Statement stmt = null;
    String player = "";
    
    
    
	public Summon() {
		
		
		
		
	     
	    ArrayList<String> ownedTowers = new ArrayList<String>();
	    ArrayList<String> ownedTNames = new ArrayList<String>();
	    ArrayList<String> missingTowers = new ArrayList<String>();
	    ArrayList<String> missingTNames = new ArrayList<String>();
	  
	    
	   
	    Properties prop = new Properties();

		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			
			String lastUs = prop.getProperty("username");
			player = lastUs;
			

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
		
		
		try { 
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS;" );
	          
	          while ( rs.next() ) {
	             String id = rs.getString("ID");
	             
	             
	             missingTowers.add(id);
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
	       
	
	
	     
		try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT ID_T FROM TIENE WHERE NAME_P="+"\""+player+"\""+";");
	          
	          while ( rs.next() ) {
	             
	             
	          String torre = rs.getString("ID_T");
	             
	          ownedTowers.add(torre);
	            
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
			
		
		
		
		
		
		
		for (String t: ownedTowers) {
			if (missingTowers.contains(t))
				missingTowers.remove(t);
			
		}
		
		for(String t: missingTowers) {
		
		try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          
	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT NAME FROM TOWERS WHERE ID ="+"\""+t+"\""+"; ");
	          
	          while ( rs.next() ) {
	             
	             
	          String torre = rs.getString("NAME");
	             
	         missingTNames.add(torre);
	            
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	      
		}
		
		for(String t: ownedTowers) {
			
			try {
		          Class.forName("org.sqlite.JDBC");
		          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
		          c.setAutoCommit(false);
		          
		          stmt = c.createStatement();
		          ResultSet rs = stmt.executeQuery( "SELECT NAME FROM TOWERS WHERE ID ="+"\""+t+"\""+"; ");
		          
		          while ( rs.next() ) {
		             
		             
		          String torre = rs.getString("NAME");
		             
		         ownedTNames.add(torre);
		            
		            
		          }
		          rs.close();
		          stmt.close();
		          c.close();
		       } catch ( Exception e ) {
		          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		          System.exit(0);
		       }
		      
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		panel = new JPanel();
		panel.setSize(300, 300);
		
//		icon = new ImageIcon();
//		label = new JLabelGraficoAjustado("Empty",100,100);
//		JLabel label2 = new JLabel("aaaaaaaaaaaaaaaaaaaaaaaaaa");
//		
		b = new JButton("SUMMON");
		
		lGems = new JLabelGraficoAjustado("gem", 40, 40);
		nGems = new JLabel("9999");
		
		JPanel pTop = new JPanel();
		pTop.setBackground(Color.BLACK);
		//pTop.setLayout(new GridLayout());
		nGems.setForeground(Color.white);
		pTop.add(lGems);
		pTop.add(nGems);
		
		JPanel pR = new JPanel();
		
		
		GridLayout l = new GridLayout(11, 1);
		l.setVgap(20);
		//l.setHgap(800);
		pR.setLayout(l);
		pR.setBackground(Color.black);
		
		pR.add(b);
		
		JLabel lD = new  JLabel("HOLA BUENAS TARDES");
		lD.setForeground(Color.WHITE);
		
		pR.add(lD);
		
		for (String t : ownedTNames) {
			pR.add(new JLabelGraficoAjustado(t, 100, 100));
		}
		
//		lChar = new JLabelGraficoAjustado("S32", 100,100);
//		
//	
//		//lChar.setBounds(300, 300, 300, 300);
//		lChar2 = new JLabelGraficoAjustado("S97", 100, 100);
//		
		Container cp = this.getContentPane();
		
		
		
		
		JLayeredPane layered = new JLayeredPane();

		// La imagen de fondo metida en un JLabel, dandole el
		// tamano adecuado.
		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon("su.gif");
		
		fondo.setIcon(imagen);
		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		fondo.setSize(1000, 600);
		// La etiqueta que ira encima de la imagen.
		
		JLabelGraficoAjustado primerPlano = new JLabelGraficoAjustado("Empty",100,100);
		primerPlano.setSize(100, 100);
		primerPlano.setBounds(500, 300, 100,100);
		
		primerPlano.setVisible(false);
		
		icon = new ImageIcon();
		label = new JLabelGraficoAjustado("Empty",200,200);
		label.setBounds(425, 250, 200, 200);
		

		// Se mete imagen y etiqueta en el JLayeredPane.
		// Debe ser Integer, no vale int.
		// Los Integer bajos corresponden a capas del fondo.
		layered.add(fondo, new Integer(1));
		layered.add(primerPlano, new Integer(2));
		layered.add(label, new Integer(3));
		
		
		
		layered.setBackground(Color.BLACK);
		
		
		
		
		
		
		
		
		//lChar.setBounds(300, 300, 100, 100);
//		panel.add(lChar);
//		lChar.setVisible(false);
//		panel.add(label);
		
		cp.add(pTop, BorderLayout.NORTH);
		//cp.add(panel, BorderLayout.CENTER);
		cp.add(layered, BorderLayout.CENTER);
		cp.add(pR, BorderLayout.EAST);
;
		
		
		setSize(1150,650);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		 Random random = new Random();
		 
		b.addActionListener(new ActionListener() {
	
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				b.setEnabled(false);
				if(missingTNames.size()!=0) {
				int g =	Integer.parseInt(nGems.getText())-100;
				nGems.setText(Integer.toString(g));
				
				int r = random.nextInt(missingTNames.size());
				
				String tex = missingTNames.get(r);
				System.out.println(tex);
				primerPlano.setImagen( "src/res/"+tex+".png");
				
				missingTNames.remove(tex);
				ownedTNames.add(tex);
				pR.updateUI();
				
				String ide = "";
				try { 
			          Class.forName("org.sqlite.JDBC");
			          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
			          c.setAutoCommit(false);
			          System.out.println("Opened database successfully");
		
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
			          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			          System.exit(0);
			       }
			       System.out.println("Operation done successfully");
				
				try {//------------------INSERT TIENE-----------------
			          Class.forName("org.sqlite.JDBC");
			          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
			          c.setAutoCommit(false);
			          System.out.println("Opened database successfully");
		
			          stmt = c.createStatement();
			          String sql = "INSERT INTO TIENE " +
			                         "VALUES ('"+ide+"', '"+player+"' );"; 
			          stmt.executeUpdate(sql);
			         
		
			         
		
		
			          stmt.close();
			          c.commit();
			          c.close();
			       } catch ( Exception e ) {
			          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			          System.exit(0);
			       }
			       System.out.println("Records created successfully");
				
				
				
				
				
				
				t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						for (int i = 0; i < 31; i++) {
							if (i==19) primerPlano.setVisible(true);
							icon = new ImageIcon("src/anim2/tile"+i+".png");
							
							
							label.setIcon(icon);
							
							
							label.repaint();
							
							
							
							
							
							
							try {
								Thread.sleep(60);
							} catch (Exception e) {
							}
						}
					try {
						Thread.sleep(2000);
						primerPlano.setVisible(false);
						b.setEnabled(true);
					} catch (Exception e) {
						// TODO: handle exception
					}}
				});
				t.start();
			
			}
		}});
	}
	public Thread t;
	
	public static void main(String[] args) {
		new Summon();
	}

}
