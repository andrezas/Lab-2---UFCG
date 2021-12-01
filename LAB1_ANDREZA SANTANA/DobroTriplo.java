/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Andreza Santos de Santana - 120110518
 */

import java.util.Scanner;

public class DobroTriplo {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		System.out.println("dobro: " + dobro(x) + ", " + "triplo: " + triplo(x));
	}
	
	public static int dobro(int x) {
		return x * 2;
	}
	
	public static int triplo(int x) {
		return x * 3;
	}
}