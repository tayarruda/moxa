package ifrn.nc.moxa.negocio;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

	private int id;

	private String nome;
	private String matricula;
	private String classificacao;
	private String senha;
	private List<Entrada> entradas;

	public Servidor(int id, String nome, String matricula, String classificacao, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.classificacao = classificacao;
		this.senha = senha;
		this.entradas = new ArrayList<>();
	}


	public Servidor() {
		super();
	}

	public void addEntrada(Entrada entrada) {
		this.entradas.add(entrada);
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

}
