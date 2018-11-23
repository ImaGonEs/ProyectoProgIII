package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
	public Summon() {
		
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
		JLabelGraficoAjustado primerPlano = new JLabelGraficoAjustado("S32",100,100);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 
		b.addActionListener(new ActionListener() {
	
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						for (int i = 0; i < 31; i++) {
							if (i==19) primerPlano.setVisible(true);
							icon = new ImageIcon("src/anim2/tile"+i+".png");
							
							
							label.setIcon(icon);
							
							
							label.repaint();
							
							try {
								Thread.sleep(80);
							} catch (Exception e) {
							}
						}
					}
				});
				t.start();
			
			}
		});
	}
	public Thread t;
	
	public static void main(String[] args) {
		new Summon();
	}

}
