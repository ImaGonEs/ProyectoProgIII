package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Datos.Boot;
import weareSupports.JLabelGraficoAjustado;

public class SelectorMapas extends JFrame{
	
	JPanel panel;
	JLabelGraficoAjustado m1, m2, m3, m4, m5, m6, fondo;
	
	public SelectorMapas() {
		
		JFrame frame = this;
		
		
		panel = new JPanel();
		//panel.setLayout(new GridLayout(2, 6));
		panel.setBackground(Color.orange);
		
		m1 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m2 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m3 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m4 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m5 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m6 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		

		fondo = new JLabelGraficoAjustado("fondoMapas", 1000, 700);
		fondo.setLayout(new GridLayout(2, 6));
		
		
		fondo.add(m1);
		fondo.add(m2);
		fondo.add(m3);
		fondo.add(m4);
		fondo.add(m5);
		fondo.add(m6);

		
		
		panel.add(m1);
		panel.add(m2);
		panel.add(m3);
		panel.add(m4);
		panel.add(m5);
		panel.add(m6);

		
		//this.add(fondo);
		
		

		this.add(panel);

	
		//this.add(panel);
		

		
		m1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				Thread boot = new Thread (new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						new SlidderDif("Mapa1");
					}
				});

				
				boot.start();
				
				frame.dispose();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		
		
		m2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				Thread boot = new Thread (new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						new SlidderDif("Mapa2");
					}
				});

				
				boot.start();
				
				frame.dispose();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		
		
		m3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				Thread boot = new Thread (new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						new SlidderDif("Mapa3");
					}
				});

				
				boot.start();
				
				frame.dispose();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		
		
		
		setSize(1000, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}

	public static void main(String[] args) {
		new SelectorMapas();
	}
}
