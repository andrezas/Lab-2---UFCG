package BibliTeX;

/**
 * Representa a interface que será implementada pelos tipos de transformações. 
 * 
 * @author Andreza Santana
 *
 */
public interface AlgoritmoTransformacao {

	/**
	 * Método que efetua uma transformação a partir de um texto.
	 * 
	 * @param original O texto original a ser transformado.
	 * @return O texto transformado.
	 */
	public String transforma(String original);
	
	/**
	 * Método que retorna o nome de uma transformação.
	 * 
	 * @return O nome da transformação.
	 */
	public String getNome();
}
