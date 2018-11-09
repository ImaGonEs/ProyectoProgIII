package ventanas;

import static weareSupports.Creador.HEIGHT;
import static weareSupports.Creador.QuickCast;
import static weareSupports.Creador.QuickCastIcon;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import Datos.TowerCannon;
import Datos.TowerMelee;
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

	Gui() {
		
		setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1300,750);
		setLocationRelativeTo(null);
		
		//ey
		
		
         
		
		ArrayList<TowerCannon> tcd = new ArrayList<TowerCannon>();
		ArrayList<TowerMelee> tmd = new ArrayList<TowerMelee>();
		
		
		
		
		
		
		tcd.add( new TowerCannon(15,2,20,QuickCastIcon("torre")));
		tcd.add(new TowerCannon(18,2,25,QuickCastIcon("Mob0")));
		
		
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
		
	
		HashSet <JLabelGraficoAjustado> teami = new HashSet<JLabelGraficoAjustado>(); //los iconos solo
		
		HashSet <TowerCannon> teamT = new HashSet<TowerCannon>(); //el objeto en si, esto lo usaremos para guardarlo en un txt que leera el mapa
		
		
		
		   
		jt.setBounds(30,40,200,600);   
		
		
		
		
		
		jt.setBounds(30,40,200,600);   
		
		
		//JScrollPane sp=new JScrollPane(jt);  
		//instantiates Border panels.
		BorderPanel pnlA = new BorderPanel("COLLECTION");
		BorderPanel pnlB = new BorderPanel("TEAM");
		BorderPanel pnlC = new BorderPanel("Panel C");
		BorderPanel pnlD = new BorderPanel("Panel D");
		BorderPanel pnlE = new BorderPanel("STATS");
		BorderPanel pnlF = new BorderPanel("OPTIONS");

		//adding all panels to main contentPane.
		add(pnlA);
		add(pnlB);
		add(pnlC);
		add(pnlD);
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
		
		pnlE.setLayout(gl);
		
		
		pI.add(jt);
		pD.add(jt2);
		JLabel labt1 = new JLabel("TOWER1");
		JLabel labt2 = new JLabel("TOWER2");
		labt1.setHorizontalAlignment(JLabel.CENTER);
		labt2.setHorizontalAlignment(JLabel.CENTER);
		pnlE.add(labt1);
		pnlE.add(labt2);
		pnlE.add(pI);
		//pnlE.add(new JSeparator(SwingConstants.VERTICAL));
		pnlE.add(pD);
		
		
		for (TowerCannon i : tcd) {
			JLabelGraficoAjustado z = new JLabelGraficoAjustado(i.getIcon(),40,40);
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
					
					if (e.isMetaDown()) {
						
						
						
						teami.add(z);
						teamT.add(i);
						for (JLabelGraficoAjustado la : teami) {
							pnlB.add(la);
						}
						pnlB.repaint();
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
		JButton bA = new JButton("ADD");
		pnlF.add(bS);
		pnlF.add(bE);
		pnlF.add(bA);
		
		
		
	
		
		
		
		
		
		
		
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
				new Gui().setVisible(true);
			}
		});
	}
}

class BorderPanel extends JPanel {
	BorderPanel(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
	}
}	
