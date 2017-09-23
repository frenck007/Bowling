package bowlingV2;

public class Bowling {

	private int score = 0;
	private int roll[] = new int[21];
	private int tenth = 0;
	private int MAX_ROLLS = 20;

	public int calculScore() {

		for (int i = 0; i < roll.length; i++) {
			score += roll[i];
		}
		return score;
	}

	public void roll(int i) {
		if (tenth <= MAX_ROLLS) {
			roll[tenth] = i;
			tenth++;
		}
		if (tenth == 20 && thirdRollInLastTenth()) {
			MAX_ROLLS = 19;
		}
		/*
		 * Si on fait un Strike, on joue seulement une boule pour le tour. sauf pour le
		 * dernier tenth, où on peut faire 3 Strike de suite
		 */
		if (i == 10 && tenth < 18) {
			roll[tenth] = 0;
			tenth++;
		}

		if ((tenth - 1) == MAX_ROLLS) {
			calculStrikeScore();
		}

	}

	private void calculStrikeScore() {
		/*
		 * Je dois faire différemment pour les 18-19 et 20e coups, car je sors du
		 * tableau!
		 */

		for (int i = 0; i < roll.length - 2; i++) {
			if (roll[i] == 10) {
				int scoreNextRoll = 0;
				int scoreSecondRoll = 0;
				scoreNextRoll = roll[i + 2];
				if (scoreNextRoll == 10) {
					scoreSecondRoll = roll[i + 4];
				} else {
					scoreSecondRoll = roll[i + 3];
				}
				roll[i] = roll[i] + scoreNextRoll + scoreSecondRoll;
			}
		}
	}

	private boolean thirdRollInLastTenth() {
		int firstRollLastTenth = 18;
		int secondRollLastTenth = 19;
		if (roll[firstRollLastTenth] + roll[secondRollLastTenth] >= 10) {
			return false;
		}
		return true;
	}

}
