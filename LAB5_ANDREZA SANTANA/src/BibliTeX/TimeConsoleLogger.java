package BibliTeX;

/**
 * Representa a classe que imprime o momento de execu��o de um m�todo em rela��o 
 * ao tempo de cria��o do objeto TimeConsoleLogger.
 * 
 * @author Andreza Santana.
 *
 */
public class TimeConsoleLogger implements Logger{
	/**
	 * Representa o tempo de cria��o do do objeto.
	 */	
	private long tempoCriacaoObj;
	
	public TimeConsoleLogger() {
		this.tempoCriacaoObj = System.currentTimeMillis();
	}
	
	@Override
	public String registroLogger(String tipoTransformacao, String metodo) {
		long time = this.tempoCriacaoObj - System.currentTimeMillis();
		if (metodo.equals("transforma")) {
			return "[transforma - " + time + "ms]"  + tipoTransformacao + "\n";
		} else if(metodo.equals("contaTransformacao")) {
			return "[contaTransformacao - " + time + "ms]" + "\n";
		} else if(metodo.equals(metodo)) {
			return "[historico - " + time + "ms] ";
		}
		return null;
	}

}
