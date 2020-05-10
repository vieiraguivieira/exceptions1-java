package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		method1();

		System.out.println("End of program!");

	}

	public static void method1() {
		System.out.println("***Method1 Start***");

		method2();

		System.out.println("***Method1 End***");
	}

	public static void method2() {
		System.out.println("***Method2 Start***");
		Scanner sc = new Scanner(System.in);
		try {
			String[] vect = sc.nextLine().split(" "); // mantem na mesma linha a captura mas separa pelo que voce
														// colocou, no caso, um espa�o
			int position = sc.nextInt();
			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!");
			e.printStackTrace(); // imprimiu o tipo da exce��o, mensagem da exce��o e a sequencia de chamadas que
									// gerou a exce��o, sem terminar o programa
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Input error!");
		}
		// finally executa independente do try ou n�o
		finally {
			System.out.println("Parab�ns");
		}
		sc.close();
		System.out.println("***Method2 End***");
	}
}
