package lab3;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Scanner;


/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade apud Andreza Santana
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

	
//		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	
	private static String menu(Scanner scanner) {
		System.out.println( 
				"\n---\nMENU\n\n" +
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos \n" +
						"(A)dicionar Favorito \n" +
						"(T)ags \n" +
						"(S)air \n" + 
						"\n" + 
						"Opção> ");
				
		return scanner.nextLine().toUpperCase();
	
		
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		try { 
			switch (opcao) {
			case "C":
				cadastraContato(agenda, scanner);
				break;
			case "L":
				listaContatos(agenda);
				break;
			case "E":
				exibeContato(agenda, scanner);
				break;
			case "F":
				listaFavoritos(agenda);
				break;
			case "A":
				adicionaFavorito(agenda, scanner);
				break;
			case "T":
				adicionaTag(agenda, scanner);
				break;
			case "S":
				sai();
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Object[] contatos = agenda.getContatos();
		String lista = "";
		for (int i = 0; i < contatos.length; i++) {
			Contato contato = (Contato) contatos[i];
			if(i == contatos.length && contato != null) {
				lista += i+1 + " - " + contato.getNome() + " " + contato.getSobrenome();
 			}else if(contato != null) {
				lista += i+1 + " - " + contato.getNome() + " " + contato.getSobrenome() + "\n";
			}
		}
		System.out.println(lista); 
	}
	
	/**
	 * Lista os contatos favoritos.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaFavoritos(Agenda agenda) {
		Object[] favoritos = agenda.getFavoritos();
		String lista = "";
		for (int i = 0; i < favoritos.length; i++) {
			Contato favorito = (Contato) favoritos[i];
			if (favorito != null) {
				lista +=  i+1 + " - " + favorito.getNome() + " " + favorito.getSobrenome() + "\n";
			}
			
		}
		System.out.println(lista.equals("") ? "LISTA DE FAVORITOS VAZIA!" : lista); 
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		System.out.println(agenda.getContato(posicao));
		scanner.nextLine();
	}

	
	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		System.out.println("CADASTRO REALIZADO!");
	
	}
	
	/**
	 * Método auxiliar criado para adiconar contatos favoritos na lista de favoritos
	 * contida na classe Agenda.
	 * 
	 * @param agenda A instância da agenda.
	 * @param scanner As entradas digitadas pelo usuário representando os parâmetros
	 * necessários para que um contato seja favoritado na agenda.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		agenda.adicionaFavorito(posicao, contato);
		System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!");
		scanner.nextLine();
	}

	/**
	 * Método auxiliar criado para adiconar tags a um contato na lista de contatos
	 * contida na classe Agenda.
	 * 
	 * @param agenda A instância da agenda.
	 * @param scanner As entradas digitadas pelo usuário representando os parâmetros
	 * necessários para que uma tag seja adicionada a um ou mais contatos da agenda.
	 */
	private static void adicionaTag(Agenda agenda, Scanner scanner) {
		System.out.println("\nContato(s)> ");
		String posContato = scanner.nextLine();
		System.out.println("\nTag> ");
		String tag = scanner.nextLine();
		System.out.println("\nPosição> ");
		int posicao = scanner.nextInt();
		agenda.adicionaTag(posContato, tag, posicao);
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println(" * Execução encerrada *");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
