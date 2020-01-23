package peliprojekti.obj.weapon;

import java.util.ArrayList;
import java.util.List;

import peliprojekti.resources.Rolls;

public class WeaBuilder {
	
	public static MeleeWeapon createMeleeWeapons() {
List<MeleeWeapon> mweapons = new ArrayList();
		
		//String, boolean, int, int, int, int, int, double, int, int, int, int, String
		//name, twoHanded, diceNum, diceSides, plusDmg, str, dex, enc, basePrc, wHp, hitMom, price, dmgType
		mweapons.add(new MeleeWeapon("Throwing Spear", false, 1, 6, 1, 7, 7, 1.5, 5, 8, 2, 100, "p")); 
		mweapons.add(new MeleeWeapon("Short Spear", false, 1, 8, 1, 7, 7, 2.0, 5, 10, 2, 20, "p"));
		mweapons.add(new MeleeWeapon("Short Spear", true, 1, 8, 1, 0, 7, 2.0, 15, 10, 2, 20, "p"));
		mweapons.add(new MeleeWeapon("Long Spear", true, 1, 10, 1, 9, 7, 2.0, 15, 10, 1, 30, "p"));
		
		return mweapons.get(Rolls.roll(1, mweapons.size())-1);
		
	}

}
