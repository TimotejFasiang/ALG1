// @author Timotej

package vanocni.uloha;

import java.util.*;

public class VanocniUloha {
    public static void main(String[] args) {
        // Good luck Tim!
		display_tree();
		System.out.println("");
		System.out.println("");
    }

	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_BLUE = "\u001B[34m";
	
	static void empty(int sizeb) {
		System.out.println("");
		for (int i=0; i<sizeb; i++) {
			System.out.print(" ");
		}
	}

	static void full(int s, String ornament) {
		for (int i=0; i<s; i++) {
			double ran = Math.random()*100;
			double ornamentColor = Math.random()*3;
			if (ran < 85 ) {
				System.out.print(TEXT_GREEN + "*" + TEXT_RESET);
			}
			else {
				if (ornamentColor<1) {
					System.out.print(TEXT_RED + ornament + TEXT_RESET);
				}
				else if (ornamentColor<2) {
					System.out.print(TEXT_YELLOW + ornament + TEXT_RESET);
				}
				else {
					System.out.print(TEXT_BLUE + ornament + TEXT_RESET);
				}
			}
		}
//		System.out.println("");
	}
	
	static void display_tree() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Výška vánočního stromku: ");
		int size = sc.nextInt(); 
		System.out.println("Typ ornamentu(znak): ");
		String ornament = sc.next();
		
		int rows = size;
		int s;
		for (int r=1; r <= size; r++) {
			s = 2*r-1;
			empty((2*size-2*r)/2);
			full(s, ornament); 
		}
	}
}
