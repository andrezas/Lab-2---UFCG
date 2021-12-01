import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Andreza Santos de Santana - 120110518
 */

public class Wally {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nomes;
		String wally = "";
		
		do{
			nomes = sc.nextLine().trim();
			if (nomes.equals("wally")) {
				break;
			}
			for (String nome : nomes.split(" ")) {
				
				if(nome.length() == 5) {
					wally = nome;
				}
			}
			if(wally != "") {
				System.out.println(wally);
				wally = "";
			}else {
				System.out.println("?");
			}
			
		}while (nomes != "wally");
		
	}

}
