package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;

import weareSupports.JLabelGraficoAjustado;

public class SelectorMapas extends JFrame{
	
	JPanel panel;
	JLabelGraficoAjustado m1, m2, m3, m4, m5, m6, fondo;
	
	public SelectorMapas() {
		
		panel = new JPanel();
		//panel.setLayout(new GridLayout(2, 6));
		panel.setBackground(Color.black);
		
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
		
		this.add(fondo);
		
		//this.add(panel);
		
		
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
