package ventanas;

import static weareSupports.Creador.HEIGHT;
import static weareSupports.Creador.QuickCast;
import static weareSupports.Creador.QuickCastIcon;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import Datos.Player;
import Datos.Sust;
import Datos.Tower;
import Datos.TowerCannon;
import Datos.TowerFire;
import Datos.TowerIce;
import Datos.TowerMelee;
import Datos.TowerType;
import weareSupports.JLabelGraficoAjustado;

class Gui extends JFrame {
	
	
	 private boolean jtcont  = true;;
	 private String stats1[][]={	{"Damage",""},    
			{"Attack speed",""},    
			{"Radius",""}}; 
	
	private String stats2[][]={	{"Damage",""},    
			{"Attack speed",""},    
			{"Radius",""}}; 
	
	private String column[]={"stats",""};         
	private JTable jt=new JTable(stats1,column); 
	
	private JTable jt2 = new JTable(stats2,column);   
	GridBagLayout gbl = new GridBagLayout();
	
	
	
	static String player = "";
	
	
	
	private ArrayList <String> teamF = new ArrayList<String>(); //el objeto en si, esto lo usaremos para guardarlo en un txt que leera el mapa
	
	public static ArrayList<Sust> collect(){
		
		Connection c = null;
		Statement stmt = null;
		
		
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
		Sust az = null;
		ArrayList<Sust> collect = new ArrayList<Sust>();
		ArrayList<String> towerCodes = new ArrayList<String>();
		
		 try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT ID_T FROM TIENE WHERE NAME_P='"+player+"';" );
		      
		      while ( rs.next() ) {
		         
		         String  id = rs.getString("id_t"); 
		         
		        // TowerType t = TowerType.valueOf(id);
		        // String name = t.getTex();
		         
		        towerCodes.add(id); 
		        
		      }
		      
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully");
		   
		   
		for (String s: towerCodes) {
		   try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
			      c.setAutoCommit(false);
			      System.out.println("Opened database successfully");

			      stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery( "SELECT * FROM TOWERS WHERE ID='"+s+"';" );
			      
			      while ( rs.next() ) {
			         
			         String  id = rs.getString("id"); 
			         
			        String name = rs.getString("name");
			         
			         int dmg = rs.getInt("damage");
			         int range = rs.getInt("range");
			         float atkspd = rs.getFloat("atkspeed");
			        az = new Sust(id,name,dmg,range,atkspd);
			         collect.add(az);
			      }
			      
			      rs.close();
			      stmt.close();
			      c.close();
			   } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			   }
			   System.out.println("Operation done successfully");
		}
		
		
		return collect;
	}
	
	protected static void guardaTeam(ArrayList<String> y,String player){
		
		FileOutputStream fich = null;
		ObjectOutputStream li = null;
		
		
	
		
		try {
			
			fich = new FileOutputStream("src/res/Team"+player+".txt");
			li = new ObjectOutputStream(fich);
			li.writeObject(y);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	           try {
	               
	               if (null != fich)
	                  fich.close();
	               } catch (Exception e2) {
	                  e2.printStackTrace();
	               }
	            }
	}
	
	
	
	
	
	
	Gui() {
		
		
		
		JFrame frame = this;
		
		
		
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jt.setDefaultEditor(Object.class, null);
		jt2.setDefaultEditor(Object.class, null);
		setLayout(gbl);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1300,750);
		setLocationRelativeTo(null);
		
		//ey
		
		
         
		
		ArrayList<Sust> tcd = collect();
		ArrayList<String> tca = Player.leeTeam(player);
		ArrayList<TowerMelee> tmd = new ArrayList<TowerMelee>();
		
		
		
		
		
		
//		tcd.add( new TowerCannon(15,2,20,QuickCastIcon("torre")));
//		tcd.add(new TowerCannon(18,2,25,QuickCastIcon("Mob0")));
		
		
//		JLabelGraficoAjustado lc1 = new JLabelGraficoAjustado("src/res/torre.png",40,40);
//		JLabelGraficoAjustado lc2 = new JLabelGraficoAjustado("src/res/Mob0.png", 40, 40);
//		JLabelGraficoAjustado lc3 = new JLabelGraficoAjustado("src/res/circle.png", 40, 40);
//		JLabelGraficoAjustado lc4 = new JLabelGraficoAjustado("src/res/d0.png" ,40, 40);
//		
//		JLabelGraficoAjustado lt1 = new JLabelGraficoAjustado("src/res/torre.png",40,40);
//		JLabelGraficoAjustado lt2 = new JLabelGraficoAjustado("src/res/Mob0.png", 40, 40);
//		JLabelGraficoAjustado lt3 = new JLabelGraficoAjustado("src/res/circle.png", 40, 40);
//		JLabelGraficoAjustado lt4 = new JLabelGraficoAjustado("src/res/d0.png" ,40, 40);

		
		
		ArrayList <JLabelGraficoAjustado> collection = new ArrayList<JLabelGraficoAjustado>();
		ArrayList <JLabelGraficoAjustado> teamAnt = new ArrayList<JLabelGraficoAjustado>();
	
		ArrayList <JLabelGraficoAjustado> teami = new ArrayList<JLabelGraficoAjustado>(); //los iconos solo
		
		
		
		
		
		
		   
		jt.setBounds(30,40,200,600);   
		
		
		
		
		
		jt.setBounds(30,40,200,600);   
		
		
		//JScrollPane sp=new JScrollPane(jt);  
		//instantiates Border panels.
		BorderPanel pnlA = new BorderPanel("COLLECTION");
		BorderPanel pnlB = new BorderPanel("TEAMSELECTOR");
		BorderPanel pnlC = new BorderPanel("ACT_TEAM");
		//BorderPanel pnlD = new BorderPanel("Panel D");
		BorderPanel pnlE = new BorderPanel("STATS");
		BorderPanel pnlF = new BorderPanel("OPTIONS");

		//adding all panels to main contentPane.
		add(pnlA);
		add(pnlB);
		add(pnlC);
		//add(pnlD);
		add(pnlE);
		add(pnlF);

		//set constraints of each panel.
		makeConstraints(gbl, pnlA, 1, 2, 0, 0, 2.0, 6.0);
		makeConstraints(gbl, pnlB, 2, 1, 1, 0, 2.0, 0.13);
		makeConstraints(gbl, pnlC, 1, 1, 0, 2, 1.0, 1.0); 
		//makeConstraints(gbl, pnlD, 1, 2, 1, 1, 1.0, 1.0);
		makeConstraints(gbl, pnlE, 1, 1, 2, 1, 1.0, 1.0);
		makeConstraints(gbl, pnlF, 1, 1, 2, 2, 1.0, 1.0);
		
		
		
		//stats
		
		JPanel pI = new JPanel();
		JPanel pD = new JPanel();
		GridLayout gl = new GridLayout(2, 2);
		gl.setHgap(1);
		gl.setVgap(1);
		
		
		
		pnlE.setLayout(new BorderLayout());
		
		pI.add(jt);
		pD.add(jt2);
		JLabel labt1 = new JLabel("TOWER1");
		JLabel labt2 = new JLabel("TOWER2");
		labt1.setHorizontalAlignment(JLabel.CENTER);
		labt2.setHorizontalAlignment(JLabel.CENTER);
		
		 JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                 jt, jt2);
		 
		 splitPane.setResizeWeight(0.5);
		 splitPane.setOneTouchExpandable(true);
		 splitPane.setContinuousLayout(true);
		 
		
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(1,2));
		
		pn.add(labt1);
		pn.add(labt2);
		
		pnlE.add(pn, BorderLayout.NORTH);
		
		pnlE.add(splitPane);
		//pnlE.add(pI);
		//pnlE.add(new JSeparator(SwingConstants.VERTICAL));
		//pnlE.add(pD);
		

		for (String j : tca) {
			
			JLabelGraficoAjustado z;
			
			switch(j) {
			
			case "T01":
				z = new JLabelGraficoAjustado(TowerType.T01.getTex(),40,40);
				pnlC.add(z);
				break;
			case "T02":
				z = new JLabelGraficoAjustado(TowerType.T02.getTex(),40,40);
				pnlC.add(z);
				break;
			case "T03":
				z = new JLabelGraficoAjustado(TowerType.T03.getTex(),40,40);
				pnlC.add(z);
				break;
			case "T04":
				z = new JLabelGraficoAjustado(TowerType.T04.getTex(),40,40);
				pnlC.add(z);
				break;
			case "T05":
				z = new JLabelGraficoAjustado(TowerType.T05.getTex(),40,40);
				pnlC.add(z);
				break;
			case "T06":
				z = new JLabelGraficoAjustado(TowerType.T06.getTex(),40,40);
				pnlC.add(z);
				break;
			case "T07":
				z = new JLabelGraficoAjustado(TowerType.T07.getTex(),40,40);
				pnlC.add(z);
				break;
			}
			
		}
		
		
		
		
		
		
		for (Sust i : tcd) {
			JLabelGraficoAjustado z = new JLabelGraficoAjustado(i.getTex(),40,40);
			System.out.println(i.getTex());
			collection.add(z);
			collection.get(collection.indexOf(z)).addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
					
					
				}
				
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					
					boolean c = e.isMetaDown();
					if(c==false) {
					if (jtcont == true) {
					
					
					jt.setValueAt(Integer.toString(i.getDamage()), 0, 1);
					jt.setValueAt(Integer.toString((int) i.getAttackSpeed()), 1, 1);
					jt.setValueAt(Integer.toString(i.getRange()), 2, 1);
					jtcont = false;
					
					} else {
						
						jt2.setValueAt(Integer.toString(i.getDamage()), 0, 1);
						jt2.setValueAt(Integer.toString((int) i.getAttackSpeed()), 1, 1);
						jt2.setValueAt(Integer.toString(i.getRange()), 2, 1);
						jtcont = true;
						
					}
					}
					
					if (c== true) {
						
						if (!teami.contains(z)){
							if(teamF.size()<4) {
							System.out.println("adre");
							
							switch(i.getId()) {
							
							case "T01":
								teamF.add("T01");
								break;
							case "T02":
								teamF.add("T02");
								break;
							case "T03":
								teamF.add("T03");
								break;
							case "T04":
								teamF.add("T04");
								break;
							case "T05":
								teamF.add("T05");
								break;
							case "T06":
								teamF.add("T06");
								break;
							case "T07":
								teamF.add("T07");
								break;
							}
							
						teami.add(z);
						collection.remove(z);
						
						for (String j : teamF) {
							System.out.println(j);
						}
						for (JLabelGraficoAjustado icono : teami) {
							pnlB.add(icono);
							
						}
							}
						} else {
							
							teami.remove(z);
							collection.add(z);
							teamF.remove(i.getId());
							for (JLabelGraficoAjustado icono : collection) {
								pnlA.add(icono);
								
							}
							
							
						}
						
						
						
						
						pnlB.repaint();
						pnlA.repaint();
						
						c = false;
						
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		
		
		
		for( JLabelGraficoAjustado la : collection) {
			pnlA.add(la);
		}
		for (JLabelGraficoAjustado la : teami) {
			pnlB.add(la);
		}
		
		
		
		
		
		
		
		//más
		
		JButton bS = new JButton("SAVE");
		JButton bE = new JButton("EXIT");
		//JButton bA = new JButton("REMOVE TEAM");
		
		bE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		
		
		bS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(teamF.size()==4) {
				guardaTeam(teamF, player);
				pnlC.removeAll();
				pnlC.setLayout(new BorderLayout());
	
				

				
				pnlC.repaint();
				
				JOptionPane.showMessageDialog(null,"Team guardado!");
				frame.dispose();
				
				}
				else {
					
					JOptionPane.showMessageDialog(null, "¿Crees poder pasarte un nivel con menos de 4 torres? ¡Casi champion!");
					
				}
			}
		});
		
		
		
		pnlF.add(bS);
		pnlF.add(bE);
	
		
		
		
	
		this.setVisible(true);
		
		
		
		
		
		
	}

	/**
	  * Generate constraints for Swing components
	  * @param gbl     a gridbaglayout that used to embed Swing component
	  * @param comp    a Swing component intended to be embedded in gbl
	  * @param w       desired component width
	  * @param h       desired component height
	  * @param x       desired location in x-axis
	  * @param y       desired location in y-axis
	  * @param weightx desired weight in terms of x-axis
	  * @param weighty desired weight in terms of y-axis
	  */
	public void makeConstraints(GridBagLayout gbl, JComponent comp, int w, int h, int x, int y,
			double weightx, double weighty) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		gbl.setConstraints(comp, constraints);
	}

	//Main method
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Gui();
			}
		});
	}
	
	
	
}

class BorderPanel extends JPanel {
	BorderPanel(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
	}
}	
