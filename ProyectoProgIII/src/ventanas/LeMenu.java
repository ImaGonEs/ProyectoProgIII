package ventanas;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Datos.Boot;
import javafx.scene.layout.BackgroundPosition;
import weareSupports.JLabelGraficoAjustado;
import weareSupports.StandardAudio;

public class LeMenu extends JFrame{
	
	JLabelGraficoAjustado bP1, bP2, bT1, bT2, bSu1, bSu2, bSe1, bSe2,background;
	JPanel panel;
	JLabelGraficoAjustado title;
	StandardAudio clip;
	public LeMenu() {
		
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container cp = this.getContentPane();
		panel = new JPanel();
		panel.setLayout(null);
		
		clip = new StandardAudio("src/res/Evil Mortys Theme.wav",true);
		
		background = new JLabelGraficoAjustado("src/res/forest.png", 1000, 900);
		
		title = new JLabelGraficoAjustado("src/res/title.png", 800, 100);
		
		
		
		bP1 = new JLabelGraficoAjustado("src/res/play1.png",200,100); 
		//bP2 = new JLabelGraficoAjustado("play2.png",100,100); 
		bT1 = new JLabelGraficoAjustado("src/res/team1.png",200,100); 
		//bT2 = new JLabelGraficoAjustado("team2O",100,100); 
		bSu1 = new JLabelGraficoAjustado("src/res/summon1.png",200,100); 
		//bSu2 = new JLabelGraficoAjustado("summon2",100,100); 
		bSe1 = new JLabelGraficoAjustado("src/res/settings1.png",200,100); 
		//bSe2 = new JLabelGraficoAjustado("settings2",100,100);
		
		cp.add(background);

	
		
		bP1.setLocation(200,200 );
		
		bSe1.setLocation(200,400 );
		
		bT1.setLocation(500,200 );
		
		bSu1.setLocation(500,400 );
		
		title.setLocation(100, 50);
		
		background.add(bP1);
		background.add(bT1);
		background.add(bSe1);
		background.add(bSu1);
		background.add(title);
		
		
		cp.validate();
		cp.repaint();
		
		
		
		bP1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bP1.setImagen("src/res/play1.png");
				new Boot();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				bP1.setImagen("src/res/play2.png");
				clip.FXPlay();
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
		
		bT1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bT1.setImagen("src/res/team1.png");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				bT1.setImagen("src/res/team2.png");
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
		
		bSe1.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bSe1.setImagen("src/res/settings1.png");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				bSe1.setImagen("src/res/settings2.png");
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
	
		bSu1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bSu1.setImagen("src/res/summon1.png");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				bSu1.setImagen("src/res/summon2.png");
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
		new LeMenu();
	}
	

}
