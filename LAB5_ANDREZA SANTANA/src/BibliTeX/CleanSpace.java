package BibliTeX;

/**
 * Representa a transforma��o CleanSpace, respons�vel por remover espa�os em branco.
 * 
 * @author Andreza Santana
 *
 */
public class CleanSpace implements AlgoritmoTransformacao{

	/**
	 * Representa o nome da transforma��o.
	 */
	private String nome;
	
	/**
	 * Constr�i/Inicializa a trasnforma��o.
	 */
	public CleanSpace() {
		this.nome = "CleanSpace";
	}
	
	@Override
	public String transforma(String txtOriginal) {
		if (txtOriginal == null) {
			throw new NullPointerException("TEXTO NULO!");
		} else if (txtOriginal.isBlank()) {
			throw new IllegalArgumentException("TEXTO VAZIO!");
		}
		
		String resultado = txtOriginal.replace(" ", "");
		return resultado;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
