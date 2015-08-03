package ifrn.nc.moxa.apresentacao;

import ifrn.nc.moxa.negocio.Servidor;
import ifrn.nc.moxa.persistencia.ServidorDAO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class CadastroServidor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMatricula;
	private JTextField textFieldNome;
	private JComboBox comboBoxClassif;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroServidor dialog = new CadastroServidor(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroServidor(Frame dono) {
		super(dono, true);
		setResizable(false);
		setBounds(100, 100, 328, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setPreferredSize(new Dimension(450, 100));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");

		JLabel lblNome = new JLabel("Nome");

		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o");

		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setDocument(new IntegerDocument());

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);

		comboBoxClassif = new JComboBox();
		comboBoxClassif.setModel(new DefaultComboBoxModel(new String[] { " ",
				"Docente", "Administrativo" }));
		comboBoxClassif.setToolTipText("");

		JLabel lblSenha = new JLabel("Senha");

		passwordField = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel
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
																lblMatrcula)
														.addComponent(
																lblClassificao)
														.addComponent(lblNome)
														.addComponent(lblSenha))
										.addGap(20)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																comboBoxClassif,
																GroupLayout.PREFERRED_SIZE,
																162,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textFieldNome,
																GroupLayout.PREFERRED_SIZE,
																199,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textFieldMatricula,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																passwordField,
																GroupLayout.PREFERRED_SIZE,
																85,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(12, Short.MAX_VALUE)));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblMatrcula)
														.addComponent(
																textFieldMatricula,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldNome,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNome))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboBoxClassif,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblClassificao))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblSenha)
														.addComponent(
																passwordField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(43, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Servidor servidor = new Servidor();
						servidor.setMatricula(textFieldMatricula.getText());
						servidor.setNome(textFieldNome.getText());
						servidor.setClassificacao(comboBoxClassif.getSelectedItem().toString());
						servidor.setSenha(new String(passwordField.getPassword()));

						// fazendo a validação dos dados
						if ((textFieldMatricula.getText().isEmpty())
								|| (textFieldNome.getText().isEmpty())
								|| comboBoxClassif.getSelectedItem().toString()
										.isEmpty()
								|| passwordField.getPassword().toString()
										.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Os campos não podem retornar vazios");
						} else {

							// instanciando a classe ServidorDAO do pacote dao e
							// criando seu objeto dao
							ServidorDAO dao = new ServidorDAO();
							dao.add(servidor);
							JOptionPane.showMessageDialog(null, "Servidor "
									+ textFieldNome.getText()
									+ " inserido com sucesso! ");

							limparCampos(textFieldMatricula, textFieldNome);
							dispose();
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void limparCampos(JTextField... campos) {
		for (JTextField campo : campos) {
			campo.setText("");
		}
	}
}
