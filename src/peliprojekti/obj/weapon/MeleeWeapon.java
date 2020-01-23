package peliprojekti.obj.weapon;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MeleeWeapon {

	String name; // name of the weapon
	
	// one- or two-handed
	boolean twoHanded;
	
	// damage dice, {number of dice},{dice sides},{plusdamage} (eg. 2,d6,+1)
	int diceNum;
	int diceSides;
	int plusDmg;

	int str;// Strength needed to use weapon
	int dex;// Dexterity needed to use weapon

	double enc;// Estimated weapon weight and clumsiness
	int basePrc;// Basic skill % for character who has never used this type of weapon

	int wHp;// Each succesful block decreases incoming damage for the amount of this value,
			// but these points decrease by one per block
	int hitMom; // Speed of the weapon. Add this with characters sizeHitMomBonus and dexHitMom
				// in combat.
	int price; // Price of the weapon

	String dmgType; // Damage types are piercing(p), slashing(s), blunt/crushing(c)

	public MeleeWeapon(String name, boolean twoHanded, int diceNum, int diceSides, int plusDmg, int str, int dex, double enc,
			int basePrc, int wHp, int hitMom, int price, String dmgType) {
		super();
		this.name = name;
		this.twoHanded = twoHanded;
		this.diceNum = diceNum;
		this.diceSides = diceSides;
		this.plusDmg = plusDmg;
		this.str = str;
		this.dex = dex;
		this.enc = enc;
		this.basePrc = basePrc;
		this.wHp = wHp;
		this.hitMom = hitMom;
		this.price = price;
		this.dmgType = dmgType;
	}

	public MeleeWeapon() {
		super();
		this.name = null;
		this.twoHanded = false;
		this.diceNum = 0;
		this.diceSides = 0;
		this.plusDmg = 0;
		this.str = 0;
		this.dex = 0;
		this.enc = 0;
		this.basePrc = 0;
		this.wHp = 0;
		this.hitMom = 0;
		this.price = 0;
		this.dmgType = null;
	}

	@Override
	public String toString() {
		return "MeleeWeapon [name=" + name  + ", twoHanded=" + twoHanded + ", diceNum="
				+ diceNum + ", diceSides=" + diceSides + ", plusDmg=" + plusDmg + ", str=" + str + ", dex=" + dex
				+ ", enc=" + enc + ", basePrc=" + basePrc + ", wHp=" + wHp + ", hitMom=" + hitMom + ", price=" + price
				+ ", dmgType=" + dmgType + "]";
	}

	

}
