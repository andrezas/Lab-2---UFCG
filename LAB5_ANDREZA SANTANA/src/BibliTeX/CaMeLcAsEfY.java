package BibliTeX;

/**
 * Representa a transforma��o CamelCase.
 * 
 * @author Andreza Santana
 *
 */
public class CaMeLcAsEfY implements AlgoritmoTransformacao{
	
	/**
	 * Representa o nome da transforma��o.
	 */
	private String nome;
	
	/**
	 * Constr�i/Inicializa a transforma��o.
	 */
	public CaMeLcAsEfY() {
		this.nome = "CaMeLcAsEfY";
		}

	@Override
	public String transforma(String txtOriginal) {
		if (txtOriginal == null) {
			throw new NullPointerException("TEXTO NULO!");
		} else if (txtOriginal.isBlank()) {
			throw new IllegalArgumentException("TEXTO VAZIO!");
		}
		
		String[] caracteres = txtOriginal.split("");
		String resultado = "";
		for (int i = 0; i < txtOriginal.length(); i++) {
			if(i % 2 == 0) {
				resultado += caracteres[i].toUpperCase();
			}else {
				resultado += caracteres[i].toLowerCase();
			}
		}
		return resultado;
	}

	@Override
	public String getNome() {
		return this.nome;
	}


	
	
	

}
