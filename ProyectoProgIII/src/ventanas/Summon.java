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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Datos.TowerType;
import weareSupports.BD;
import weareSupports.BDlocal;
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
    
    String lastUs;
    
    ArrayList<String> ownedTowers = new ArrayList<String>();
	ArrayList<String> ownedTNames = new ArrayList<String>();
	ArrayList<String> missingTowers = new ArrayList<String>();
	ArrayList<String> missingTNames = new ArrayList<String>();
    
	BDlocal bd = new BDlocal();
	
	public Summon() {
		
  
	    Properties prop = new Properties();

		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			
			lastUs = prop.getProperty("username");
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
		
		
		missingTowers = bd.getTowerIDs();

	       
	
	ownedTowers = bd.getOwnedTowerIDs(player);
	     

		
		
		
		
		
		for (String t: ownedTowers) {
			if (missingTowers.contains(t))
				missingTowers.remove(t);		
		}
		
		for(String t: missingTowers) {	
			missingTNames.add(bd.getTName(t));      
		}
		
		for(String t: ownedTowers) {		
			ownedTNames.add(bd.getTName(t));
			}
		
		

		
		
		panel = new JPanel();
		panel.setSize(300, 300);
			
		b = new JButton("SUMMON");
		
		lGems = new JLabelGraficoAjustado("gem", 40, 40);
		
		BDlocal bd  = new BDlocal();
		nGems = new JLabel(Integer.toString((bd.getGems(player))));
		
		JPanel pTop = new JPanel();
		pTop.setBackground(Color.BLACK);
		nGems.setForeground(Color.white);
		pTop.add(lGems);
		pTop.add(nGems);
		
		JPanel pR = new JPanel();
		
		
		GridLayout l = new GridLayout(11, 1);
		l.setVgap(20);
		
		pR.setLayout(l);
		pR.setBackground(Color.black);
		
		pR.add(b);
		
		JLabel lD = new  JLabel("                     TU COLECCION                      ");
		lD.setForeground(Color.WHITE);
		
		pR.add(lD);
		
		for (String t : ownedTNames) {
			pR.add(new JLabelGraficoAjustado(t, 100, 100));
		}
		

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
		primerPlano.setBounds(460, 300, 100,100);
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
		
		
		cp.add(pTop, BorderLayout.NORTH);
	
		cp.add(layered, BorderLayout.CENTER);
		cp.add(pR, BorderLayout.EAST);

		
		
		setSize(1150,650);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		 Random random = new Random();
		 
		b.addActionListener(new ActionListener() {
	
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (bd.getGems(player)>=100) {
				b.setEnabled(false);
				if(missingTNames.size()!=0) {
				int g =	Integer.parseInt(nGems.getText())-100;
				bd.updateGems(player,"-100");
				nGems.setText(Integer.toString(g));
				
				int r = random.nextInt(missingTNames.size());
				
				String tex = missingTNames.get(r);
				System.out.println(tex);
				primerPlano.setImagen( "src/res/"+tex+".png");
				
				missingTNames.remove(tex);
				ownedTNames.add(tex);
				pR.add(new JLabelGraficoAjustado(tex, 100, 100));
				
				String ide = bd.getID(tex);			
				bd.insert("TIENE", "('"+ide+"', '"+player+"' )" );
				
				
				
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
						pR.repaint();
					} catch (Exception e) {
						// TODO: handle exception
					}}
				});
				t.start();
			
			}
		}else {JOptionPane.showMessageDialog(null,"TE FALTAN GEMAS");}
				}
			}
		);
		
	}
	public Thread t;
	
	public static void main(String[] args) {
		new Summon();
	}

	public JLabel getnGems() {
		return nGems;
	}

	public void setnGems(JLabel nGems) {
		this.nGems = nGems;
	}
public JButton getButton() {
	return b;
}

public ArrayList<String> getOwnedTowers() {
	return ownedTowers;
}

public void setOwnedTowers(ArrayList<String> ownedTowers) {
	this.ownedTowers = ownedTowers;
}

public ArrayList<String> getOwnedTNames() {
	return ownedTNames;
}

public void setOwnedTNames(ArrayList<String> ownedTNames) {
	this.ownedTNames = ownedTNames;
}

public ArrayList<String> getMissingTowers() {
	return missingTowers;
}

public void setMissingTowers(ArrayList<String> missingTowers) {
	this.missingTowers = missingTowers;
}

public ArrayList<String> getMissingTNames() {
	return missingTNames;
}

public void setMissingTNames(ArrayList<String> missingTNames) {
	this.missingTNames = missingTNames;
}

public String getLastUs() {
	return lastUs;
}

public void setLastUs(String lastUs) {
	this.lastUs = lastUs;
}

public String getPlayer() {
	return player;
}

public void setPlayer(String player) {
	this.player = player;
}


}
