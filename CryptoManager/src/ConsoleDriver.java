import java.util.*;

public class ConsoleDriver {
	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ENCRYPT/DECRYPT?");
		String choice = in.nextLine();
		if (choice.equals("ENCRYPT")) {
			System.out.println("CEASER/BELLASO?");
			String choice1 = in.nextLine();
	
			if (choice1.equals("CEASER")) {
				
				System.out.println("ENTER WORD: ");
				String word =  in.nextLine();
				System.out.println("ENTER KEY: ");
				int key =  in.nextInt();
				String encrypted = CryptoManager.encryptCaesar(word, key);
				System.out.println(encrypted);
			}
			else if (choice1.equals("BELLASO")) {
				
				System.out.println("ENTER WORD: ");
				String word2 =  in.nextLine();
				System.out.println("ENTER KEY: ");
				String wordKey = in.nextLine();
				in.nextLine();
				String encrypted2 = CryptoManager.encryptBellaso(word2, wordKey);
				System.out.println(encrypted2);
			}
			
		}
		else if (choice.equals("DECRYPT")) {
			System.out.println("CEASER/BELLASO?");
			String choice3 = in.nextLine();
			if (choice3.equals("CEASER")) {
				System.out.println("ENTER WORD: ");
				String word =  in.nextLine();
				System.out.println("ENTER KEY: ");
				int key =  in.nextInt();
				String decrypted = CryptoManager.decryptCaesar(word, key);
				System.out.println(decrypted);
			}
		}
}
}
