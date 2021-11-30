package BibliTeX;

/**
 * Representa a classe que imprime o método e parâmetro passado.
 * 
 * @author Andreza Santana.
 *
 */
public class ConsoleLogger implements Logger{
	
	public ConsoleLogger() {
		
	}

	@Override
	public String registroLogger(String tipoTransformacao, String metodo) {
		if (metodo.equals("transforma")) {
			return "[transforma] " + tipoTransformacao + "\n";
		} else if(metodo.equals("contaTransformacao")) {
			return "[contaTransformacao] " + "\n";
		} else if(metodo.equals(metodo)) {
			return "[historico] ";
		}
		return null;
	}

}
