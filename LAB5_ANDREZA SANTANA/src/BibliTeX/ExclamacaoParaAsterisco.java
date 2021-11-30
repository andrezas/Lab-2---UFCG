package BibliTeX;

/**
 * Representa a nova transformação. Essa nova transformação é responsável por 
 * trocar pontos de exclamação(!) por asterisco (*). 
 * 
 * @author Andreza Santana
 *
 */
public class ExclamacaoParaAsterisco implements AlgoritmoTransformacao{

	/**
	 * Representa o nome da transformação.
	 */
	private String nome;
	
	public ExclamacaoParaAsterisco() {
		this.nome = "ExclamacaoParaAsterisco";
	}
	
	@Override
	public String transforma(String txtOriginal) {
		if (txtOriginal == null) {
			throw new NullPointerException("TEXTO NULO!");
		} else if (txtOriginal.isBlank()) {
			throw new IllegalArgumentException("TEXTO VAZIO!");
		}
		String resultado = txtOriginal.replaceAll("!", "*");
		return resultado;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
