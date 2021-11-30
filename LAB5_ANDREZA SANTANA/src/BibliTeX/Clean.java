package BibliTeX; 

/**
 * Representa a transforma��o Clean, respons�vel por remover pontua��o.
 * 
 * @author Andreza Santana
 *
 */
public class Clean implements AlgoritmoTransformacao {

	/**
	 * Representa o nome da transforma��o.
	 */
	private String nome;
	
	/**
	 * Constr�i/Inicializa a transforma��o.
	 */
	public Clean() {
		this.nome = "Clean";
	}
	
	@Override
	public String transforma(String txtOriginal) {
		if (txtOriginal == null) {
			throw new NullPointerException("TEXTO NULO!");
		} else if (txtOriginal.isBlank()) {
			throw new IllegalArgumentException("TEXTO VAZIO!");
		}
		String resultado = txtOriginal.replaceAll("\\p{Punct}", "");
		return resultado;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
