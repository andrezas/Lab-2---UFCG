package BibliTeX;

/**
 * Representa a interface que registra operações realizadas no sistema 
 * de transformações de texto quando invocado.
 * 
 * @author Andreza Santana.
 *
 */
public interface Logger {
	
	/**
	 * Método que registra as operações realizadas.
	 * 
	 * @param tipoTransformacao O nome da transformação utilizada em uma operação.
	 * @param metodo O método utilizado em uma operação.
	 * 
	 * @return A representação String dos registros realizados.
	 */
	public String registroLogger(String tipoTransformacao, String metodo);

}
