package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import weareSupports.*;

public class Options extends JFrame{
	
	JComboBox<String> songs;
	JButton bReturn, bOk,bMute,bLead;
	JSlider slider;
	
	static StandardAudio song = null;
	
	Font default_font = new Font("Verdana",Font.BOLD,14);
	Color text_color = Color.decode("#222222");
	Color background_color = Color.decode("#cccccc");
	private ArrayList<String> names,path;
	
	
	public void cargaficRec (File dir, int nivel,ArrayList<String> names,ArrayList<String> path) {
		if (dir.isDirectory())
			for (File f : dir.listFiles()) {	
				if(f.getName().toLowerCase().endsWith("mp3")||f.getName().toLowerCase().endsWith("m4a")) { 
					names.add(f.getName());
					path.add(f.getPath());
				}	
				cargaficRec( f, nivel+1,names,path);
			}

	
	}
	private File ultimaCarpeta = null;
	
	public Options() {
		
		names = new ArrayList<String>();
		path = new ArrayList<String>();
		
				JFileChooser f = new JFileChooser();
				f.setDialogTitle("Selecciona la carpeta con las canciones que te gustaria escuchar ingame C:");
				if (ultimaCarpeta!=null) 
					f.setCurrentDirectory(ultimaCarpeta);
				f.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
				int cod = f.showOpenDialog( this );
				if (cod==JFileChooser.APPROVE_OPTION) {
					File dir = f.getSelectedFile();
					cargaficRec(dir,0,names,path);
					}else {
						JOptionPane.showMessageDialog(this, "Al no poner una ruta, se te cargaran las canciones por defecto");
						cargaficRec( new File(Options.class.getProtectionDomain().getCodeSource().getLocation().getPath()),0,names,path);
						
					}
		
		
		slider = new JSlider();
		JPanel mainP = new JPanel();
		mainP.setLayout(new GridLayout(3,1));	
		JPanel secP = new JPanel(new GridLayout());	
		this.setContentPane(mainP);
		
		bReturn= new JButton("BACK");
		bOk= new JButton("PLAY");
		songs= new JComboBox<String>();
		bMute = new JButton("STOP");
		bLead = new JButton("LEADERBOARD");
		
		
		
		for (String s : names) {
			songs.addItem(s);
		}
		
		songs.setFont(new Font("Agent", Font.BOLD, 50));	
		mainP.add(songs);
		secP.add(bOk); 
		secP.add(bMute);
		secP.add(bReturn);
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
					bOk.setEnabled(true);
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
				
				
				for (String s : names) {
					if(songs.getSelectedItem().equals(s)) {
						
						for (String p: path) {
							if(p.endsWith(s)) {
								song= new StandardAudio(p, false);
							}
						}	
					}
				}
				
			
				if(song!=null) {
					song.adjustFXVolume(+0.8);
					song.FXPlay();
					bOk.setEnabled(false);
				}
			}
		});
		
		bLead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
