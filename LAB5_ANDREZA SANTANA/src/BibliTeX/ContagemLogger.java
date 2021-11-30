package BibliTeX;

/**
 * Representa a classe que ao ter seu toString invocado, retorna cada método invocado 
 * pelo menos uma vez e quantas quantas foram as ocorrencias dessa invocação.
 * 
 * @author Andreza Santana.
 *
 */
public class ContagemLogger implements Logger{

	private int contabilizaTransforma;
	private int contabilizaContaTransformacao;
	private int contabilizaHistorico;

	public ContagemLogger() {
		this.contabilizaTransforma = 0;
		this.contabilizaHistorico = 0;
		this.contabilizaContaTransformacao = 0;
	}
	
	@Override
	public String registroLogger(String tipoTransformacao, String metodo) {
		if(metodo.equals("transforma")) {
			this.contabilizaTransforma += 1;
		}else if (metodo.equals("contaTransformacao")) {
			this.contabilizaContaTransformacao += 1;
		}else if(metodo.equals("historico")) {
			this.contabilizaHistorico += 1;
		}
		return null;
	}
	
	public String toString() {
		return "transforma - " + this.contabilizaTransforma + "\n" 
				+ "contaTransformacao - " + this.contabilizaContaTransformacao
				+ "historico - " + this.contabilizaHistorico;
	}
	
}
