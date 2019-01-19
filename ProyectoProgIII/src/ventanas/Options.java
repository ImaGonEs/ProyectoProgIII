package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import weareSupports.*;

public class Options extends JFrame{
	
	JComboBox<String> songs;
	JButton bReturn, bOk,bMute,bLead;
	JSlider slider;
	
	static StandardAudio song;
	
	Font default_font = new Font("Verdana",Font.BOLD,14);
	Color text_color = Color.decode("#222222");
	Color background_color = Color.decode("#cccccc");

	
	public Options() {
		
	
		slider = new JSlider();
		JPanel mainP = new JPanel();
		mainP.setLayout(new GridLayout(3,1));
		
		JPanel secP = new JPanel(new GridLayout());
		
		JLabelGraficoAjustado fondo = new JLabelGraficoAjustado("", 700, 500);
		
		this.setContentPane(mainP);
		
		bReturn= new JButton("BACK");
		bOk= new JButton("PLAY");
		songs= new JComboBox<String>();
		bMute = new JButton("STOP");
		bLead = new JButton("LEADERBOARD");
		
		
		songs.addItem("PLAYLIST 1");
		songs.addItem("PLAYLIST 2");
		
		 
		 
		songs.setFont(new Font("Agent", Font.BOLD, 50));
		

		
		mainP.add(songs);
		
		
		secP.add(bOk); 
		secP.add(bMute);
		secP.add(bReturn);
		//mainP.add(slider);
		
		
		
		mainP.add(secP);
		mainP.add(bLead);
		
		CambiarBoton(bOk);
		CambiarBoton(bMute);
		CambiarBoton(bReturn);
		CambiarBoton(bLead);
		
		
		bMute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					song.FXStop();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		bReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		bOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (songs.getSelectedItem()=="PLAYLIST 1") {
					
					try {
						song.FXStop();
					} catch (Exception e2) {
						
					}
					song= new StandardAudio("mixRJ.mp3", false);
					
					
	
					song.adjustFXVolume(+0.8);
					
					song.FXPlay();
				}else if (songs.getSelectedItem()=="PLAYLIST 2") {
					try {
						song.FXStop();
					} catch (Exception e2) {
						
					}
					song= new StandardAudio("mixWeeb.mp3", false);
					
					song.adjustFXVolume(-0.6);
					song.FXPlay();
					
					
				}

				
			}
		});
		
		bLead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//JOptionPane.showInputDialog("NEW PASSWORD");
				//String respuesta = JOptionPane.showInputDialog("NEW PASSWORD",JOptionPane.WARNING_MESSAGE);
				
				new TablaStats();
			}
		});
			
		setTitle("OPTIONS");	
		setSize(700,200);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);	
	}

	public static void main(String[] args) {
		
		try { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } catch(Exception ignored){}
		
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      
		     new Options();
		    }
		  });
		
	}
	public void CambiarBoton (JButton b) {
		
		Border border = BorderFactory.createLineBorder(new Color(108,79,167),3);
		b.setFocusPainted(false);
		b.setBorder(border);
		b.setForeground(text_color);
		b.setBackground(background_color);
		b.setFont(default_font);
		b.setOpaque(true);

	}

	public JComboBox<String> getSongs() {
		return songs;
	}

	public void setSongs(JComboBox<String> songs) {
		this.songs = songs;
	}

	public JButton getbOk() {
		return bOk;
	}

	public void setbOk(JButton bOk) {
		this.bOk = bOk;
	}

	public JButton getbMute() {
		return bMute;
	}

	public void setbMute(JButton bMute) {
		this.bMute = bMute;
	}

	public StandardAudio getSong() {
		return song;
	}

	public void setSong(StandardAudio song) {
		this.song = song;
	}
	
	
}
