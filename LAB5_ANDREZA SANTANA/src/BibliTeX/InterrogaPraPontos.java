package BibliTeX;

/**
 * Representa a transformação que realiza a troca de interrogação para o ponto final.
 * 
 * @author Andreza Santana.
 *
 */
public class InterrogaPraPontos implements AlgoritmoTransformacao{

	/**
	 * Representa o nome da transformação.
	 */
	private String nome;
	
	public InterrogaPraPontos() {
		this.nome = "InterrogaPraPontos";
	}
	
	@Override
	public String transforma(String txtOriginal) {
		if (txtOriginal == null) {
			throw new NullPointerException("TEXTO NULO!");
		} else if (txtOriginal.isBlank()) {
			throw new IllegalArgumentException("TEXTO VAZIO!");
		}
		
		String resultado = txtOriginal.replace("?", ".");
		return resultado;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
