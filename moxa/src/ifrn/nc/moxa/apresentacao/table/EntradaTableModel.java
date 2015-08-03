package ifrn.nc.moxa.apresentacao.table;

import ifrn.nc.moxa.negocio.Entrada;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EntradaTableModel extends AbstractTableModel {

	private List<Entrada> dados;
	private String[] colunas = { "Código", "Data De Registro", "Quantidade",
			"Servidor" };

	public EntradaTableModel(List<Entrada> dados) {
		this.dados = dados;
	}

	public void addRow(Entrada e) {
		this.dados.add(e);
		this.fireTableDataChanged();
	}

	public String getColumnName(int num) {
		return this.colunas[num];
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getId();
		case 1:
			return dados.get(linha).getDataDeRegistro();
		case 2:
			return dados.get(linha).getQuantidade();
		case 3:
			return dados.get(linha).getRegistrador().getNome();
		}
		return null;
	}

}
