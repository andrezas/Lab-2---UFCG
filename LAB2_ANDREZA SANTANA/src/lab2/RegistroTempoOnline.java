package lab2;

/**
* Representa��o da rotina de estudo do aluno.
* 
* @author Andreza Santana
*/
public class RegistroTempoOnline {
	
	/**
	* Quantidade de horas online que o aluno dedica ao estudo de uma disciplina
	* espec�fica.
	*/
	private int horasDedicadas = 0;
	
	/**
	* Nome da disciplina referente �s horas de dedica��o do aluno.
	*/
	private String disciplina;
	
	/** 
	 * Tempo de dedi��o esperado para o estudo de uma disciplina especificada 
	 * pelo aluno. Caso o aluno n�o informe o valor do tempo, ele ser� 120 por
	 * padr�o.
	 */
	private int tempoEsperado = 120;
	
	/**
	 * Inicia o objeto do tipo RegistroTempoOnline. 
	 * 
	 * @param nomeDisciplina o nome da disciplina que o aluno tem se dedicado.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
	}
	
	/**
	 * Inicia o objeto do tipo RegistroTempoOnline. 
	 * 
	 * @param nomeDisciplina o nome da disciplina que o aluno tem se dedicado.
	 * @param tempoOnlineEsperado o tempo que se espera que o destine ao estudo 
	 * da disciplina passada no par�metro anterior.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.disciplina = nomeDisciplina;
		this.tempoEsperado = tempoOnlineEsperado;
		
	}
	
	/**
	 * Define as horas de dedica��o do aluno para o estudo da disciplina.
	 *  
	 * @return sem retorno.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.horasDedicadas += tempo;
	}
	
	/**
	 * Verifica se o aluno antigiu o tempo de dedica��o esperado para o estudo
	 * da disciplina. Essa verifica��o � feita a partir da compara��o entre o
	 * o tempo de dedica��o esperado e o tempo dedicado pelo aluno.
	 * 
	 * @return retorna true caso o aluno tenha atingido a meta de tmepo online
	 * e false caso contr�rio.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (horasDedicadas < tempoEsperado) {
			return false;
		}else{
			return true;
		}
	}

	/** 
	 * Retorna uma representa��o String, ou seja, textual do objeto criado.
	 * 
	 *  @return a representa��o em string das horas que o aluno dedicou ao estudo
	 *  da disciplina e as horas de dedica��o.
	 */
	public String toString() {
		return this.disciplina + " " + this.horasDedicadas + "/" + this.tempoEsperado;
	}

}
