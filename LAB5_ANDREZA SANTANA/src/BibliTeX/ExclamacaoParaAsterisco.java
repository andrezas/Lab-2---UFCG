package BibliTeX;

/**
 * Representa a nova transforma��o. Essa nova transforma��o � respons�vel por 
 * trocar pontos de exclama��o(!) por asterisco (*). 
 * 
 * @author Andreza Santana
 *
 */
public class ExclamacaoParaAsterisco implements AlgoritmoTransformacao{

	/**
	 * Representa o nome da transforma��o.
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
