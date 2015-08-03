package ifrn.nc.moxa.apresentacao;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TesteImagem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteImagem frame = new TesteImagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteImagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
	}
	
	public void paintComponent (Graphics g)
	{
		Image img = new ImageIcon("C:\\Users\\taynarruda\\Dropbox\\ifrn\\banco de dados\\Projeto\\A Logo Lari )\\moxapixels.png").getImage();
	    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	    //super.paintComponents(g);
	}
	

}
