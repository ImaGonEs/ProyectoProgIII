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
	JLabelGraficoAjustado m1, m2, m3, m4, m5, m6;
	
	public SelectorMapas() {
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 6));
		panel.setBackground(Color.ORANGE);
		
		m1 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m2 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m3 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m4 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m5 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		m6 = new JLabelGraficoAjustado("CapturaMapa", 300, 200);
		
		panel.add(m1);
		panel.add(m2);
		panel.add(m3);
		panel.add(m4);
		panel.add(m5);
		panel.add(m6);
		
		
		this.add(panel);
		
		
		setSize(1000, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}

	public static void main(String[] args) {
		new SelectorMapas();
	}
}
