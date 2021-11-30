package BibliTeX;

/**
 * Representa a interface que ser� implementada pelos tipos de transforma��es. 
 * 
 * @author Andreza Santana
 *
 */
public interface AlgoritmoTransformacao {

	/**
	 * M�todo que efetua uma transforma��o a partir de um texto.
	 * 
	 * @param original O texto original a ser transformado.
	 * @return O texto transformado.
	 */
	public String transforma(String original);
	
	/**
	 * M�todo que retorna o nome de uma transforma��o.
	 * 
	 * @return O nome da transforma��o.
	 */
	public String getNome();
}
