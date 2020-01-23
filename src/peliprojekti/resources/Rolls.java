package peliprojekti.resources;

import java.util.Random;

public class Rolls {

	public static int roll(int times, int sides) {
		Random ran = new Random();
		int stat = 0;
		for (int i = 0; i < times; i++) {
			stat += ran.nextInt(sides) + 1;

		}
		return stat;
	}
	
}
