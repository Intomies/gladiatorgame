package peliprojekti.obj.humanoid;

import java.util.Random;

import peliprojekti.obj.weapon.WeaBuilder;
import peliprojekti.resources.Rolls;
import peliprojekti.resources.Tables;

public class HumBuilder {

	public static Humanoid constructHumanoid() {

		Humanoid h = new Humanoid(genName(), selectRace(), selectGender(), selectCulture(), genName(), Rolls.roll(3, 6),
				Rolls.roll(3, 6), Rolls.roll(2, 6), Rolls.roll(2, 6), Rolls.roll(3, 6), Rolls.roll(3, 6),
				Rolls.roll(3, 6));

		h.setMeleeWeapon(WeaBuilder.createMeleeWeapons());
		h.setTotalSta(h.getStr() + h.getBody());
		h.setTotalMana(h.getPower());
		h.setDmgBonus(Tables.dmgBonTbl(h.getStr() + h.getSize()));
		h.setDexHitMom(Tables.hitMomTbl(h.getDex()));
		h.setSizeHitMomBonus(Tables.hitMomTbl(h.getSize()) - 1);
		h.setMelHitMom(h.getSizeHitMomBonus() + h.getDexHitMom() + h.getMeleeWeapon().getHitMom());

		h.setTotalHP((h.getBody() + h.getSize()) / 2);
		h.setHeadHP(Tables.bpHP(h.getTotalHP()));
		h.setChestHP(Tables.bpHP(h.getTotalHP()) + 1);
		h.setStomachHP(Tables.bpHP(h.getTotalHP()));
		h.setLHandHP(Tables.bpHP(h.getTotalHP()));
		h.setRHandHP(Tables.bpHP(h.getTotalHP()));
		h.setLLegHP(Tables.bpHP(h.getTotalHP()));
		h.setRLegHP(Tables.bpHP(h.getTotalHP()));
		h.setAtckBonus(countAttackBonus(h.getDex(), h.getInte(), h.getStr()) + h.getMeleeWeapon().getBasePrc());
		h.setBlckBonus(countDefenseBonus(h.getDex(), h.getStr(), h.getSize()));

		return h;
	}

	private static int countDefenseBonus(int dex, int str, int size) {
		int a = 0;
		a += dex - 10;

		if (str % 2 == 0) {
			a += (str - 10) / 2;
		} else {
			a += (str - 9) / 2;
		}

		a -= size - 10;

		return a + 30 + (Rolls.roll(5, 9) - 1);
	}

	private static int countAttackBonus(int dex, int inte, int str) {
		int a = 0;
		a += dex - 10;
		a += inte - 10;
		if (str % 2 == 0) {
			a += (str - 10) / 2;
		} else {
			a += (str - 9) / 2;
		}

		return a + 30 + (Rolls.roll(5, 9) - 1);
	}

	private static String selectCulture() {
		Random ran = new Random();
		String cultures = "primitive,nomad,barbarian,civilized";
		String[] cList = cultures.split(",");

		return cList[ran.nextInt(cList.length)];
	}

	private static String selectGender() {
		Random ran = new Random();
		boolean sel = ran.nextBoolean();

		if (sel) {
			return "Male";
		} else {
			return "Female";
		}
	}

	private static String selectRace() {
		Random ran = new Random();
		String races = "human,dwarf,wood elf,orc,halforc,halfling,high elf";
		String[] rList = races.split(",");

		return rList[ran.nextInt(rList.length)];
	}

	private static String genName() {
		Random ran = new Random();
		String cylls = "ara,gorn,gim,li,grish,nak,sna,ga,ug,luk,boro,mir,fara,lego,las,fro,do,bag,gins"
				+ ",sam,gam,gi,meri,a,doc,ran,di,buk,pe,reg,rin,tuk,gan,dalf,el,rond"
				+ ",dene,thor,eo,wyn,ar,wen,ga,lad,ri,el,gil,gol,lum,tho,rin,bom,ba"
				+ ",dil,tom,lut,hi,en,fi,ki,li,bur,theo,den,bil,bo,gor,mak,je,bus";
		String[] cyllsList = cylls.split(",");
		String name = cyllsList[ran.nextInt(cyllsList.length)] + cyllsList[ran.nextInt(cyllsList.length)];

		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

}
