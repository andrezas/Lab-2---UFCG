import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Andreza Santos de Santana - 120110518
 */

public class Calculadora {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String operacao = sc.next();
		
		if (operacao.equals("+")) {
			float a = sc.nextFloat();
			float b = sc.nextFloat();
			System.out.println("RESULTADO: " + soma(a, b));
		}else if (operacao.equals("-")) {
			float a = sc.nextFloat();
			float b = sc.nextFloat();
			System.out.println("RESULTADO: " + subtracao(a, b));
		}else if (operacao.equals("/")) {
			float a = sc.nextFloat();
			float b = sc.nextFloat();
			if(b == 0) {
				System.out.println("ERRO");
			}else {
				System.out.println("RESULTADO: " + divisao(a, b));
			}
		}else if (operacao.equals("*")) {
			float a = sc.nextFloat();
			float b = sc.nextFloat();
			System.out.println("RESULTADO: " + multiplicacao(a, b));
		}else {
			System.out.println("ENTRADA INVALIDA");
		}
		
		
	}
	
	public static float soma(float num1, float num2) {
		float resultado = num1 + num2;
		return resultado;
	}
	
	public static float subtracao(float num1, float num2) {
		float resultado = num1 - num2;
		return resultado;
	}
	
	public static float divisao(float num1, float num2) {
		float resultado = num1 / num2;
		return resultado;
	}
	public static float multiplicacao(float num1, float num2) {
		float resultado = num1 * num2;
		return resultado;
	}
}