package ifrn.nc.moxa.negocio;

import java.util.Date;

public class Entrada {

	private int id;
	private Servidor registrador;
	private Date dataDeRegistro;
	private int quantidade;
	private Produto produto;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Servidor getRegistrador() {
		return registrador;
	}

	public void setRegistrador(Servidor registrador) {
		this.registrador = registrador;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Entrada() {
		super();
		
		setDataDeRegistro(new Date());

	}

	public Entrada(Date dataDeRegistro, int quantidade, Servidor servidor) {
		super();

		if ((new Date()).before(dataDeRegistro)) {
			throw new RuntimeException(
					"Não criar uma entrada de um dia anterior ao atual!!!");
		}

		this.dataDeRegistro = dataDeRegistro;
		this.quantidade = quantidade;
		this.registrador = servidor;
	}

	public void setDataDeRegistro(Date dataDeRegistro) {
		this.dataDeRegistro = dataDeRegistro;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataDeRegistro() {
		return dataDeRegistro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	

}
