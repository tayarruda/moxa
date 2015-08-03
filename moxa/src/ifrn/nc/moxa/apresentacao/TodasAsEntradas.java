package ifrn.nc.moxa.apresentacao;

import ifrn.nc.moxa.apresentacao.table.EntradaTableModel;
import ifrn.nc.moxa.negocio.Entrada;
import ifrn.nc.moxa.persistencia.EntradaDAO;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TodasAsEntradas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TodasAsEntradas dialog = new TodasAsEntradas(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TodasAsEntradas(Frame dono) {
		super(dono, true);
		setResizable(false);
		setBounds(100, 100, 443, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				EntradaDAO entDAO = new EntradaDAO();
				List<Entrada> entrada = entDAO.listarTodas();
				table.setModel(new EntradaTableModel(entrada));

				
				scrollPane.setViewportView(table);
			}
		}
	}

}
