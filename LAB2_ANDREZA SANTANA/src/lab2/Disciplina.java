package lab2;

import java.util.Arrays;

/**
* Representa��o da disciplina que ter� seu progresso avaliado. 
* 
* @author Andreza Santana
*/
public class Disciplina {

	/**
	* Nome da disciplina que est� sendo cursada pelo aluno.
	*/
	private String nameDisciplina;
	
	/**
	* Representa��o das horas de estudo dedicadas � disciplina.
	*/
	private int horasEstudo;
	
	/**
	* Array encarregado de armazenar as 4 notas do aluno.
	*/
	private double[] notas =  new double[4];
	
	/**
	* M�dia do aluno na disciplina calculada a partir das 4 notas armazenadas
	* na lista notas.
	*/
	private double media;
	
	/**
	* Constr�i uma disciplina a partir do seu nome.
	* 
	* @param nome o nome da disciplina.
	*/
	public Disciplina(String nomeDisciplina) {
		this.nameDisciplina = nomeDisciplina;
	}

	/**
	* Cadastra/Adiciona as horas que o aluno dedica ao estudo da disciplina.
	*
	* @return n�o tem retorno.
	*/
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	/**
	* Cadastra/Adiciona uma nota em uma posi��o determinada na lista de notas 
	* da disciplina.
	*
	* @return n�o tem retorno.
	*/
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	* Verifica se o aluno deve ser considerado aprovado ou n�o na disciplina. 
	* O aluno dever� ser considerado aprovado quando sua m�dia seja igual ou 
	* acima de 7.0
	*
	* @return a confirma��o ou nega��o, atrav�s das palavras-chave "true" ou "false" 
	* da aprova��o do aluno na disciplina
	*/
	public boolean aprovado() {
		double soma = 0;
		for (int i = 0; i < notas.length; i++) {
			soma += notas[i];
		}
		media = soma / 4;
		if (media >= 7) {
			return true;
		}else {
			return false;
		}
	}

	/**
	* A a String que representa o progresso do aluno na disciplina
	*
	* @return a representa��o em String do nome da disciplina e o desdobramento 
	* do aluno na disciplina.
	*/
	public String toString() {
		return this.nameDisciplina + " " + this.horasEstudo + " " + this.media + " " + Arrays.toString(notas);
	}
}
	


