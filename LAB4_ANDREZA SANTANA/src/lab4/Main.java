package lab4;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		ControleAluno controle = new ControleAluno();
		
		String entradaUser = opcoes(sc);
		while(! entradaUser.equals("S")) {
			try {
				switch(entradaUser) {
				case "C":
					cadastraAluno(controle, sc);
					break;
				case "E":
					exibeAluno(controle, sc);
					break;
				case "N":
					cadastraGrupo(controle, sc);
					break;
				case "A":
					multiplaOpcao(controle, sc);
					break;
				case "R":
					cadastraAlunoEmQuadro(controle, sc);
					break;
				case "I":
					imprimeAlunosDoQuadro(controle, sc);
					break;
				case "O":
					olhaGruposAluno(controle, sc);
					break;
				default:
					System.out.println("OP��O INV�LIDA!");
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			entradaUser = opcoes(sc);
		}
		System.out.println("***** Programa encerrado *****");
	
	
	}
	
	/**
	 * Verifica os grupos que o aluno est� cadastrado
	 * 
	 * @param controle
	 * @param sc
	 */
	private static void olhaGruposAluno(ControleAluno controle, Scanner sc) {
		System.out.println("Aluno: ");
		String aluno = sc.nextLine();
		if(controle.checaGruposDoAluno(aluno).equals("GRUPOS:\n")) {
			System.out.println("ALUNO SEM GRUPOS");
		}else {
			System.out.println(controle.checaGruposDoAluno(aluno));
		}
	}

	/**
	 * M�todo para alocar o aluno em um grupo ou verificar a pertinencia do aluno
	 * a um grupo.
	 * 
	 * @param controle
	 * @param sc
	 */
	private static void multiplaOpcao(ControleAluno controle, Scanner sc) {
		System.out.println("(A)locar Aluno ou (P)ertin�ncia a Grupo? ");
		String escolha = sc.nextLine().toUpperCase();
		if (escolha.equals("A")) {
			System.out.println("\nMatricula: ");
			String matricula = sc.nextLine();
			System.out.println("Grupo: ");
			String nomeG = sc.nextLine();
			controle.alocaAlunoGrupo(matricula, nomeG);
			System.out.println("ALUNO ALOCADO!");
		}else {
			System.out.println("\nGrupo: ");
			String nomeG = sc.nextLine();
			System.out.println("Aluno: ");
			String matricula = sc.nextLine();
			if(controle.verificaPertinenciaGrupo(nomeG, matricula) == true) {
				System.out.println("ALUNO PERTENCE AO GRUPO!");
			}else {
				System.out.println("ALUNO N�O PERTENCE AO GRUPO!");
			}
		}
	}

	/**
	 * Cadastra um novo grupo.
	 * 
	 * @param controle
	 * @param sc
	 */
	private static void cadastraGrupo(ControleAluno controle, Scanner sc) {
		System.out.println("\nGrupo: ");
		String nome  = sc.next();
		System.out.println("Tamanho: ");
		sc.nextLine();
		String tamanho = sc.nextLine();
		Integer tamanhoG;
		if(! nome.isBlank()) {
			if(tamanho.isBlank()) {
				tamanhoG = null;
			}else {
				tamanhoG = Integer.parseInt(tamanho);
			}
			controle.cadastraGrupo(nome, tamanhoG);
			System.out.println("CADASTRO REALIZADO!");
		}else {
			System.out.println("Ops, dado vazio identificado!");
		}
	}

	/**
	 * Imprime alunos que respoderam quest�es no quadro.
	 * 
	 * @param controle
	 * @param sc
	 */
	private static void imprimeAlunosDoQuadro(ControleAluno controle, Scanner sc) {
		if(controle.imprimeAlunosQuadro().equals("\nALUNOS:\n")) {
			System.out.println("QUADRO SEM REGISTRO DE ALUNOS");
		}else {
			System.out.println(controle.imprimeAlunosQuadro());
		}
	}

	/**
	 * Cadastra aluno que respondeu quest�o no quadro.
	 * 
	 * @param controle
	 * @param sc
	 */
	private static void cadastraAlunoEmQuadro(ControleAluno controle, Scanner sc) {
		System.out.println("\nMatr�cula: ");
		String matricula = sc.nextLine();
		controle.cadastraAlunoRespondeQuestao(matricula);
		System.out.println("ALUNO REGISTRADO!");
	}

	/**
	 * Exibe um aluno especificado pela matr�cula.
	 * 
	 * @param controle
	 * @param sc
	 */
	private static void exibeAluno(ControleAluno controle, Scanner sc) {
		System.out.println("\nMatr�cula: ");
		String matricula = sc.nextLine();
		System.out.println(controle.exibeAluno(matricula));
	}
	
	/**
	 * Cadastra um aluno.
	 * 
	 * @param controle
	 * @param sc
	 */
	private static void cadastraAluno(ControleAluno controle, Scanner sc) {
		System.out.println("\nMatr�cula: ");
		String matricula = sc.nextLine();
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Curso: ");
		String curso = sc.nextLine();
		if (! matricula.isBlank() && ! nome.isBlank() && ! curso.isBlank()) {
			controle.cadastraAluno(matricula, nome, curso);
		}else {
			System.out.println("Ops, dado vazio identificado!");
		}
		System.out.println("CADASTRO REALIZADO!");
	}

	/**
	 * Exibe as op��es ddispon�veis no sistema para o usu�rio.
	 * 
	 * @param scanner
	 * @return scanner para representar a op��o escolhida.
	 */
	private static String opcoes(Scanner scanner) {
		System.out.println(System.lineSeparator()
				+ "(C)adastrar Aluno\n"
				+ "(E)xibir Aluno\n"
				+ "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Verificar pertin�ncia a Grupos\n"
				+ "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n"
				+ "(O)lha� quais Grupos o Aluno T�.\n"
				+ "(S)im, quero Fechar o Programa!\n"
				+ "\nOp��o> ");
		return scanner.nextLine().toUpperCase();
	}
}
