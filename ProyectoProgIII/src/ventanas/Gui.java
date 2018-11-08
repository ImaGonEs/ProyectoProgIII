package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

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

import weareSupports.JLabelGraficoAjustado;

class Gui extends JFrame {
	
	GridBagLayout gbl = new GridBagLayout();

	Gui() {
		
		setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1300,750);
		setLocationRelativeTo(null);
		
		//ey
		
		JLabelGraficoAjustado lc1 = new JLabelGraficoAjustado("src/res/torre.png",40,40);
		JLabelGraficoAjustado lc2 = new JLabelGraficoAjustado("src/res/Mob0.png", 40, 40);
		JLabelGraficoAjustado lc3 = new JLabelGraficoAjustado("src/res/circle.png", 40, 40);
		JLabelGraficoAjustado lc4 = new JLabelGraficoAjustado("src/res/d0.png" ,40, 40);
		
		JLabelGraficoAjustado lt1 = new JLabelGraficoAjustado("src/res/torre.png",40,40);
		JLabelGraficoAjustado lt2 = new JLabelGraficoAjustado("src/res/Mob0.png", 40, 40);
		JLabelGraficoAjustado lt3 = new JLabelGraficoAjustado("src/res/circle.png", 40, 40);
		JLabelGraficoAjustado lt4 = new JLabelGraficoAjustado("src/res/d0.png" ,40, 40);
		
		
		
		ArrayList <JLabelGraficoAjustado> collection = new ArrayList<JLabelGraficoAjustado>();
		
		collection.add(lc1);
		collection.add(lc2);
		collection.add(lc3);
		collection.add(lc4);
		
		ArrayList <JLabelGraficoAjustado> team = new ArrayList<JLabelGraficoAjustado>();
		
		team.add(lt1);
		team.add(lt2);
		team.add(lt3);
		team.add(lt4);
		
		
		String stats1[][]={	{"Damage","999"},    
							{"Attack speed","2.5"},    
							{"Radius","30"}}; 
		
		String column[]={"stats",""};         
		JTable jt=new JTable(stats1,column);    
		jt.setBounds(30,40,200,600);   
		
		
		
		String stats2[][]={	{"Damage","1234"},    
				{"Attack speed","5.5"},    
				{"Radius","20"}}; 
         
		JTable jt2 = new JTable(stats2,column);   
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
		
		for( JLabelGraficoAjustado la : collection) {
			pnlA.add(la);
		}
		for (JLabelGraficoAjustado la : team) {
			pnlB.add(la);
		}
		
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
		
		
		//más
		
		JButton bS = new JButton("SAVE");
		JButton bE = new JButton("EXIT");
		
		pnlF.add(bS);
		pnlF.add(bE);
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
