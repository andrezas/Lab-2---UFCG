package lab2;

/**
* Representa��o da rotina de descanso do aluno.
* 
* @author Andreza Santana
*/
public class Descanso {
	
	/**
	* Quantidade de horas de descansadas pelo aluno.
	*/
	private int horasDescanso = 0;
	
	/**
	* N�mero de semanas referentes �s horas descansadas pelo aluno.
	* P.S. as horas descansadas s�o representadas pelo atributo anterior.
	*/
	private int numSemanas = 0;
	
	/**
	 * Define as horas de descanso do aluno de acordo com o valor do par�metro. 
	 *
	 * @return n�o tem retorno.
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}
	
	/**
	 * Define as o n�mero de semanas descansadas pelo aluno de acordo com 
	 * o valor do par�metro. 
	 * 
	 * @return n�o tem retorno.
	 */
	public void defineNumeroSemanas(int valor) {
		this.numSemanas = valor;
	}
	
	/**
	 * Define o status de descanso do aluno, ou seja, se o aluno pode ser considerado
	 * cansado ou descansado. Esse status � determinado a partir da divis�o das horas
	 * descansadas (horasDescanso) pelo n�mero de semanas (numSemanas), sendo ambas 
	 * fornecidas pelo usu�rio.
	 * 
	 * @return a representa��o em string do status geral do aluno na disciplina, ou seja,
	 * a situa��o da rotina de descanso do aluno. 
	 */
	public String getStatusGeral() {
		if (horasDescanso == 0 || numSemanas == 0) {
			return "cansado";
		}else {
			double nivelDescanso = horasDescanso/numSemanas;
			if (nivelDescanso < 26) {
				return "cansado";
			}else {
				return "descansado";
			}
		}
		
	}
}
