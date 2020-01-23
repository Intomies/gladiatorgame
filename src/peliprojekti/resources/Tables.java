package peliprojekti.resources;

public class Tables {

	public static int bpHP(int a) {
		int b = 0;

		if (a >= 19) {
			b = 7;
		}
		if (a < 19) {
			b = 6;
		}
		if (a < 16) {
			b = 5;
		}
		if (a < 13) {
			b = 4;
		}
		if (a < 10) {
			b = 3;
		}
		if (a < 7) {
			b = 2;
		}
		if (a < 4) {
			b = 1;
		}

		return b;
	}

	public static int handsHP(int a) {
		int b = 0;

		if (a >= 19) {
			b = 6;
		}
		if (a < 19) {
			b = 5;
		}
		if (a < 16) {
			b = 4;
		}
		if (a < 13) {
			b = 3;
		}
		if (a < 10) {
			b = 3;
		}
		if (a < 7) {
			b = 2;
		}
		if (a < 4) {
			b = 1;
		}

		return b;
	}

	public static String dmgBonTbl(int a) {
		String b = "";
		//Returns String:{number of dice},{dice sides},{multiplier}
		//Returned String should be splitted and parsed, so that it can be used in dice roll
		if (a >= 57) {
			b = "3,6,1";
		}
		if (a < 57) {
			b = "2,6,1";
		}
		if (a < 41) {
			b = "1,6,1";
		}
		if (a < 33) {
			b = "1,4,1";
		}
		if (a < 25) {
			b = "0,0,0";
		}
		if (a < 13) {
			b = "1,4,-1";
		}

		return b;
	}

	public static int hitMomTbl(int a) {
		int b = 0;

		if (a >= 20) {
			b = 1;
		}
		if (a < 20) {
			b = 2;
		}
		if (a < 16) {
			b = 3;
		}
		if (a < 10) {
			b = 4;
		}

		return b;
	}
	
	public static void hitPointsTable() {
		
	}

}
