package BibliTeX;

/**
 * Representa a interface que registra opera��es realizadas no sistema 
 * de transforma��es de texto quando invocado.
 * 
 * @author Andreza Santana.
 *
 */
public interface Logger {
	
	/**
	 * M�todo que registra as opera��es realizadas.
	 * 
	 * @param tipoTransformacao O nome da transforma��o utilizada em uma opera��o.
	 * @param metodo O m�todo utilizado em uma opera��o.
	 * 
	 * @return A representa��o String dos registros realizados.
	 */
	public String registroLogger(String tipoTransformacao, String metodo);

}
