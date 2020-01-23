package peliprojekti.obj.humanoid;

import lombok.Getter;
import lombok.Setter;
import peliprojekti.obj.weapon.MeleeWeapon;

@Getter
@Setter
public class Humanoid {

	private String name;
	private String race;
	private String gender;
	private String culture;
	private String cult;

	private int str; // strength
	private int body; // body build
	private int size; // body size/mass
	private int inte; // intelligence
	private int power; // powerfulness/leadership with charisma
	private int dex; // dexterity
	private int cha; // charisma

	private int totalSta; // total stamina = str + body
	private int totalMana; // total manapoints = power

	private String dmgBonus; // damagebonus = str + size, check table p.11
	private int dexHitMom; // dexterity hit moment for ranged weapons and spellcasting, table p.12
	private int sizeHitMomBonus; // size hit moment bonus for melee weapons, table p. 12
	private int spellHitMom; // spell hit moment = dexHitMom + used mana
	private int melHitMom; // melee hit moment = dexHitMom + sizeHitMomBonus + weaponHitMomBonus

	private int totalHP; // total hitpoints = (body + size)/2

	// These hitpoints below = total hitpoints, check table p.11
	private int headHP;
	private int chestHP;
	private int stomachHP;
	private int lHandHP;
	private int rHandHP;
	private int lLegHP;
	private int rLegHP;

	private MeleeWeapon meleeWeapon; // characters main hand weapon

	// attack bonus, main skills are inte and dex, secondary skill is str.
	// If main skills are over 10, add one point per exceeding skillpoint, if under,
	// decrease one per skillpoint.
	// If secondary skill is over 10, add one point per two exceeding skillpoints,
	// if under, decrease one point per two skillpoints
	// add this with weapons attack bonus
	private int atckBonus;

	// Same logic as atckbonus, main skill is dex, secondary is strength and
	// negative is size
	// negative skill is the opposite of main skill, so decrease point per point
	// from skillpoints that exceed 10
	// and add skills from every point that is under 10 (10-size = this if size is
	// under 10).
	private int blckBonus;

	public Humanoid() {
		super();
		this.name = null;
		this.race = null;
		this.gender = null;
		this.culture = null;
		this.cult = null;
		this.str = 0;
		this.body = 0;
		this.size = 0;
		this.inte = 0;
		this.power = 0;
		this.dex = 0;
		this.cha = 0;
		this.totalSta = 0;
		this.totalMana = 0;
		this.dmgBonus = null;
		this.dexHitMom = 0;
		this.sizeHitMomBonus = 0;
		this.spellHitMom = 0;
		this.melHitMom = 0;
		this.totalHP = 0;
		this.headHP = 0;
		this.chestHP = 0;
		this.stomachHP = 0;
		this.lHandHP = 0;
		this.rHandHP = 0;
		this.lLegHP = 0;
		this.rLegHP = 0;
		this.meleeWeapon = null;
		this.atckBonus = 0;
		this.blckBonus = 0;
	}

	public Humanoid(String name, String race, String gender, String culture, String cult, int str, int body, int size,
			int inte, int power, int dex, int cha, int totalSta, int totalMana, String dmgBonus, int dexHitMom,
			int sizeHitMomBonus, int spellHitMom, int melHitMom, int totalHP, int headHP, int chestHP, int stomachHP,
			int lHandHP, int rHandHP, int lLegHP, int rLegHP, MeleeWeapon meleeWeapon, int atckBonus, int blckBonus) {
		super();
		this.name = name;
		this.race = race;
		this.gender = gender;
		this.culture = culture;
		this.cult = cult;
		this.str = str;
		this.body = body;
		this.size = size;
		this.inte = inte;
		this.power = power;
		this.dex = dex;
		this.cha = cha;
		this.totalSta = totalSta;
		this.totalMana = totalMana;
		this.dmgBonus = dmgBonus;
		this.dexHitMom = dexHitMom;
		this.sizeHitMomBonus = sizeHitMomBonus;
		this.spellHitMom = spellHitMom;
		this.melHitMom = melHitMom;
		this.totalHP = totalHP;
		this.headHP = headHP;
		this.chestHP = chestHP;
		this.stomachHP = stomachHP;
		this.lHandHP = lHandHP;
		this.rHandHP = rHandHP;
		this.lLegHP = lLegHP;
		this.rLegHP = rLegHP;
		this.meleeWeapon = meleeWeapon;
		this.atckBonus = atckBonus;
		this.blckBonus = blckBonus;
	}

	public Humanoid(String name, String race, String gender, String culture, String cult, int str, int body, int size,
			int inte, int power, int dex, int cha) {
		super();
		this.name = name;
		this.race = race;
		this.gender = gender;
		this.culture = culture;
		this.cult = cult;
		this.str = str;
		this.body = body;
		this.size = size;
		this.inte = inte;
		this.power = power;
		this.dex = dex;
		this.cha = cha;
	}

	public String description() {
		String desc = "Name: " + name + "\nRace: " + race + "\nGender: " + gender + "\nCulture: "
				+ culture + "\nWeapon: " + meleeWeapon.getName() + "\nAttack: " + atckBonus
				+ "\nDefence: " + blckBonus + "\nHitmoment: " + melHitMom;

		return desc;
	}

	@Override
	public String toString() {
		return "Humanoid [name=" + name + ", race=" + race + ", gender=" + gender + ", culture=" + culture + ", cult="
				+ cult + ", str=" + str + ", body=" + body + ", size=" + size + ", inte=" + inte + ", power=" + power
				+ ", dex=" + dex + ", cha=" + cha + ", totalSta=" + totalSta + ", totalMana=" + totalMana
				+ ", dmgBonus=" + dmgBonus + ", dexHitMom=" + dexHitMom + ", sizeHitMomBonus=" + sizeHitMomBonus
				+ ", spellHitMom=" + spellHitMom + ", melHitMom=" + melHitMom + ", totalHP=" + totalHP + ", headHP="
				+ headHP + ", chestHP=" + chestHP + ", stomachHP=" + stomachHP + ", lHandHP=" + lHandHP + ", rHandHP="
				+ rHandHP + ", lLegHP=" + lLegHP + ", rLegHP=" + rLegHP + ", meleeWeapon=" + meleeWeapon
				+ ", atckBonus=" + atckBonus + ", blckBonus=" + blckBonus + "]";
	}

}
