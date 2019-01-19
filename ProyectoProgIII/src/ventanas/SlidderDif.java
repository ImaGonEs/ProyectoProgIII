package ventanas;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import Datos.Boot;
import weareSupports.JLabelGraficoAjustado;
import weareSupports.StandardAudio;

public class SlidderDif extends JFrame{

	
	JLabelGraficoAjustado background,usuario,pass,btn;
	JPanel panel;
	JLabelGraficoAjustado title;
	StandardAudio clip;
	private int w = 1000,h=600;
	static final int nor=0;
	
	static final int mododiablo=6;
	private JButton aceptar = new JButton("Aceptar");
	
	private JSlider dif = new JSlider(JSlider.HORIZONTAL,nor,mododiablo,3);
	
	@SuppressWarnings("unchecked")
	public SlidderDif(String mapa) {
		

				
		JFrame frame = this;
		
		w = 600;
		h = 150;
				
		Container cp = this.getContentPane();
		panel = new JPanel(new GridLayout(3, 1));

			
		background = new JLabelGraficoAjustado("forest", w, (int) ((int) h*1.5)); //1000,900
	
		
		@SuppressWarnings("rawtypes")
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( 0 ), new JLabel("Easy") );
		labelTable.put( new Integer( 3 ), new JLabel("Normal") );
		labelTable.put( new Integer( 6 ), new JLabel("Hard") );
		dif.setLabelTable( labelTable );

		dif.setPaintLabels(true);
		JPanel panelar = new JPanel();
		panelar.add(new JLabel("Dificultad"));
		panel.add(panelar);
		panel.add(dif);
		
		
	JPanel panelab = new JPanel();
	panelab.add(aceptar);
		panel.add(panelab);

		cp.add(panel);

	aceptar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Thread boot = new Thread (new Runnable() {		
				@Override
				public void run() {
					// TODO Auto-generated method stub			
					new Boot(dif.getValue(),mapa);
				}
			});	
			boot.start();		
			frame.dispose();	
		}
	});
		
		setSize(w,h);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	
	}
	


}
