package lab4;

import java.util.Objects;

/**
 * Representa��o do aluno
 * 
 * @author Andreza Santana
 *
 */
public class Aluno {

	/**
	 * Representa��o do nome do aluno.
	 */
	private String nome;
	
	/**
	 * Representa��o da matricula do aluno.
	 */
	private String matricula;
	
	/**
	 * Representa��o do curso do aluno.
	 */
	private String curso;
	
	/**
	 * Constr�i/Inicializa um aluno a partir de sua matricula, nome e curso. Para tanto, 
	 * realiza a verifica��o de campos vazios ou nulos.
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
			throw new IllegalArgumentException("Dado vazio!");
		}
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Dado nulo!");
		}
		
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}

	/**
	 * Retorna uma representa��o String, ou seja, textual do aluno.
	 * 
	 * @return a representa��o em string do aluno.
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.matricula + " - " +  this.nome + " - " + this.curso; 
	}
	
	/**
	 * Retorna uma representa��o String, ou seja, textual do aluno.
	 * 
	 * @return uma segunda representa��o em string do aluno sem a palavra "Aluno: ".
	 */
	public String segundoToString() {
		return this.matricula + " - " +  this.nome + " - " + this.curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
}
