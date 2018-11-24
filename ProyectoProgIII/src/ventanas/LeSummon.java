//package ventanas;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import weareSupports.JLabelGraficoAjustado;
//
//public class LeSummon extends JFrame{
//	
//	public JLabelGraficoAjustado g;
//	JButton bSummon;
//	JPanel pSummon;
//	JPanel pOptions, pSup;
//	JLabelGraficoAjustado lGems;
//	JLabel nGems;
//	JLabel lSummon;
//	JLabelGraficoAjustado lChar;
//	ImageIcon IcAnim;
//	
//	public LeSummon() {
//		
//		Dimension d = new Dimension(500, 0);
//		
//		bSummon = new JButton("SUMMON");
//		Dimension d2 = new Dimension(100, 50);
//		bSummon.setPreferredSize(d2);
//		pSummon = new JPanel();
//		pSummon.setPreferredSize(d);
//		pOptions = new JPanel();
//		pOptions.setPreferredSize(d);
//		pSup = new JPanel();
//		lGems = new JLabelGraficoAjustado("gem", 40, 40);
//		lChar = new JLabelGraficoAjustado("S32", 100, 100);
//		
//		
//		nGems = new JLabel("9999");
//		nGems.setForeground(Color.white);
//		lSummon = new JLabel("asdasdsa");
//		
//		IcAnim = new ImageIcon("su.gif");
//		
//		
//		pSup.add(lGems);
//		pSup.add(nGems);
//		
//		pOptions.add(bSummon);
//		
//		
//		pSummon.add(lSummon);
//		
//		
//		
//		
//		Container cp = this.getContentPane();
//		
//		
//		
//		cp.add(pSup, BorderLayout.NORTH);
//		cp.add(pSummon, BorderLayout.WEST);
//		cp.add(pOptions, BorderLayout.EAST);
//		
//		pSup.setBackground(Color.BLACK);
//		pSummon.setBackground(Color.RED);
//		pOptions.setBackground(Color.BLUE);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		setSize(1000,750);
//		setVisible(true);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		Thread t = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				
//			}
//		});
//		
//		bSummon.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				//lSummon = setAnim();
//				lSummon.setIcon(IcAnim);
//				
//				
//
//				lSummon.add(lChar);
//				lSummon.repaint();
//				
//				
//				
//			}
//		});
//		
//	}
//	
//	public void  setAnim(JLabel l) {
//		
//		ImageIcon anim = new ImageIcon("su.gif");
//		l = new JLabel("Image and Text", anim, JLabel.CENTER);
//		
//	}
//	
//	public void reset() {
//		
//		lSummon = null;
//	}
//	/** Returns an ImageIcon, or null if the path was invalid. */
//	protected ImageIcon createImageIcon(String path,
//	                                           String description) {
//	    java.net.URL imgURL = getClass().getResource(path);
//	    if (imgURL != null) {
//	        return new ImageIcon(imgURL, description);
//	    } else {
//	        System.err.println("Couldn't find file: " + path);
//	        return null;
//	    }
//	}
//	public static void main(String[] args) {
//		new LeSummon();
//	}
//	
//
//}
