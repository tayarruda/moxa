package ifrn.nc.moxa.negocio;
import java.util.Date;

public class Requisicao {

	private Date dataR;
	private int id;
	
	
	public Requisicao(Date dataR, int id) {
		super();
		this.dataR = dataR;
		this.id = id;
	}
	
	
	public Requisicao(Date dataR) {
		super();
		this.dataR = dataR;
	}


	public Date getDataR() {
		return dataR;
	}


	public int getId() {
		return id;
	}
	
	
	
}
