package BibliTeX;

/**
 * Representa a transforma��o respons�vel por deixar todo o texto em letras mai�sculas.
 * 
 * @author Andreza Santana.
 *
 */
public class UpperCase implements AlgoritmoTransformacao{

	/**
	 * Representa o nome da transforma��o.
	 */
	private String nome;
	
	public UpperCase() {
		this.nome = "UpperCase";
	}
	
	@Override
	public String transforma(String txtOriginal) {
		if (txtOriginal == null) {
			throw new NullPointerException("TEXTO NULO!");
		} else if (txtOriginal.isBlank()) {
			throw new IllegalArgumentException("TEXTO VAZIO!");
		}
		return txtOriginal.toUpperCase();
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
