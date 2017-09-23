package bowlingV2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingTest {

	Bowling game = new Bowling();

	@Test
	public void whenGameStart_thenScoreIsZero() {
		assertEquals(game.calculScore(), 0);
	}

	@Test
	public void whenGamefinishWithoutSpareOrStrike_scoreMinimumIs20() {
		for (int i = 0; i < 20; i++) {
			game.roll(1);
		}
		int finalGameScoreIs = game.calculScore();
		assertEquals(finalGameScoreIs, 20);
	}

	@Test
	public void whenGamefinishwithAllStrike_scoreIs300() {
		for (int i = 0; i < 13; i++) {
			game.roll(10);
		}
		int finalGameScoreIs = game.calculScore();
		assertEquals(finalGameScoreIs, 300);
	}

}
