package lab2;

/**
* Representa��o das finan�as de um aluno, ou seja, os ganhos e as despesas que o
* aluno teve para o mesmo possa controlar suas finan�as.
* 
* @author Andreza Santana
*/
public class RegistroFinancas {
	
	/**
	 * Armazena os ganhos do aluno, inclusive o ganho inicial.
	 */
	private int ganhos = 0;
	
	/**
	 * Representa a quantidade de ganhos que o aluno obteve. 
	 */
	private int quantGanhos = 0;
	
	/**
	 * Array criado para armazenar os ganhos do aluno.
	 */
	private int[] listaGanhos;
	
	/**
	 * Representa as despesas totoais do aluno.
	 */
	private int despesas = 0;
	
	/**
	 * Inicializa/Constr�i um registro de finan�as a partir de um ganho inicial 
	 * e a quantidade de ganhos do aluno.
	 * 
	 * @param ganhosIniciais o ganho inical do aluno, ou seja, o primeiro ganho.
	 * @param totalDeGanhos a quantidade de ganhos do aluno.
	 */
	public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
		this.ganhos = ganhosIniciais;
		this.quantGanhos = totalDeGanhos;
		listaGanhos = new int[totalDeGanhos];
	}
	
	/**
	 * Adiciona novos ganhos, em centavos, obtidos pelo aluno e armazena esses valores
	 * na lista de ganhos em um aposi��o espec�fica, de modo que o valor possa ser
	 * substitu�do por um novo valor e o valor anteriormente armazenado nessa posi��o
	 * passe a ser desconsiderado.
	 * 
	 * @return sem retorno.
	 */
	public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
		if (listaGanhos[posicaoGanho-1] != 0) {
			this.ganhos -= listaGanhos[posicaoGanho-1];
			listaGanhos[posicaoGanho-1] = valorCentavos;
			this.ganhos += valorCentavos;
		}else {
			listaGanhos[posicaoGanho-1] = valorCentavos;
			this.ganhos += valorCentavos;
		}
	}
	
	/**
	 * Soma todas as despesas do aluno.
	 * 
	 * @return sem retorno.
	 */
	public void pagaDespesa(double valor) {
		this.despesas += valor;
	}

	/**
	 * Faz a exibi��o dos ganhos do aluno, ou seja, uma esp�cie de extrato banc�rio
	 * contendo apenas os ganhos.
	 * 
	 * @return uma String retorno os ganhos do aluno em uma posi��o espec�fica. 
	 */
	public String exibeGanhos() {
		String resultado = "";
		for(int i=0; i< listaGanhos.length; i++) {
			if(i < listaGanhos.length - 1) {
				resultado += i+1 + " - " + listaGanhos[i] + "\n";
			}else {
				resultado += i+1 + " - " + listaGanhos[i];
			}
			
		}
		return resultado;
	}
	
	/**
	 * Retorna a String que representa uma esp�cie de extrato banc�rio das finan�as
	 * do aluno.
	 * 
	 * @return a representa��o em String das finan�as do aluno.
	 */
	public String toString() {
		int disponivel = this.ganhos - this.despesas;
		return "Total recebidos: " + this.ganhos + ", " + "Despesas totais: " + this.despesas + ", " + "Total dispon�vel: " + disponivel;
	}
	
	
}

