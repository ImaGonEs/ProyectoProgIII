package ventanas;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import weareSupports.JLabelGraficoAjustado;


public class MainMenu extends JFrame{
	
	Font default_font = new Font("Verdana",Font.BOLD,14);
	Color text_color = Color.decode("#222222");
	Color background_color = Color.decode("#ccddccc");
	Border thickBorder = new LineBorder(Color.pink, 5);
	
	public MainMenu() {
		
		setSize(1280,720);
		setVisible(true);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		Container cp = this.getContentPane();
		
		JButton bPlay = new JButton("PLAY");
		JButton bSummon = new JButton("SUMMON");
		JButton bCharacters = new JButton("CHARACTERS");
		JButton bOptions = new JButton("OPTIONS");
		
		
		JLabel title = new JLabel("OOOOO");
		
		Font fontTitulo = new Font("Synchro LET", Font.BOLD, 40);
		try {
		    //create the font to use. Specify the size!
		    fontTitulo = Font.createFont(Font.TRUETYPE_FONT, new File("DepredationPixie.ttf")).deriveFont(48f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("DepredationPixie.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
	
		title.setFont(fontTitulo);
		
		title.setForeground(Color.pink
				);
		
		title.setBounds((this.getWidth()/2) - 100 , (this.getHeight()/5)-150, 200, 200);
		bPlay.setBounds((this.getWidth()/4) - 400 + (this.getWidth()/4), (this.getHeight()/5 *2), 300, 50);
		bSummon.setBounds((this.getWidth()/4*3) - 250 , (this.getHeight()/5 *2), 300, 50);
		bCharacters.setBounds((this.getWidth()/4) - 400 + (this.getWidth()/4), (this.getHeight()/5 *4) - 100, 300,50);
		bOptions.setBounds((this.getWidth()/4*3) - 250, (this.getHeight()/5 *4)-100, 300,50);
		
		//System.out.println(this.getHeight()/6);
		
		JLabelGraficoAjustado background = new JLabelGraficoAjustado("summer.png", 1280,720);
		
		cp.add(background);
		
		
		background.add(bPlay);
		background.add(bCharacters);
		background.add(bSummon);
		background.add(bOptions);
		background.add(title);
		
		ChangeButton(bPlay);
		ChangeButton(bCharacters);
		ChangeButton(bSummon);
		ChangeButton(bOptions);
	
		pack();
		
	}
	
	public void ChangeButton (JButton b) {

		
    	b.setFocusPainted(false);
    	b.setBorder(thickBorder);
    	b.setForeground(text_color);
    	b.setBackground(background_color);
    	b.setFont(default_font);
    	b.setOpaque(true);
   
   }


	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
	}
}
