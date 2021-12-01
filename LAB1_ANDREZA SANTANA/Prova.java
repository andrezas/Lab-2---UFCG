/**
 * Laboratório de Programação 2 - Lab 1

 * 
 * @author Andreza Santos de Santana - 120110518
 */

import java.util.Scanner;

public class Prova {
	public static void main(String[] main) {
		
		Scanner sc = new Scanner(System.in);
		
		String nome = ""; int nota;
		
		int maior = 0 , menor = 0, media = 0, acima = 0, abaixo = 0, cont = 0, soma = 0;
		
		while( nome != "-") {
			nome = sc.next();
			if (nome.equals("-")) {
				break;
			}
			nota = sc.nextInt();
			soma += nota;
			
			if(nota >= 700) {
				acima += 1;
			}else {
				abaixo += 1;
			}
			
			if (cont == 0) {
				maior = nota;
				menor = nota;
				cont += 1;
			}else {
				if (nota > maior) {
					maior = nota;
				}else if(nota < menor) {
					menor = nota;
				}
				cont += 1;
			}
		}
		
		media = soma/cont;
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);
	}
		
}