package ventanas;



import java.awt.BorderLayout;
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
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import Datos.Player;
import Datos.Sust;
import Datos.TowerType;
import weareSupports.BDlocal;
import weareSupports.JLabelGraficoAjustado;

class Gui extends JFrame {
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static BDlocal bd = new BDlocal();
	
	
	
	/* 
	 * Creacion de las tablas para comparar torres
	 * */
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
	
	
	//Layout usado por la ventana
	GridBagLayout gbl = new GridBagLayout();
	static String player = "";
	private ArrayList <String> teamF = new ArrayList<String>(); //el objeto en si, esto lo usaremos para guardarlo en un txt que leera el mapa
	
	
	public static ArrayList<Sust> collect(){	
		ArrayList<Sust> collect = new ArrayList<Sust>();
		ArrayList<String> towerCodes = new ArrayList<String>();	
		towerCodes = bd.getOwnedTowerIDs(player);	   
		for (String s: towerCodes) {			
			collect.add(bd.createSust(s));
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
				prop.load(input);
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
		
		//ArrayList de sustitutos con los datos de las torres de tu coleccion
		ArrayList<Sust> tcd = collect();
		//ArrayList con los id de las torres que usastes en tu team anterior
		ArrayList<String> tca = Player.leeTeam(player);
		//ArrayList con los sprites de las torres de tu coleccion
		ArrayList <JLabelGraficoAjustado> collection = new ArrayList<JLabelGraficoAjustado>();
		//ArrayList de las torres que vas eligiendo para tu team
		ArrayList <JLabelGraficoAjustado> teami = new ArrayList<JLabelGraficoAjustado>(); 
		     
		
		BorderPanel pnlA = new BorderPanel("COLLECTION");
		BorderPanel pnlB = new BorderPanel("TEAMSELECTOR");
		BorderPanel pnlC = new BorderPanel("ACT_TEAM");
		BorderPanel pnlE = new BorderPanel("STATS");
		BorderPanel pnlF = new BorderPanel("OPTIONS");

		add(pnlA);
		add(pnlB);
		add(pnlC);
		
		add(pnlE);
		add(pnlF);

		makeConstraints(gbl, pnlA, 1, 2, 0, 0, 2.0, 6.0);
		makeConstraints(gbl, pnlB, 2, 1, 1, 0, 2.0, 0.13);
		makeConstraints(gbl, pnlC, 1, 1, 0, 2, 1.0, 1.0); 
		makeConstraints(gbl, pnlE, 1, 1, 2, 1, 1.0, 1.0);
		makeConstraints(gbl, pnlF, 1, 1, 2, 2, 1.0, 1.0);
		
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

		//Añade tu team anterior al panel C
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
		
		
		//Añadimos MouseListeners a los JLabelGraficoAjustados para que se muevan de un panel a otro 
		for (Sust i : tcd) {
			JLabelGraficoAjustado z = new JLabelGraficoAjustado(i.getTex(),40,40);

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
					jt.setValueAt(Float.toString(i.getAttackSpeed()), 1, 1);
					jt.setValueAt(Integer.toString(i.getRange()), 2, 1);
					jtcont = false;
					
					} else {
						
						jt2.setValueAt(Integer.toString(i.getDamage()), 0, 1);
						jt2.setValueAt(Float.toString(i.getAttackSpeed()), 1, 1);
						jt2.setValueAt(Integer.toString(i.getRange()), 2, 1);
						jtcont = true;
						
					}
					}
					
					if (c== true) {
						
						if (!teami.contains(z)){
							if(teamF.size()<4) {
							
							
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
		
		JButton bS = new JButton("SAVE");
		JButton bE = new JButton("EXIT");
		
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
					JOptionPane.showMessageDialog(null, "¿Crees poder pasarte un nivel con menos de 4 torres?");
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