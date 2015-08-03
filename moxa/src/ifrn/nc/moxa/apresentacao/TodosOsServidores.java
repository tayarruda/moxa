package ifrn.nc.moxa.apresentacao;

import ifrn.nc.moxa.apresentacao.table.ServidorTableModel;
import ifrn.nc.moxa.negocio.Servidor;
import ifrn.nc.moxa.persistencia.ServidorDAO;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TodosOsServidores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TodosOsServidores dialog = new TodosOsServidores(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TodosOsServidores(Frame dono) {
		super(dono, true);
		setResizable(false);
		setBounds(100, 100, 400, 239);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuItemAdd = new JMenuItem("Adicionar Entrada");
		JMenuItem menuItemRemove = new JMenuItem("Excluir");
		
		menuItemAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int linha = table.getSelectedRow();
				
				ServidorTableModel model = (ServidorTableModel) table.getModel();
				Servidor servidor = model.getServidor(linha);
				
				
				AddEntrada Adddialog = new AddEntrada(TodosOsServidores.this, servidor);
				Adddialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Adddialog.setVisible(true);
				
				
			}
		});
		
		menuItemRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				int linha = table.getSelectedRow();
				
				ServidorTableModel model = (ServidorTableModel) table.getModel();
				int id = (int)model.getValueAt(linha, 0);
				
				ServidorDAO serDAO = new ServidorDAO();
				Servidor ser = new Servidor();
				
				ser.setId(id);
				serDAO.deletarPorID(ser);
			
				model.removeServidor(linha);
			}
		});

		popupMenu.add(menuItemAdd);
		popupMenu.add(menuItemRemove);
		table = new JTable();
		table.setComponentPopupMenu(popupMenu);
		table.addMouseListener(new TableMouseListener(table));
		ServidorDAO serDAO = new ServidorDAO();
		List<Servidor> servidor = serDAO.listarTodos();
		table.setModel(new ServidorTableModel(servidor));

		scrollPane.setViewportView(table);
	}

}
