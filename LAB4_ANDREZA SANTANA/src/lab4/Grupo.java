package lab4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Representa��o de um grupo.
 * 
 * @author Andreza Santana
 *
 */
public class Grupo {
	
	/**
	 * Representa��o do nome do grupo
	 */
	private String nome;
	
	/**
	 * Representa��o do conjunto de alunos de um grupo.
	 */
	private Set<Aluno> alunos;
	
	/**
	 * Representa��o do tamanho de um grupo quando este � diferente de null.
	 */
	private Integer tamanho;

	/**
	 * Constr�i/Inicializa um grupo a partir de seu nome e seu tamanho, este �ltimo
	 * podendo ser nulo.
	 * 
	 * @param nomeG
	 * @param tamanho
	 */
	public Grupo(String nomeG, Integer tamanho) {
		if (nomeG == null) {
			throw new NullPointerException("Dado nulo!");
		}
		if (nomeG.isBlank()) {
			throw new IllegalArgumentException("Dado vazio!");
		} 
		this.nome = nomeG;
		this.tamanho = tamanho;
		this.alunos = new HashSet<>();
	}
	
	/**
	 * Aloca/Cadastra um aluno no grupo. Para tanto verifica se o grupo tem ou n�o 
	 * restri��o de tamanho.
	 * 
	 * @param aluno
	 */
	public void alocaAluno(Aluno aluno) {
		if(this.tamanho != null ) {
			if(this.alunos.size() < this.tamanho) {
				alunos.add(aluno);
			}else {
				throw new IllegalArgumentException("GRUPO CHEIO!");
			}
		}
		alunos.add(aluno);
	}
	
	public Set<Aluno> getAlunos() {
		return alunos;
	}
	
	/**
	 * Verifica se um aluno pertence ao grupo.
	 * 
	 * @param aluno
	 * @return true caso o aluno exista no grupo e false caso n�o exista.
	 */
	public boolean alunoPertenceGrupo(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public String getNome() {
		return nome;
	}
	
	public Integer getTamanho() {
		return tamanho;
	}

	/**
	 *  Retorna uma representa��o String, ou seja, textual de um grupo.
	 *  
	 *  @return a representa��o em string do grupo.
	 */
	@Override
	public String toString() {
		return "- " + this.nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(nome, other.nome);
	}



}
