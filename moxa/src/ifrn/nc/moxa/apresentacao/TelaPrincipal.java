package ifrn.nc.moxa.apresentacao;

import ifrn.nc.moxa.negocio.Servidor;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("moxa");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnServidor = new JMenu("Cadastrar");
		menuBar.add(mnServidor);

		JMenuItem mntmServidor = new JMenuItem("Servidor");
		mntmServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroServidor dialog = new CadastroServidor(frame);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

			}
		});
		mnServidor.add(mntmServidor);
		

		JMenu mnPesquisa = new JMenu("Pesquisa");
		menuBar.add(mnPesquisa);

		JMenuItem mntmTodosOsServidores = new JMenuItem("Todos os Servidores");
		mntmTodosOsServidores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodosOsServidores dialog = new TodosOsServidores(frame);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnPesquisa.add(mntmTodosOsServidores);

		JMenuItem mntmTodasAsEntradas = new JMenuItem("Todas as Entradas");
		mntmTodasAsEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TodasAsEntradas dialog = new TodasAsEntradas(frame);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnPesquisa.add(mntmTodasAsEntradas);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 419, 0 };
		gridBagLayout.rowHeights = new int[] { 188, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		label.setIcon(new ImageIcon(
				"C:\\Users\\taynarruda\\Dropbox\\ifrn\\banco de dados\\Projeto\\A Logo Lari )\\moxapixels.png"));

		frame.getContentPane().add(label, gbc_label);
	}

}
