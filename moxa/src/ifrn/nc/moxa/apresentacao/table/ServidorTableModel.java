package ifrn.nc.moxa.apresentacao.table;

import ifrn.nc.moxa.negocio.Servidor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ServidorTableModel extends AbstractTableModel{
     
    private List<Servidor> dados;
    private String[] colunas = {"Código" , "Nome", "Matrícula", "Classificação" };
     
    public ServidorTableModel(List<Servidor> dados){
        this.dados = dados;
    }
     
    public void addRow(Servidor e){
        this.dados.add(e);
        this.fireTableDataChanged();
    }
 
    public String getColumnName(int num){
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
        switch(coluna){
            case 0: return dados.get(linha).getId();
            case 1: return dados.get(linha).getNome();
            case 2: return dados.get(linha).getMatricula();
            case 3: return dados.get(linha).getClassificacao();
        }  
        return null;
    }
   

	public void removeServidor(int linha) {
		dados.remove(linha); 
    	fireTableRowsDeleted(linha, linha);
	}

	public Servidor getServidor(int linha){
	return dados.get(linha);
	}
    	
    
}