package lab2;

/**
* Representação da rotina de descanso do aluno.
* 
* @author Andreza Santana
*/
public class Descanso {
	
	/**
	* Quantidade de horas de descansadas pelo aluno.
	*/
	private int horasDescanso = 0;
	
	/**
	* Número de semanas referentes às horas descansadas pelo aluno.
	* P.S. as horas descansadas são representadas pelo atributo anterior.
	*/
	private int numSemanas = 0;
	
	/**
	 * Define as horas de descanso do aluno de acordo com o valor do parâmetro. 
	 *
	 * @return não tem retorno.
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}
	
	/**
	 * Define as o número de semanas descansadas pelo aluno de acordo com 
	 * o valor do parâmetro. 
	 * 
	 * @return não tem retorno.
	 */
	public void defineNumeroSemanas(int valor) {
		this.numSemanas = valor;
	}
	
	/**
	 * Define o status de descanso do aluno, ou seja, se o aluno pode ser considerado
	 * cansado ou descansado. Esse status é determinado a partir da divisão das horas
	 * descansadas (horasDescanso) pelo número de semanas (numSemanas), sendo ambas 
	 * fornecidas pelo usuário.
	 * 
	 * @return a representação em string do status geral do aluno na disciplina, ou seja,
	 * a situação da rotina de descanso do aluno. 
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
