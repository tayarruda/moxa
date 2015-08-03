package ifrn.nc.moxa.apresentacao;

import ifrn.nc.moxa.apresentacao.table.ServidorTableModel;
import ifrn.nc.moxa.negocio.Entrada;
import ifrn.nc.moxa.negocio.Servidor;
import ifrn.nc.moxa.persistencia.EntradaDAO;
import ifrn.nc.moxa.persistencia.ServidorDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class AddEntrada extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField tfData;
	private JTextField tfQuantidade;
	private JTextField tfProduto;
	private JButton okButton;
	private JLabel lblServidor;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddEntrada dialog = new AddEntrada(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddEntrada(JDialog dono, final Servidor servidor) {
		super(dono, true);
		setResizable(false);
		setBounds(100, 100, 252, 243);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			{
				okButton = new JButton("Adicionar Entrada");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Entrada entrada = new Entrada();
						Date dataDeRegistro = new Date(entrada.getDataDeRegistro()
								.getTime());
						entrada.setDataDeRegistro(dataDeRegistro);
						entrada.setRegistrador(servidor);
						
						entrada.setQuantidade(Integer.parseInt(tfQuantidade
								.getText()));
						
						EntradaDAO entDAO = new EntradaDAO();
						entDAO.add(entrada);
						JOptionPane.showMessageDialog(null, "Entrada de "
								+ servidor.getNome()
								+ " inserida com sucesso! ");

						limparCampos(tfQuantidade, tfData);
						dispose();

					}

					private void limparCampos(JTextField... campos) {
						for (JTextField campo : campos) {
							campo.setText("");
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
		}
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_buttonPane.createSequentialGroup().addGap(44)
						.addComponent(okButton)
						.addContainerGap(206, Short.MAX_VALUE)));
		gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_buttonPane
						.createSequentialGroup()
						.addComponent(okButton)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		buttonPane.setLayout(gl_buttonPane);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																contentPanel,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(10)
																		.addComponent(
																				buttonPane,
																				GroupLayout.PREFERRED_SIZE,
																				235,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE,
								163, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE,
								29, Short.MAX_VALUE).addContainerGap()));
		JLabel lblData = new JLabel("Data");
		JLabel lblQuantidade = new JLabel("Quantidade");
		JLabel lblProduto = new JLabel("Produto");
		JPanel panel = new JPanel();

		lblServidor = new JLabel("Servidor");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPanel
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblProduto)
										.addComponent(lblQuantidade)
										.addComponent(lblData)
										.addComponent(lblServidor))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.TRAILING,
																gl_contentPanel
																		.createSequentialGroup()
																		.addComponent(
																				lblServidor)
																		.addGap(18)
																		.addComponent(
																				lblData)
																		.addGap(18)
																		.addComponent(
																				lblQuantidade)
																		.addGap(18)
																		.addComponent(
																				lblProduto)
																		.addContainerGap()))));
		tfData = new JTextField();
		tfData.setColumns(10);
		tfQuantidade = new JTextField();
		tfQuantidade.setColumns(10);
		tfProduto = new JTextField();
		tfProduto.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText(servidor.getNome());

		textField_2.setColumns(10);
		

		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(tfProduto,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfQuantidade,
												GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfData,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_2,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addContainerGap(34, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addContainerGap(18, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tfData, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tfQuantidade, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tfProduto, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}

	

}
