import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Andreza Santos de Santana - 120110518
 */

public class FuncMonotona {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int anterior = 0;
		int crescente = 0;
		int decrescente = 0;
		int diferente = 0;
		int atualizador = 1;
		
		for(int i=0; i<4; i++) {
			int valor = sc.nextInt();
			if (i == 0) {
				anterior = valor;
			}else {
				if(anterior < valor) {
					crescente += 1;
					anterior = valor;
				}else if(anterior > valor) {
					decrescente += 1;
					anterior = valor;
				}else {
					diferente += 1;
				}
			}
			
		}
		
		if (crescente == 3) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		}else if (decrescente == 3) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		}else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
		
	}
}