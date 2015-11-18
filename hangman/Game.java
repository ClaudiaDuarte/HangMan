package hangman;

/**
 * Classe que implementa as funcionalidades do jogo da forca.
 * @author Cl‡udia Duarte
 *
 */
public class Game {

	private String secret;
	private String missedLetters;
	private String guessedLetters;
	private int countGuessed;

	/**
	 * Construtor do objecto Game
	 * 
	 * @param word Ž a palavra secreta
	 */
	public Game(String word) {
		secret = word;
		missedLetters = new String();
		guessedLetters = new String();
		countGuessed = 0;

	}

	/**
	 * 
	 * @return o nœmero de letras da palavra secreta
	 */
	public int totalLetters() {

		int total = secret.length();
		return total;
	}

	/**
	 * 
	 * @return o nœmero de tentativas falhadas
	 */
	public int missedLetters() {
		int missed = missedLetters.length();
		return missed;
	}

	/**
	 * 
	 * @return o nœmero de letras acertadas
	 */
	public int guessedLetters() {
		return countGuessed;
	}

	/**
	 * 
	 * @return true se o jogo tiver acabado
	 */
	public boolean gameOver() {
		if (guessedLetters() == totalLetters() || missedLetters() == 6) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return true se o jogador tiver ganho
	 */
	public boolean playerWon() {
		if (guessedLetters() == totalLetters()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return true se o jogador tiver perdido
	 */
	public boolean playerLost() {
		if (missedLetters() == 6) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param l Ž o caracter a analisar
	 * @return -2 se o jogo tiver acabado, -1 se o caracter j‡ tiver sido utilizado, 0 
	 * se a letra n‹o constar da palavra secreta e n > 0, sendo n o nœmero de vezes que
	 * a letra foi encontrada na palavra secreta
	 */
	public int guess(char l) {
		if (gameOver()) {
			return -2;
		} else if (usedLetter(l)) {
			return -1;
		} else {
			int num = 0;
			for (int i = 0; i < totalLetters(); i++) {
				if (l == secret.charAt(i)) {
					num = num + 1;
				}
			}

			if (num == 0) {
				missedLetters = missedLetters + l;
			} else {
				guessedLetters = guessedLetters + l;
				countGuessed = countGuessed + num;
			}

			return num;
		}

	}

	/**
	 * 
	 * @param l Ž o caracter a analisar
	 * @return true se a letra j‡ tiver sido utilizada pelo jogador
	 */
	public boolean usedLetter(char l) {
		if (guessedLetter(l)) {
			return true;
		} else if (missedLetter(l)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param l Ž o caracter a analisar
	 * @return true se j‡ tiver sido utilizado pelo jogador e fizer parte da palavra
	 *  secreta
	 */
	public boolean guessedLetter(char l) {
		for (int i = 0; i < guessedLetters.length(); i++) {
			if (l == guessedLetters.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param l Ž o caracter a analisar
	 * @return true se j‡ tiver sido utilizado pelo jogador numa tentativa falhada
	 *  
	 */
	public boolean missedLetter(char l) {
		for (int i = 0; i < missedLetters(); i++) {
			if (l == missedLetters.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return a representa‹o textual do objecto
	 */
	@Override
	public String toString() {
		String result = new String();

		for (int i = 0; i < totalLetters(); i++) {
			boolean found = false;
			for (int j = 0; j < guessedLetters.length(); j++) {
				if (secret.charAt(i) == guessedLetters.charAt(j)) {
					result = result + secret.charAt(i) + " ";
					found = true;
					break;
				}
			}
			if (!found) {
				result = result + "_ ";
			}

		}

		result = result + "| ";

		for (int i = 0; i < missedLetters.length(); i++) {
			result = result + missedLetters.charAt(i) + " ";
		}

		return result;
	}

}
