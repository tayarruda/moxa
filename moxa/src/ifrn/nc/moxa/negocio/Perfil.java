package ifrn.nc.moxa.negocio;

/**
 * Classe responsável por caracterizar os privilégios que um usuários terá ao
 * acessar esta aplicação.
 * 
 * @author fpenha
 *
 */
public class Perfil {

	// valor que irá servir para verificação de autilização
	private static final int CHAVE_AUTORIZACAO = 1;

	// Perfis TODO refatorar com enum
	public static final int SERVIDOR_ADM = 0;
	public static final int ESTAGIARIO = 1;

	// Funcionaliades TODO refatorar para enum
	public static final int CADASTRAR_SERVIDOR = 0;

	private int[] privilegios;

	public Perfil(int perfil) {

		switch (perfil) {
		case 0:
			privilegios = {1,1,1};
			break;
		case 1:
			privilegios = {0,1,1};
			break;
		default:
			privilegios = {0,0,0};

		}
	}

	/**
	 * Verifica se o perfil em questão tem autorização para uma determinada 
	 * funcionalidade
	 * 
	 * @param funcionalidade {@code int} indicando a funcionalidade desejada
	 * @return {@code true} caso tenha autorização, {@code false} caso contrário 
	 */
	public boolean temPrivilegio(int funcionalidade) {
		return CHAVE_AUTORIZACAO == privilegios[funcionalidade];
	}
}
