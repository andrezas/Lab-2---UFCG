package BibliTeX; 

/**
 * Representa a transformação Clean, responsável por remover pontuação.
 * 
 * @author Andreza Santana
 *
 */
public class Clean implements AlgoritmoTransformacao {

	/**
	 * Representa o nome da transformação.
	 */
	private String nome;
	
	/**
	 * Constrói/Inicializa a transformação.
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
