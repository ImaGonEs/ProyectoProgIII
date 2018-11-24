package ventanas;

import javax.swing.*;
import javax.swing.border.*;

import weareSupports.JLabelGraficoAjustado;

import javax.accessibility.*;
 
import java.awt.*;
import java.awt.event.*;
 
/* 
 * LayeredPaneDemo.java requires
 * images/dukeWaveRed.gif. 
 */
public class EjemploJLayeredPane {

	/**
	 * Crea una ventana con un JLayeredPane, le pone una imagen de fondo y una
	 * etiqueta encima.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// La ventana y el layered pane.
		JFrame v = new JFrame("Ejemplo de JLayeredPane");
		JLayeredPane layered = new JLayeredPane();

		// La imagen de fondo metida en un JLabel, dandole el
		// tamano adecuado.
		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon("su.gif");
		fondo.setIcon(imagen);
		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

		// La etiqueta que ira encima de la imagen.
		JLabelGraficoAjustado primerPlano = new JLabelGraficoAjustado("S32",100,100);
		primerPlano.setSize(100, 100);
		primerPlano.setBounds(400, 400, 100,100);

		// Se mete imagen y etiqueta en el JLayeredPane.
		// Debe ser Integer, no vale int.
		// Los Integer bajos corresponden a capas del fondo.
		layered.add(fondo, new Integer(1));
		layered.add(primerPlano, new Integer(2));

		// Se visualiza todo.
		v.getContentPane().add(layered);
		v.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		v.setVisible(true);
	}

}
