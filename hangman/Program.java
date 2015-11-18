package hangman;

import java.util.Scanner;

/**
 * Programa que corre o jogo Hangman
 * @author Cláudia Duarte
 *
 */
public class Program {

	/**
	 * Função principal do programa
	 * @param args são os argumentos do programa
	 */
	public static void main(String[] args) {
		Game game = new Game(args[0]);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(game.toString());
		
		while (game.gameOver() == false){
			System.out.print("Letter(s): ");
			String guessw = scanner.next();
			for (int i = 0; i<guessw.length(); i++){
				int result = game.guess(guessw.charAt(i));
				if (result > 0){
					System.out.println("Good, "+ result + " matches for letter '"+ guessw.charAt(i) +"' !");
				} else if (result == 0){
					System.out.println("Letter '"+ guessw.charAt(i) + "' not in secret word!");
				} else 
					System.out.println("Letter '"+ guessw.charAt(i) + "' used before!");
			}
			System.out.println(game.toString());	
		}
		if (game.playerWon()){
			System.out.println("Game over! You win!");
		} else{
			System.out.println("Game over! You lose!");
		}
	}

}
