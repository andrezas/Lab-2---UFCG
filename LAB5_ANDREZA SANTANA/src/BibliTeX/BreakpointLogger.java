package BibliTeX;

/**
 * Exibe uma mensagem quando um método específico for executado.
 * 
 * @author Andreza Santana
 *
 */
public class BreakpointLogger implements Logger{
	
	public BreakpointLogger() {
		
	}

	@Override
	public String registroLogger(String tipoTransformacao, String metodo) {
		if(metodo.equals("transforma")) {
			return "[INVOCADO - transforma]" + "\n";
		}else if (metodo.equals("contaTransformacao")) {
			return "[INVOCADO - contaTransformacao]" + "\n";
		}else if(metodo.equals("historico")) {
			return "[INVOCADO - historico]" + "\n";
		}
		return null;
	}
	

}
