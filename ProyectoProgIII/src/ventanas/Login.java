package ventanas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Datos.Boot;
import weareSupports.JLabelGraficoAjustado;
import weareSupports.StandardAudio;

public class Login extends JFrame{
	
	JLabelGraficoAjustado background,usuario,pass,btn;
	JPanel panel;
	JLabelGraficoAjustado title;
	StandardAudio clip;
	private int w = 1000,h=600;
	JTextField us;
	JTextField pa;
	
	
	
	
	
	
	public Login() {
		
		
		
//		int w = (int) screenSize.getWidth();
//		int h = (int) screenSize.getHeight();
		
		
		
		
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
		
		background = new JLabelGraficoAjustado("src/res/forest.png", w, (int) ((int) h*1.5)); //1000,900
		
		title = new JLabelGraficoAjustado("src/res/Login.png", (int) 302, 146); 
		
		usuario = new JLabelGraficoAjustado("src/res/Usuario.png", (int) 100, 60); 
		 
		pass = new JLabelGraficoAjustado("src/res/Pass.png", (int) 100, 60); 
		
		btn = new JLabelGraficoAjustado("src/res/play1.png",(int) (w*0.2),h/6);
		
		
		
		us = new JTextField();
		us.setBounds(405, ((h/6)/2)+210, 150, 30);
		
		pa = new JTextField();
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
		
		
		
		
		
	
	
	}
	
	
	
	public static void main(String[] args) {
		new Login();
	}
}