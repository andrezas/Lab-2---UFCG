/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Andreza Santos de Santana - 120110518
 */

import java.util.Scanner;

public class AcimaMedia {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String valores = sc.nextLine().trim();
		
		int soma = 0; int quantNum = 0;
		
		for(String valor : valores.split(" ")) {
			soma += Integer.parseInt(valor);
			quantNum += 1;
		}
		
		double media = soma/quantNum;
		
		for (String numero : valores.split(" ")) {
			int num = Integer.parseInt(numero);
			if(num > media) {
				System.out.print(num + " ");
			}
		}
		
		
	}

}
