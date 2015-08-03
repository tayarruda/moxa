package ifrn.nc.moxa.negocio;

import java.util.ArrayList;
import java.util.List;

public class Produto {

	private int id;
	private String nome;
	private int quantidade;
	private double preco;
	private String fornecedor;
	private String categoria;
	
	private List<Entrada> entradas;
	
	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Produto() {
		super();
		
	}

	public Produto(int id, String nome, int quantidade, double preco,
			String fornecedor, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.entradas = new ArrayList<>();

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
	