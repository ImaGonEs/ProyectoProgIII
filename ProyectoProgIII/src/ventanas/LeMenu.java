
package ventanas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Datos.Boot;
import Datos.Map;
import javafx.scene.layout.BackgroundPosition;
import weareSupports.JLabelGraficoAjustado;
import weareSupports.StandardAudio;

public class LeMenu extends JFrame{
	
	JLabelGraficoAjustado bP1, bP2, bT1, bT2, bSu1, bSu2, bSe1, bSe2,bFS,background;
	JPanel panel;
	JLabelGraficoAjustado title;
	StandardAudio clip;
	private int w = 1000,h=600;
	
	static boolean mapaRecCargado = false;
	static Map grid = null;
	static int[][] mapa;
	Options o;
	
	public static int[][] getMapa() {
		return mapa;
	}
	public static void setMapa(int[][] mapa) {
		LeMenu.mapa = mapa;
	}
	public static Map getGrid() {
		return grid;
	}
	public static void setGrid(Map grid) {
		LeMenu.grid = grid;
	}
	public static void  setMapaRecCargado(boolean b) {
		
		mapaRecCargado = b;
	}
	public static boolean  getMapaRecCargado() {
		
		return mapaRecCargado;
	}
	
	
	public LeMenu(boolean f) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = this;
				
		if (f ==false) {
		w = 1000;
		h = 600;
		}else {
			
			w = (int) screenSize.getWidth();
			h = (int) screenSize.getHeight();	
		}
		
		setUndecorated(f);
		setSize(w,h);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container cp = this.getContentPane();
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		background = new JLabelGraficoAjustado("forest", w, (int) ((int) h*1.5)); //1000,900
		
		title = new JLabelGraficoAjustado("title", (int) (w*0.8), h/6); //800,100
				
		bP1 = new JLabelGraficoAjustado("play1",(int) (w*0.2),h/6);  //200,100   (int) (w*0.2),h/6
	 
		bT1 = new JLabelGraficoAjustado("team1",(int) (w*0.2),h/6); 
	
		bSu1 = new JLabelGraficoAjustado("summon1",(int) (w*0.2),h/6); 
	
		bSe1 = new JLabelGraficoAjustado("settings1",(int) (w*0.2),h/6); 
		
		
		
		bFS = new JLabelGraficoAjustado("FS3", (int) (w*0.1),h/6);
		
		cp.add(background);
		
		bP1.setLocation(w/5,h/3 );  //200,200      w/5,h/3 
		
		bSe1.setLocation(w/5,2*(h/3) ); //200,400    w/5,2*(h/3) 
		
		bT1.setLocation(w/2,h/3 ); //500,200       w/2,w/3 
		
		bSu1.setLocation(w/2,2*(h/3) ); //500,400     w/2,2*(w/3) 
		
		title.setLocation(w/10, (h/6)/2); //100,50   w/10, (w/6)/2
		
		bFS.setLocation(w/1.15 , 2*(h/2.6));
		
		background.add(bP1);
		background.add(bT1);
		background.add(bSe1);
		background.add(bSu1);
		background.add(title);
		background.add(bFS);		
		cp.validate();
		cp.repaint();
						
		bP1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bP1.setImagen("src/res/play1.png");
				Thread boot = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						new SelectorMapas();
					}
				});
				boot.start();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				bP1.setImagen("src/res/play2.png");
				//clip.FXPlay();
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
				Thread gui = new Thread(new Runnable() {	
					@Override
					public void run() {
						// TODO Auto-generated method stub
						new Gui();
					}
				});
				gui.start();
				
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
					try {
						o.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block	
						o = new Options();
					}	
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
				new Summon();
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
		bFS.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bFS.setImagen("src/res/FS3.png");				
				if ( f == false) {
				new LeMenu(true);
				}else {		
					new LeMenu(false);	
				}
				frame.dispose();
				
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				bFS.setImagen("src/res/FS31.png");
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
		new LeMenu(false);
	}
	

}
