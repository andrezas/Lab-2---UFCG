package BibliTeX;

/**
 * Representa a transformação CleanSpace, responsável por remover espaços em branco.
 * 
 * @author Andreza Santana
 *
 */
public class CleanSpace implements AlgoritmoTransformacao{

	/**
	 * Representa o nome da transformação.
	 */
	private String nome;
	
	/**
	 * Constrói/Inicializa a trasnformação.
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
