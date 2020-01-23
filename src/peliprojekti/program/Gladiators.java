package peliprojekti.program;

import java.util.Scanner;
import java.util.TreeMap;

import peliprojekti.obj.humanoid.HumBuilder;
import peliprojekti.obj.humanoid.Humanoid;
import peliprojekti.resources.Rolls;

public class Gladiators {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Boolean hh = true;

		TreeMap<Integer, Humanoid> fighters = new TreeMap<Integer, Humanoid>();

		Humanoid a = HumBuilder.constructHumanoid();
		Humanoid b = HumBuilder.constructHumanoid();

		if (a.getMelHitMom() == b.getMelHitMom()) {
			a.setMelHitMom(a.getMelHitMom() - 1);
		}

		fighters.put(a.getMelHitMom(), a);
		fighters.put(b.getMelHitMom(), b);

		Humanoid f = fighters.get(fighters.firstKey());
		Humanoid s = fighters.get(fighters.lastKey());

		System.out.println("FIGHTER A \n" + a.description());
		System.out.println();
		System.out.println("FIGHTER B \n" + b.description());
		System.out.println();

		System.out.println(f.getName() + " gets to attack first!");
		System.out.println();
		System.out.println("Commands are: \nq-quit, c-commands, n-start/next turn, a-fighter a desc, b-fighter b desc");

		while (true) {
			System.out.println("Your command?");
			String com = input.nextLine();

			if (com.equals("q")) {
				System.out.println("You quit the program!");
				break;
			} else if (com.equals("c") || com.equals("")) {
				System.out.println("Commands are: \nq-quit, c-commands, n-start/next turn");
			} else if (com.equals("a")) {
				System.out.println(a.toString());
			} else if (com.equals("b")) {
				System.out.println(b.toString());
			} else if (com.equals("n")) {
				clash(f, s, hh);
				System.out.println();
				hh = false;
				if (s.getTotalHP() <= 0) {
					System.out.println(s.getName() + " is dead. " + f.getName() + " is the winner!");
					break;
				} else {
					clash(f, s, hh);
					System.out.println();
					hh = true;
				}
			}
			if (f.getTotalHP() <= 0) {
				System.out.println(f.getName() + " is dead. " + s.getName() + " is the winner!");
				break;
			}
		}

		input.close();
	}

	private static void clash(Humanoid f, Humanoid s, boolean hh) {
		Humanoid a;
		Humanoid b;

		int hit = 0;
		int block = 0;
		int dmg = 0;

		if (hh) {
			a = f;
			b = s;
		} else {
			a = s;
			b = f;
		}

		hit = Rolls.roll(1, 100);
		System.out.println(a.getName() + " rolls " + hit);

		if (hit <= a.getAtckBonus()) {
			System.out.println("It's a hit!");
			dmg = Rolls.roll(a.getMeleeWeapon().getDiceNum(), a.getMeleeWeapon().getDiceSides())
					+ a.getMeleeWeapon().getPlusDmg();
			block = Rolls.roll(1, 100);
			System.out.println(b.getName() + " tries to block and rolls " + block);
			if (block <= b.getBlckBonus()) {
				System.out.println("Block succeeds!");
				if (dmg <= b.getMeleeWeapon().getWHp()) {
					System.out.println(b.getMeleeWeapon().getName() + " absorbs all the damage!");
				} else {
					System.out.println(
							a.getName() + " does " + (dmg - b.getMeleeWeapon().getWHp()) + " damage to " + b.getName());
					b.setTotalHP(b.getTotalHP() - (dmg - b.getMeleeWeapon().getWHp()));
					System.out.println(b.getName() + " now has " + b.getTotalHP() + " hitpoints.");
				}
			} else {
				System.out.println(b.getName() + " fails to block!");
				System.out.println(a.getName() + " does " + (dmg) + " damage to " + b.getName());
				b.setTotalHP(b.getTotalHP() - dmg);
				System.out.println(b.getName() + " now has " + b.getTotalHP() + " hitpoints.");
			}
		} else {
			System.out.println(a.getName() + " misses " + b.getName());
		}

	}
}
