package com.ruse.world.content.dissolving;

import com.ruse.model.Animation;
import com.ruse.model.Item;
import com.ruse.model.Skill;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

public class MainDissolving {
	
	private Player player;

	public MainDissolving(Player player) {
		this.player = player;
	}
	static int anim = 11904;
	static int UPG_TOKEN = 12855;
	public enum DissolvingData {
		BORK_HELMET(17594, new Item[]{new Item(UPG_TOKEN, 100_000)}, 780_000, anim),
		BORK_BODY(17596, new Item[]{new Item(UPG_TOKEN, 100_000)}, 780_000, anim),
		BORK_LEGS(17598, new Item[]{new Item(UPG_TOKEN, 100_000)}, 780_000, anim),
		BORK_BOOTS(19776, new Item[]{new Item(UPG_TOKEN, 100_000)}, 780_000, anim),
		BORK_GAUNTLENTS(23099, new Item[]{new Item(UPG_TOKEN, 100_000)}, 780_000, anim),
		NIHIL_HELMET(23522, new Item[]{new Item(UPG_TOKEN, 125_000)}, 820_000, anim),
		NIHIL_BODY(23523, new Item[]{new Item(UPG_TOKEN, 125_000)}, 820_000, anim),
		NIHIL_LEGS(23524, new Item[]{new Item(UPG_TOKEN, 125_000)}, 820_000, anim),
		NIHIL_BOOTS(23525, new Item[]{new Item(UPG_TOKEN, 125_000)}, 820_000, anim),
		NIHIL_GAUNTLENTS(23526, new Item[]{new Item(UPG_TOKEN, 125_000)}, 820_000, anim),
		PURIFIER_STAFF(8089, new Item[]{new Item(UPG_TOKEN, 125_000)}, 900_000, anim),
		JUDICATOR_BOW(8088, new Item[]{new Item(UPG_TOKEN, 125_000)}, 900_000, anim),
		DRAGON_LANCE(8087, new Item[]{new Item(UPG_TOKEN, 125_000)}, 900_000, anim),
		ENRAGED_SWORD(3737, new Item[]{new Item(UPG_TOKEN, 25_000)}, 50000, anim),
		BOTANIC_BOW(3738, new Item[]{new Item(UPG_TOKEN, 25_000)}, 50000, anim),
		ELEMENTAL_STAFF(3739, new Item[]{new Item(UPG_TOKEN, 25_000)}, 50000, anim),
		CREEPER_CAPE(1486, new Item[]{new Item(UPG_TOKEN, 50_000)}, 100_000, anim),
		TORNADO(14018, new Item[]{new Item(UPG_TOKEN, 700)}, 250, anim),
		CHAINSAW(22080, new Item[]{new Item(UPG_TOKEN, 5250)}, 15500, anim),
		SHETANI_STAFF(5095, new Item[]{new Item(UPG_TOKEN, 80)}, 180, anim),
		SABER(21057, new Item[]{new Item(UPG_TOKEN, 400)}, 1500, anim),
		SUMMONCHARMBOX(20481, new Item[]{new Item(UPG_TOKEN, 200)}, 1200, anim),
		HADESSHIELD(21035, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		VIGGORCHAIN(20554, new Item[]{new Item(UPG_TOKEN, 5000)}, 15000, anim),
		FLAMETHRO(17712, new Item[]{new Item(UPG_TOKEN, 2854)}, 12854, anim),
		FLAMETHRO_NOTE(17713, new Item[]{new Item(UPG_TOKEN, 2854)}, 12854, anim),
		HADESHAMMER(21034, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		HADESLEGS(21033, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		CREEPER_1(9054, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		CREEPER_2(9055, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		CREEPER_3(9056, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		CREEPER_4(9057, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		CREEPER_5(9058, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		CREEPER_6(9059, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		SWOODOO(19149, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_4(16055, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_NOTE(19150, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_2(12930, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_3(4405, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_3_NOTE(4406, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_5(16077, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_6(16066, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_7(16114, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		SWOODOO_8(16011, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		HADESBODY(21032, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		HADESHELM(21031, new Item[]{new Item(UPG_TOKEN, 6000)}, 16000, anim),
		ELECTRICBOOTS(15236, new Item[]{new Item(UPG_TOKEN, 1900)}, 11900, anim),
		ELECTRICGLOVES(15235, new Item[]{new Item(UPG_TOKEN, 1900)}, 11900, anim),
		GRO_BOOTS(3107, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		GRO_STAFF(13640, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		GRO_SHIELD(13964, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		GRO_SHIELD_NOTE(13965, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		GRO_POWER(15448, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		GRO_HELM(21934, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		GRO_BODY(19918, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		GRO_LEG(19913, new Item[]{new Item(UPG_TOKEN, 8000)}, 18493, anim),
		T4_MELEE1(8326, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_MELEE2(8327, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_MELEE3(8328, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_MELEE4(22084, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		ARTS_BOOTS(8334, new Item[]{new Item(UPG_TOKEN, 15000)}, 45_000, anim),
		ARTS_RING(8335, new Item[]{new Item(UPG_TOKEN, 15000)}, 45_000, anim),
		T4_RANGE1(8330, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_RANGE2(8331, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_RANGE3(8332, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_RANGE4(22083, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_MAGIC1(8323, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_MAGIC2(8325, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_MAGIC3(8324, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		T4_MAGIC4(22092, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		COLLECTOR_RING(4446, new Item[]{new Item(UPG_TOKEN, 75_000)}, 150_000, anim),
		COLLECTOR_AMULET(19886, new Item[]{new Item(UPG_TOKEN, 75_000)}, 150_000, anim),
		COLLECTOR_RING_ii(18823, new Item[]{new Item(UPG_TOKEN, 150_000)}, 250_000, anim),
		COLLECTOR_AMULET_ii(19888, new Item[]{new Item(UPG_TOKEN, 150_000)}, 250_000, anim),
		COLLECTOR_RING_iiI(18818, new Item[]{new Item(UPG_TOKEN, 250_000)}, 350_000, anim),
		COLLECTOR_AMULET_iiI(18888, new Item[]{new Item(UPG_TOKEN, 250_000)}, 350_000, anim),
		CORRUPT_ARCHIE1(18636, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_ARCHIE2(18638, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_ARCHIE3(18748, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_ARCHIE4(18749, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MOONLIGHT1(18623, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MOONLIGHT2(18629, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MOONLIGHT3(18631, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MOONLIGHT4(18637, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MAXIBLOOD1(18750, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MAXIBLOOD2(18751, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MAXIBLOOD3(18752, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		CORRUPT_MAXIBLOOD4(18753, new Item[]{new Item(UPG_TOKEN, 75000)}, 150_000, anim),
		SERAPHIC_CASE(23411, new Item[]{new Item(UPG_TOKEN, 50000)}, 100_000, anim),
		ETHEREAL_CASE(23412, new Item[]{new Item(UPG_TOKEN, 50000)}, 100_000, anim),
		MONEY_CASE(23812, new Item[]{new Item(UPG_TOKEN, 50000)}, 100_000, anim),
		AGONY_WINGS(8810, new Item[]{new Item(UPG_TOKEN, 7000)}, 20_000, anim),
		WOOS_CAPE(4367, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		WOOS_CAPE_NOTED(4368, new Item[]{new Item(UPG_TOKEN, 20000)}, 60_000, anim),
		PURIFIER1(11421, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		PURIFIER2(11422, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		PURIFIER3(11423, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		PURIFIER4(7640, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		JUDICATOR1(11340, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		JUDICATOR2(11341, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		JUDICATOR3(11342, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		JUDICATOR4(19843, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		DRAGONRIDER1(11320, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		DRAGONRIDER2(11321, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		DRAGONRIDER3(11322, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		DRAGONRIDER4(4178, new Item[]{new Item(UPG_TOKEN, 125000)}, 325_000, anim),
		GZONEGS33(18795, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		wingsss(12634, new Item[]{new Item(UPG_TOKEN, 500)}, 1310, anim),
		Frozenrapier(16045, new Item[]{new Item(UPG_TOKEN, 1000)}, 1240, anim),
		FrozenSHORTBOW(15785, new Item[]{new Item(UPG_TOKEN, 1000)}, 1240, anim),
		Frozenstaff(19331, new Item[]{new Item(UPG_TOKEN, 1000)}, 1240, anim),
		empgloves(8812, new Item[]{new Item(UPG_TOKEN, 3000)}, 1240, anim),
		barrowglovesI(3318, new Item[]{new Item(UPG_TOKEN, 500)}, 1240, anim),
		evilstaff(5096, new Item[]{new Item(UPG_TOKEN, 750)}, 1240, anim),
		brutalwhip(22077, new Item[]{new Item(UPG_TOKEN, 1250)}, 1240, anim),
		brutalstaff(6936, new Item[]{new Item(UPG_TOKEN, 1250)}, 1240, anim),
		brutalbow(19136, new Item[]{new Item(UPG_TOKEN, 1250)}, 1240, anim),
		BRING(6737, new Item[]{new Item(UPG_TOKEN, 50)}, 1240, anim),
		BRING_z(3909, new Item[]{new Item(UPG_TOKEN, 500)}, 1240, anim),
		rowii(3324, new Item[]{new Item(UPG_TOKEN, 1000)}, 1240, anim),
		bossgloves(3905, new Item[]{new Item(UPG_TOKEN, 1000)}, 1240, anim),
		icyfury(15418, new Item[]{new Item(UPG_TOKEN, 1000)}, 1240, anim),
		LAVARING(15401, new Item[]{new Item(UPG_TOKEN, 2500)}, 1240, anim),
		SHADOWAMULET(11195, new Item[]{new Item(UPG_TOKEN, 2500)}, 1240, anim),
		WINGSHIELD(19749, new Item[]{new Item(UPG_TOKEN, 2500)}, 1240, anim),
		ARTRING(8335, new Item[]{new Item(UPG_TOKEN, 4000)}, 1240, anim),

		LIGHT_SHARD(14472, new Item[]{new Item(UPG_TOKEN, 250000)}, 25000, anim),
		DARK_SHARD(14474, new Item[]{new Item(UPG_TOKEN, 750000)}, 100000, anim),
		BLOOD_SHARD(23238, new Item[]{new Item(UPG_TOKEN, 1500000)}, 200000, anim),
		ZEUSCAPEFLAG(17662, new Item[]{new Item(UPG_TOKEN, 7493)}, 17493, anim),
		ZEUSSEIHLD(15234, new Item[]{new Item(UPG_TOKEN, 7493)}, 17493, anim),
		ZEUSHAMMER(15233, new Item[]{new Item(UPG_TOKEN, 7493)}, 17493, anim),
		ZEUSLEGS(15232, new Item[]{new Item(UPG_TOKEN, 7493)}, 17493, anim),
		ZEUSBODY(15231, new Item[]{new Item(UPG_TOKEN, 7493)}, 17493, anim),
		ZEUSHELM(15230, new Item[]{new Item(UPG_TOKEN, 7493)}, 17493, anim),
		SATANRING(18817, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SATANSWORD(20542, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SATANCAPE(18683, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SATANSHIELD(13306, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SATANAMULET(15511, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SATANBOOTS(13305, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SCYTHEOFVITUS(20555, new Item[]{new Item(UPG_TOKEN, 4421)}, 14421, anim),
		PVPVESTAPLATE(13887, new Item[]{new Item(UPG_TOKEN, 320)}, 1320, anim),
		SATANLEGS(13304, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		PVPVESTAPVP(13905, new Item[]{new Item(UPG_TOKEN, 320)}, 1320, anim),
		PVPZURIELSTAFF(13867, new Item[]{new Item(UPG_TOKEN, 320)}, 1320, anim),
		KINGHELM(15922, new Item[]{new Item(UPG_TOKEN, 2000)}, 11999, anim),
		KINGLEGS(15933, new Item[]{new Item(UPG_TOKEN, 2000)}, 11999, anim),
		KINGOBDY(16021, new Item[]{new Item(UPG_TOKEN, 2000)}, 11999, anim),
		BULWARKHELM(8816, new Item[]{new Item(UPG_TOKEN, 2000)}, 11999, anim),
		BULWARKBODY(8817, new Item[]{new Item(UPG_TOKEN, 2000)}, 11999, anim),
		BULWARKLEGS(8818, new Item[]{new Item(UPG_TOKEN, 2000)}, 11999, anim),
		CHAOSSTAFF(18356, new Item[]{new Item(UPG_TOKEN, 300)}, 1300, anim),
		SERPENTINEHELM(12931, new Item[]{new Item(UPG_TOKEN, 1999)}, 11999, anim),
		SATNAGLOVES(13302, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SATANBODY(13301, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SATANHELMET(13300, new Item[]{new Item(UPG_TOKEN, 5535)}, 15535, anim),
		SHIKRUUKATANA(20549, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		SHIKRUUHELMET(8800, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		SHIKRUUBODY(8801, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		SHIKRUULEGS(8802, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		SORROWBOW(20173, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		SORROWHELMET(8803, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		SORROWBODY(8804, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		SORROWCHAPS(8805, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		GANOSTAFF(8809, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		GANOHLMET(8806, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		GANOBODY(8807, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		GANOLEGS(8808, new Item[]{new Item(UPG_TOKEN, 8000)}, 14000, anim),
		PREDATOR1(8834, new Item[]{new Item(UPG_TOKEN, 4000)}, 15000, anim),
		PREDATOR2(8835, new Item[]{new Item(UPG_TOKEN, 4000)}, 15000, anim),
		PREDATOR3(8860, new Item[]{new Item(UPG_TOKEN, 4000)}, 15000, anim),
		PREDATOR4(8807, new Item[]{new Item(UPG_TOKEN, 4000)}, 15000, anim),
		PREDATOR5(8861, new Item[]{new Item(UPG_TOKEN, 4000)}, 15000, anim),
		PREDATOR6(8862, new Item[]{new Item(UPG_TOKEN, 4000)}, 15000, anim),
		PREDATOR7(15830, new Item[]{new Item(UPG_TOKEN, 4000)}, 15000, anim),
		TITANSTAFF(17600, new Item[]{new Item(UPG_TOKEN, 2300)}, 12300, anim),
		TITANCAPE(19944, new Item[]{new Item(UPG_TOKEN, 2300)}, 12300, anim),
		TITANHELMET(703, new Item[]{new Item(UPG_TOKEN, 2300)}, 12300, anim),
		TITANLEGS(705, new Item[]{new Item(UPG_TOKEN, 2300)}, 12300, anim),
		TITANBODY(704, new Item[]{new Item(UPG_TOKEN, 2300)}, 12300, anim),
		TITANBOOTS(19945, new Item[]{new Item(UPG_TOKEN, 2300)}, 12300, anim),
		TITANGLOVES(19946, new Item[]{new Item(UPG_TOKEN, 2300)}, 12300, anim),
		AGNELICHELMET(17638, new Item[]{new Item(UPG_TOKEN, 2999)}, 12999, anim),
		ANGELBODY(17640, new Item[]{new Item(UPG_TOKEN, 2999)}, 12999, anim),
		ANGELOEGS(15593, new Item[]{new Item(UPG_TOKEN, 2999)}, 12999, anim),
		ANGELICAMULET(16140, new Item[]{new Item(UPG_TOKEN, 2999)}, 12999, anim),
		ANGELICGLOVES(12860, new Item[]{new Item(UPG_TOKEN, 2999)}, 12999, anim),
		ANGELICWINGS(2021, new Item[]{new Item(UPG_TOKEN, 2999)}, 12999, anim),
		ANGLICBOOTS(12565, new Item[]{new Item(UPG_TOKEN, 2999)}, 12999, anim),
		LUCIENAXE(17714, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		LUCIENWINGS(17686, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		LUCIENHELMET(15924, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		LUCIENBODY(16023, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		LUCIENLEGS(15935, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		LUUCIENWHIP(15888, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		LUCIENDEFENDER(15818, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		LUCIENGLOVES(12994, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		HERCHELMET(15005, new Item[]{new Item(UPG_TOKEN, 4865)}, 14392, anim),
		LUCIENBOOTS(16272, new Item[]{new Item(UPG_TOKEN, 4392)}, 14392, anim),
		HERCULESSCYTHE(12284, new Item[]{new Item(UPG_TOKEN, 4865)}, 14865, anim),
		HERCULESCAPE(15100, new Item[]{new Item(UPG_TOKEN, 4865)}, 14865, anim),
		HERCULESBODY(15006, new Item[]{new Item(UPG_TOKEN, 4865)}, 14865, anim),
		HERCULESSHIELD(15008, new Item[]{new Item(UPG_TOKEN, 4865)}, 14865, anim),
		HERCULESLEGS(15007, new Item[]{new Item(UPG_TOKEN, 4865)}, 14865, anim),
		HERCULESGLOVES(15200, new Item[]{new Item(UPG_TOKEN, 4865)}, 4101, anim),
		HERCULESBOOTS(15201, new Item[]{new Item(UPG_TOKEN, 4865)}, 4101, anim),
		NEXTORVAHLMET(14008, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXTORVABODY(14009, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXTORVALEGS(14010, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXPERNIXCOWL(14011, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXPERNIXBODY(14012, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXPERNIXLEGS(14013, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXVIRTUSMASK(14014, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXVIRTUSBODY(14015, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		NEXVIRTUSLEGS(14016, new Item[]{new Item(UPG_TOKEN, 400)}, 1400, anim),
		TTTORVAHELMET(6927, new Item[]{new Item(UPG_TOKEN, 2000)}, 4101, anim),
		TTTORVALEGS(6929, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		TTROVABODY(6928, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		TTPERNIXHLMET(6930, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		SHUKAHELMET(8813, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		SHUKAHBODY(8814, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		SHUKAHLEGS(8815, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		TTPERNIXBODY(6931, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		TTPERNIXLEGS(6932, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		TTVIRTUSMASK(6933, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		TTVIRTUSBODY(6934, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		TTVIRTUSLEGS(6935, new Item[]{new Item(UPG_TOKEN, 2000)}, 12000, anim),
		GWDBANDOBODY(11724, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDBANDOBOOTS(11728, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDBANDOTASSETS(11726, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDSHARD_1(11710, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWD_SHARD2(11712, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWD_HILT1(11704, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWD_SHARD3(11714, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDZAMORAKHASTSA(11716, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWD_HILT2(11708, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDAMRABODY(11720, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		HWDARMAHELMET(11718, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDSARASWORD(11730, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDARMABODY(11722, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWD_HILT3(11702, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		FIREYBOW(16754, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDSARADOMINROBS(17235, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDSARAROBE2(15846, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
	
		GWDSARAROBBOTOM(15806, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDSRARROBE2(16863, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		GWDARAMACROSSBOW(22034, new Item[]{new Item(UPG_TOKEN, 240)}, 1240, anim),
		ABBYWHIP(4151, new Item[]{new Item(UPG_TOKEN, 120)}, 1240, anim),
		ABBYWHIP2(4152, new Item[]{new Item(UPG_TOKEN, 120)}, 1240, anim),
		FURY(6585, new Item[]{new Item(UPG_TOKEN, 141)}, 1141, anim),
		STAFFOFLIGHT(15486, new Item[]{new Item(UPG_TOKEN, 141)}, 1141, anim),
		STAFFOFLIGHTNOTE(15487, new Item[]{new Item(UPG_TOKEN, 141)}, 1141, anim),
		PVPMORHELMT(13876, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPSTAT(13896, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPSTAT2(13884, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPSTAT3(13890, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPSTATHAMMER(13902, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPVESTLEGS(13893, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPVETSALONG(13899, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPZURLEHELM(13864, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPZURBODY(13858, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPZURLEGS(13861, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPMORHELM(13878, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPMOREBODY(13870, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPMORELEGS(13873, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		GWDSARAHOOD(16753, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVFRSOTHELM(13922, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVFROSTHAMMER(13928, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVFROSTLEG(13916, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVFRSOTBODY(13910, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVMORRIHELM(13952, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVMOREBOYD(13946, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVMORELEGS(13949, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		REVPINKHOOD(13940, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPPINKSTAFF(13943, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPPINKBOYD(13934, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPPINKLEGS(13937, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPGOLDHOODY(13996, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPGILDSPEAR(13931, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPGILDBODY(13913, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPGILDLONG(13925, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		PVPGILDLEGS(13919, new Item[]{new Item(UPG_TOKEN, 169)}, 1169, anim),
		GZONEGS(18835, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEHELMET(18834, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEBODY(18801, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONELEGS(18800, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONECBOW(18799, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEGS2(18797, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEGS3(18798, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEGS4(18796, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEBANDOBOOTS(19794, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONESARASWORD(18792, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEZILYAHELM(15900, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEZILBODY(15845, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEBILLEGS(15805, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONETUTSPEAR(18790, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONEGS5(18789, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONETUTHALO(18791, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		GZONETUTBOOTS(18787, new Item[]{new Item(UPG_TOKEN, 310)}, 1310, anim),
		BARROW1(14499, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW2(14497, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW3(14501, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW4(4710, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO5(10350, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO6(10348, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO7(10346, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO8(4718, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO9(4753, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW10(4751, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW11(4757, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW12(4759, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW14(4755, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW13(4724, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW16(4728, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW18(4730, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW19(4726, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW20(4745, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW21(4749, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO22(4747, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW23(3751, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW222(3752, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW34(4734, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW35(17193, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW37(17339, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),

		TANKER_SHIELD(12933, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),

		DARK_BOW(11235, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		DARK_BOW2(11236, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		TANKER_BOOTS(15031, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),

		BARROW1_NOTE(14500, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW2_NOTE(14498, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW3_NOTE(14502, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW4_NOTE(4711, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO5_NOTE(10351, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO6_NOTE(10349, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO7_NOTE(10347, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO8_NOTE(4719, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO9_NOTE(4754, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW10_NOTE(4752, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW11_NOTE(4758, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW12_NOTE(4760, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW14_NOTE(4756, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW13_NOTE(4725, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW16_NOTE(4729, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW18_NOTE(4731, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW19_NOTE(4727, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW20_NOTE(4746, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW21_NOTE(4750, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARRO22_NOTE(4748, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW34_NOTE(4735, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW35_NOTE(17194, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		BARROW37_NOTE(17340, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),


		C_LONG(18351, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		C_RAP(18349, new Item[]{new Item(UPG_TOKEN, 50)}, 150, anim),
		C_MAUL(18353, new Item[]{new Item(UPG_TOKEN, 50)}, 4101, anim),
		C_STAFF(18355, new Item[]{new Item(UPG_TOKEN, 50)}, 4101, anim),
		C_CBOW(18357, new Item[]{new Item(UPG_TOKEN, 50)}, 4101, anim),
		WARRIOEHELM(4882, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		WARRIORAXE(4888, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		WARRIORLEGS1(4894, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		WARRIORBODY(4900, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		WARRIORSHIELD(18747, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		TORMENTEDDEFENDER(18684, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		TORMENTEDWHIP(18686, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		WARRIORGLOVES(20460, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		WARRIORBOOTS(20456, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		TOKHAARCAPE(19111, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		MAGEBEASTHELM(19140, new Item[]{new Item(UPG_TOKEN, 1000)}, 1000, anim),
		MAGEBEASTBODY(19139, new Item[]{new Item(UPG_TOKEN, 1000)}, 1000, anim),
		MEABEATSLEGS(19138, new Item[]{new Item(UPG_TOKEN, 1000)}, 1000, anim),
		DEMONMAUL(22078, new Item[]{new Item(UPG_TOKEN, 645)}, 1645, anim),
		IMPWINGS(4411, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		IMPBOW(16337, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		IMPCANNON(671, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		IMPCOIF(14415, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		IMPBODY(14395, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		IMPLEGS(14405, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		IMPGLOVES(672, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		IMPBOOTS(673, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		LORGRING(681, new Item[]{new Item(UPG_TOKEN, 200)}, 1200, anim),
		WARRIORSWORD(676, new Item[]{new Item(UPG_TOKEN, 200)}, 1200, anim),
		WARRIORSHIELD1(18363, new Item[]{new Item(UPG_TOKEN, 200)}, 1200, anim),
		WARRIORHELM(677, new Item[]{new Item(UPG_TOKEN, 200)}, 1200, anim),
		LORGSBODY(678, new Item[]{new Item(UPG_TOKEN, 200)}, 1200, anim),
		WARRIORLEGS(679, new Item[]{new Item(UPG_TOKEN, 200)}, 1200, anim),
		DEMONBIGMAUL(734, new Item[]{new Item(UPG_TOKEN, 530)}, 1530, anim),
		DEMONTOP(15424, new Item[]{new Item(UPG_TOKEN, 530)}, 1530, anim),
		DEMONHOOD(666, new Item[]{new Item(UPG_TOKEN, 530)}, 1530, anim),
		DEMONSKIRT(674, new Item[]{new Item(UPG_TOKEN, 530)}, 1530, anim),
		JOYXHELMET(675, new Item[]{new Item(UPG_TOKEN, 930)}, 4101, anim),
		JOYXBODY(702, new Item[]{new Item(UPG_TOKEN, 930)}, 1930, anim),
		JOYXLEGS(700, new Item[]{new Item(UPG_TOKEN, 930)}, 1930, anim),
		JOYXKITESHIELD(701, new Item[]{new Item(UPG_TOKEN, 930)}, 1930, anim),
		JOYXSWORD(17708, new Item[]{new Item(UPG_TOKEN, 930)}, 1930, anim),
		JOYXCAPE(17602, new Item[]{new Item(UPG_TOKEN, 930)}, 1930, anim),
		IMPNECK(19887, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		LORDCAPE(4393, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		LORDSWORD2(22075, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		REGLORDHELM(19471, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		REGLORDBODY(19470, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		RELORGLEGS(19469, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		DEMONWINNGS(4369, new Item[]{new Item(UPG_TOKEN, 350)}, 1000, anim),
		RAGNERBOW(18332, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		RANGERGLOVES(15026, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		MAGEICSTAFF(14377, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		MAGICBOOTS(10865, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		MAGICGLOVES(12864, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		RANGERBOOTS(10696, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		REGJOYXHELM(19153, new Item[]{new Item(UPG_TOKEN, 800)}, 1800, anim),
		REGJOYXBODY(19142, new Item[]{new Item(UPG_TOKEN, 800)}, 1800, anim),
		REGJOYXLEGS(19141, new Item[]{new Item(UPG_TOKEN, 800)}, 1800, anim),
		CHAOSRAP(18350, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		CHOAKITE(18360, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		CHAORSWORD(18352, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		CHOASCBOW(18358, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		CHAOSMAUL1(18354, new Item[]{new Item(UPG_TOKEN, 200)}, 1000, anim),
		RANGERHELMET(17043, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		RANGEBOYD(17175, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		RANGERLEGS(17321, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		ROW1(2572, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		FIRE_CAPE(6570, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		WHIP_COLOR_1(15441, new Item[]{new Item(UPG_TOKEN, 150)}, 1000, anim),
		WHIP_COLOR_2(15442, new Item[]{new Item(UPG_TOKEN, 150)}, 1000, anim),
		WHIP_COLOR_3(15443, new Item[]{new Item(UPG_TOKEN, 150)}, 1000, anim),
		WHIP_COLOR_4(15444, new Item[]{new Item(UPG_TOKEN, 150)}, 1000, anim),
		CYANTORVAHELMET(19931, new Item[]{new Item(UPG_TOKEN, 2100)}, 2100, anim),
		CYANTORVABODY(19933, new Item[]{new Item(UPG_TOKEN, 2100)}, 2100, anim),
		CYANTORVALEGS(19934, new Item[]{new Item(UPG_TOKEN, 2100)}, 2100, anim),
		ARCRAPIER(19919, new Item[]{new Item(UPG_TOKEN, 2100)}, 2100, anim),
		ARCMACE(19917, new Item[]{new Item(UPG_TOKEN, 2100)}, 2100, anim),
		CYANRING(7927, new Item[]{new Item(UPG_TOKEN, 2100)}, 2100, anim),
		MAGICGHAT(14733, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		MAGICBODY(14732, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		MAGICLEGS(14734, new Item[]{new Item(UPG_TOKEN, 100)}, 1000, anim),
		SILIG1(13746, new Item[]{new Item(UPG_TOKEN, 1200)}, 11200, anim),
		STAFF_OF_FESTIVE(14924, new Item[]{new Item(UPG_TOKEN, 500)}, 5200, anim),
		NATURE_BOW(14919, new Item[]{new Item(UPG_TOKEN, 500)}, 5200, anim),
		DEMNIC_SWORD(14915, new Item[]{new Item(UPG_TOKEN, 500)}, 5200, anim),
		DIVINE(13740, new Item[]{new Item(UPG_TOKEN, 2000)}, 14200, anim),
		DIVINE_NOTED(13741, new Item[]{new Item(UPG_TOKEN, 2000)}, 14200, anim),
		SIGIL2(13748, new Item[]{new Item(UPG_TOKEN, 1200)}, 11200, anim),
		SIGIL3(13750, new Item[]{new Item(UPG_TOKEN, 1200)}, 11200, anim),
		SIGIL4(13752, new Item[]{new Item(UPG_TOKEN, 1200)}, 11200, anim),
		DRAGON1(1149, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		BRAKISH(14017, new Item[]{new Item(UPG_TOKEN, 25)}, 180, anim),
		DRAGON9(6739, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		RUNNERHATI(3320, new Item[]{new Item(UPG_TOKEN, 25)}, 150, anim),
		NUETRON_DAGGER(15877, new Item[]{new Item(UPG_TOKEN, 50)}, 175, anim),
		NUETRON_HELM(15921, new Item[]{new Item(UPG_TOKEN, 50)}, 175, anim),
		NUETRON_BOOTS(16269, new Item[]{new Item(UPG_TOKEN, 50)}, 175, anim),
		NUETRON_GAUNTLETS(15943, new Item[]{new Item(UPG_TOKEN, 50)}, 175, anim),
		NUETRON_SHIELD(15815, new Item[]{new Item(UPG_TOKEN, 50)}, 175, anim),
		DRAGON2(1249, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON3(3204, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON4(1305, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON5(1215, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON6(1377, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON7(1434, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON8(7158, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON99(15031, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON939(15259, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON9339(15260, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON12(1150, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON92(6740, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON22(1250, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON32(3205, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON42(1306, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON52(1216, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON62(1378, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON72(1435, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON82(7159, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON822(1304, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON8232(1305, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON113(1434, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON8233(1435, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		DRAGON992(15032, new Item[]{new Item(UPG_TOKEN, 15)}, 150, anim),
		POTION_OF_FLIGHT(18719, new Item[]{new Item(UPG_TOKEN, 15_000)}, 1500, anim),
		COFFIN_OF_THE_DAMNED(7587, new Item[]{new Item(UPG_TOKEN, 15_000)}, 1500, anim),
		DEFAULT(1, new Item[]{new Item(UPG_TOKEN, 41)}, 4101, anim);

		DissolvingData(int id, Item[] rewards, int experience, int animation) {
			this.id = id;
			this.rewards = rewards;
			this.experience = experience;
			this.animation = animation;
		}

		private int id, experience, animation;

		public int getId() {
			return id;
		}
		public int getExperience() {
			return experience;
		}
		public int getAnimation() {
			return animation;
		}
		public int getreward() {
			return rewards[0].getId();
		}
		public int getrewardamt() {
			return rewards[0].getAmount();
		}

		private Item[] rewards;
		public Item[] getRewards() {
			return rewards;
		}

		public ItemDefinition getDefinition() {
			return ItemDefinition.forId(id);
		}
	}

	public int amtafterdissolvingall = 0;

	public void handle(int id) {
		for(DissolvingData data : DissolvingData.values()) {
			if(data.getId() == id) {
				player.getInventory().delete(id, 1);
				player.getInventory().addItemSet(data.getRewards());
				player.getSkillManager().addExperience(Skill.INVENTION, data.getExperience());
				player.performAnimation(new Animation(data.getAnimation()));
				player.getDailyTaskManager().submitProgressToIdentifier(4, data.getRewards()[0].getAmount());
				player.getPacketSender().sendMessage("You dissolved " + ItemDefinition.forId(id).getName() +" for " + Misc.insertCommasToNumber(data.getRewards()[0].getAmount()) +" Upgrade Tokens" );
				break;
			}
		}
		
	}

	private static Map<Integer, DissolvingData> dataMap = new HashMap<Integer, DissolvingData>();
		static {
			for (DissolvingData data : DissolvingData.values()) {
				dataMap.put(data.getId(),data);
			}
	}

	public void handleAll(int id) {
		for(DissolvingData data : DissolvingData.values()) {
			if(data.getId() == id) {
				player.getInventory().add(data.getreward(),data.getrewardamt() * player.getInventory().getAmount(data.getId()));
				player.howmuchdissolveamt+=data.getrewardamt() * player.getInventory().getAmount(data.getId());
				player.getSkillManager().addExperience(Skill.INVENTION, data.getExperience() * player.getInventory().getAmount(data.getId()));
				player.getPacketSender().sendMessage("You dissolved " + ItemDefinition.forId(id).getName() +" for " + Misc.insertCommasToNumber(data.getrewardamt() * player.getInventory().getAmount(data.getId())) +" Upgrade Tokens" );
				player.getInventory().delete(id, player.getInventory().getAmount(data.getId()));//only 1 gets dissolved is it possible to make it the amount of the stack in inventory
				player.performAnimation(new Animation(-1));
				break;
			}
		}

	}

	public int handleAllAmount(int slot) {
		return dataMap == null ? 0 : dataMap.get(player.getInventory().get(slot).getId()).getrewardamt() * player.getInventory().get(slot).getAmount();
	}

}

