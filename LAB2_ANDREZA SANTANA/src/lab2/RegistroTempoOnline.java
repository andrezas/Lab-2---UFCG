package lab2;

/**
* Representação da rotina de estudo do aluno.
* 
* @author Andreza Santana
*/
public class RegistroTempoOnline {
	
	/**
	* Quantidade de horas online que o aluno dedica ao estudo de uma disciplina
	* específica.
	*/
	private int horasDedicadas = 0;
	
	/**
	* Nome da disciplina referente às horas de dedicação do aluno.
	*/
	private String disciplina;
	
	/** 
	 * Tempo de dedição esperado para o estudo de uma disciplina especificada 
	 * pelo aluno. Caso o aluno não informe o valor do tempo, ele será 120 por
	 * padrão.
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
	 * da disciplina passada no parâmetro anterior.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.disciplina = nomeDisciplina;
		this.tempoEsperado = tempoOnlineEsperado;
		
	}
	
	/**
	 * Define as horas de dedicação do aluno para o estudo da disciplina.
	 *  
	 * @return sem retorno.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.horasDedicadas += tempo;
	}
	
	/**
	 * Verifica se o aluno antigiu o tempo de dedicação esperado para o estudo
	 * da disciplina. Essa verificação é feita a partir da comparação entre o
	 * o tempo de dedicação esperado e o tempo dedicado pelo aluno.
	 * 
	 * @return retorna true caso o aluno tenha atingido a meta de tmepo online
	 * e false caso contrário.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (horasDedicadas < tempoEsperado) {
			return false;
		}else{
			return true;
		}
	}

	/** 
	 * Retorna uma representação String, ou seja, textual do objeto criado.
	 * 
	 *  @return a representação em string das horas que o aluno dedicou ao estudo
	 *  da disciplina e as horas de dedicação.
	 */
	public String toString() {
		return this.disciplina + " " + this.horasDedicadas + "/" + this.tempoEsperado;
	}

}
