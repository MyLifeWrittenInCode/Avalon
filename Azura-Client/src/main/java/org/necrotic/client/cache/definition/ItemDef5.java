package org.necrotic.client.cache.definition;

public class ItemDef5 {

	public static ItemDefinition newIDS(ItemDefinition itemDef, int id) {

		switch (id) {

			case 23357:
				itemDef.copyItem(12608);
				itemDef.name = "Christmas Aura";
				itemDef.modelID = 20558;
				itemDef.femaleEquip1 = 20558;
				itemDef.maleEquip1 = 20558;
				itemDef.modelZoom = 3900;
				itemDef.rotationX = 0;
				itemDef.rotationY = 217;
				itemDef.rotationZ = 9;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = 23;
				break;

			case 23358:
				itemDef.copyItem(4407);
				itemDef.name = "Winter Cloak";
				itemDef.modelID = 20559;
				itemDef.maleEquip1 = 20559;
				itemDef.femaleEquip1 = 20559;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.modelZoom = 3500;
				itemDef.rotationX = 1070;
				itemDef.rotationY = 9;
				itemDef.rotationZ = 130;
				itemDef.modelOffsetX = -26;
				itemDef.modelOffsetY = -15;
				break;
			case 23359:
				itemDef.copyItem(6737);
				itemDef.name = "Reindeer Ring";
				itemDef.modelID = 20560;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelZoom = 1122;
				itemDef.rotationX = 1122;
				itemDef.rotationY = 322;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23360:
				itemDef.copyItem(6737);
				itemDef.name = "Santa's Maul";
				itemDef.modelID = 20580;
				itemDef.maleEquip1 = 20580;
				itemDef.femaleEquip1 = 20580;
				itemDef.modelZoom = 3200;
				itemDef.rotationX = 1226;
				itemDef.rotationY = 322;
				itemDef.rotationZ = 1643;
				itemDef.modelOffsetX = 26;
				itemDef.modelOffsetY = -252;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 23361:
				itemDef.copyItem(6737);
				itemDef.name = "Santa's Blaster";
				itemDef.modelID = 20581;
				itemDef.maleEquip1 = 20581;
				itemDef.femaleEquip1 = 20581;
				itemDef.modelZoom = 1104;
				itemDef.rotationX = 322;
				itemDef.rotationY = 1591;
				itemDef.rotationZ = 530;
				itemDef.modelOffsetX = 43;
				itemDef.modelOffsetY = -61;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23652:
				itemDef.copyItem(7478);
				itemDef.modelZoom = 432;
				itemDef.rotationX = 254;
				itemDef.rotationY = 415;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 3;
				break;
			case 23685:
				itemDef.copyItem(5074);
				itemDef.name = "Santa Pet";
				itemDef.modelID = MobDefinition.get(9400).npcModels[0];
				itemDef.modelZoom = 972 * 4;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				break;
			case 23686:
				itemDef.copyItem(5074);
				itemDef.name = "Evil Santa Pet";
				itemDef.modelZoom = 972 * 4;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = MobDefinition.get(9400).npcModels[0];
				itemDef.oldColors = new int[]{666, 655, 671, 675, 670, 673, 680, 660};
				itemDef.newColors = new int[]{4, 8, 12, 0, 11, 7, 16, 10};
				break;
			case 11316:
				itemDef.copyItem(5074);
				itemDef.modelZoom = 972 * 5;
				itemDef.name = "Double vote pet";
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = 20565;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23663:
				itemDef.copyItem(5074);
				itemDef.modelZoom = 1070 * 5;
				itemDef.name = "Nightmare pet";
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -10;
				itemDef.modelOffsetY = 25;
				itemDef.modelID = 14959;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23664:
				itemDef.copyItem(23663);
				itemDef.name = "Nightmare Transformer";
				break;
			case 23665:
				itemDef.copyItem(23664);
				itemDef.certID = 23664;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Nightmare Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23667:
				itemDef.copyItem(5074);
				itemDef.name = "Dragon king pet";
				itemDef.modelZoom = 5300;
				itemDef.rotationY = 520;
				itemDef.rotationX = 750;
				itemDef.modelOffsetX = 15;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -25;
				itemDef.modelID = 15079;
				itemDef.scaleX = 70;
				itemDef.scaleY = 70;
				itemDef.scaleZ = 70;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23668:
				itemDef.copyItem(23667);
				itemDef.name = "Dragon king Transformer";
				break;
			case 23669:
				itemDef.copyItem(23668);
				itemDef.certID = 23668;
				itemDef.scaleX = 100;
				itemDef.scaleY = 100;
				itemDef.scaleZ = 100;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Dragon king Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23670:
				itemDef.copyItem(5074);
				itemDef.name = "Vozzath pet";
				itemDef.modelZoom = 972 * 5;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = 19688;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23671:
				itemDef.copyItem(23670);
				itemDef.name = "Vozzath Transformer";
				break;
			case 23672:
				itemDef.copyItem(23671);
				itemDef.certID = 23671;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Vozzath Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23673:
				itemDef.copyItem(5074);
				itemDef.name = "Zenyte Golem pet";
				itemDef.modelZoom = 5000;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = 20540;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23674:
				itemDef.copyItem(23673);
				itemDef.name = "Zenyte Golem Transformer";
				break;
			case 23675:
				itemDef.copyItem(23674);
				itemDef.certID = 23674;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Zenyte Golem Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23655:
				itemDef.copyItem(23685);
				itemDef.name = "Santa Transformer";
				break;
			case 23651:
				itemDef.copyItem(23686);
				itemDef.name = "Evil Santa Transformer";
				itemDef.oldColors = new int[]{666, 655, 671, 675, 670, 673, 680, 660};
				itemDef.newColors = new int[]{4, 8, 12, 0, 11, 7, 16, 10};
				break;
			case 23661:
				itemDef.copyItem(11316);
				itemDef.name = "Vote boss Transformer";
				break;
			case 23662:
				itemDef.copyItem(23661);
				itemDef.certID = 23661;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Vote boss Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23653:
				itemDef.copyItem(23655);
				itemDef.certID = 23655;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Santa Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23654:
				itemDef.copyItem(23651);
				itemDef.certID = 23651;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Evil Santa Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				itemDef.oldColors = new int[]{666, 655, 671, 675, 670, 673, 680, 660};
				itemDef.newColors = new int[]{4, 8, 12, 0, 11, 7, 16, 10};
				break;
			case 23528:
				itemDef.copyItem(6737);
				itemDef.name = "Elf hat";
				itemDef.modelID = 20528;
				itemDef.maleEquip1 = 20529;
				itemDef.femaleEquip1 = 20529;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 681;
				itemDef.rotationX = 203;
				itemDef.rotationY = 228;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -6;
				break;
			case 23529:
				itemDef.copyItem(6737);
				itemDef.name = "Elf body";
				itemDef.modelID = 20530;
				itemDef.maleEquip1 = 20531;
				itemDef.femaleEquip1 = 20531;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 1283;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 1;
				break;
			case 23530:
				itemDef.copyItem(6737);
				itemDef.modelZoom = 1302;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = 7;
				itemDef.name = "Elf legs";
				itemDef.modelID = 20532;
				itemDef.maleEquip1 = 20533;
				itemDef.femaleEquip1 = 20533;
				itemDef.maleWieldY = 5;
				break;
			case 23531:
				itemDef.copyItem(6737);
				itemDef.name = "Elf boots";
				itemDef.modelID = 20536;
				itemDef.maleEquip1 = 20536;
				itemDef.femaleEquip1 = 20536;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 743;
				itemDef.rotationX = 203;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = -13;
				break;
			case 23532:
				itemDef.modelZoom = 494;
				itemDef.rotationX = 1703;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 90;
				itemDef.copyItem(6737);
				itemDef.name = "Elf gloves";
				itemDef.modelID = 20534;
				itemDef.maleEquip1 = 20535;
				itemDef.femaleEquip1 = 20535;
				break;
			case 23527:
				itemDef.copyItem(5074);
				itemDef.name = "Nihil Offspring";
				itemDef.modelID = 62717;
				itemDef.modelZoom = 4000;
				itemDef.colorChange = new double[]{0.2, 0.5, 1.0};
				break;
			case 23522: //Nihil's head
				itemDef.name = "Nihil head";
				itemDef.modelID = 65232;
				itemDef.maleEquip1 = 65232;
				itemDef.femaleEquip1 = 65232;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.modelZoom = 702;
				itemDef.rotationX = 1915;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.oldColors = new int[] {60, };
				itemDef.newColors = new int[] {91, };
				break;
			case 23523: //Nihil's body
				itemDef.name = "Nihil body";
				itemDef.modelID = 65234;
				itemDef.maleEquip1 = 65234;
				itemDef.femaleEquip1 = 65234;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.modelZoom = 1470;
				itemDef.rotationX = 2;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 51;
				itemDef.oldColors = new int[] {60, };
				itemDef.newColors = new int[] {91, };
				break;
			case 23524: //Nihil's legs
				itemDef.name = "Nihil legs";
				itemDef.modelID = 65236;
				itemDef.maleEquip1 = 65236;
				itemDef.femaleEquip1 = 65236;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.modelZoom = 1885;
				itemDef.rotationX = 2;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 4;
				itemDef.oldColors = new int[] {60, };
				itemDef.newColors = new int[] {91, }; //62
				break;
			case 23525:
				itemDef.name = "Nihil boots";
				itemDef.modelOffsetX = ItemDefinition.get(20119).modelOffsetX;
				itemDef.modelOffsetY = ItemDefinition.get(20119).modelOffsetY;
				itemDef.modelID = 100003;
				itemDef.maleEquip1 = 100003;
				itemDef.femaleEquip1 = 100003;
				itemDef.modelZoom = ItemDefinition.get(20119).modelZoom;
				itemDef.rotationY = ItemDefinition.get(20119).rotationY;
				itemDef.rotationX = ItemDefinition.get(20119).rotationX;
				itemDef.actions = ItemDefinition.get(20119).actions;
				itemDef.stackable = false;
				itemDef.colorChange = new double[]{0.1, 0.1, 3.1};
				break;
			case 23526:
				itemDef.name = "Nihil gloves";
				itemDef.modelID = 100004;
				itemDef.maleEquip1 = 100004;
				itemDef.femaleEquip1 = 100004;
				itemDef.rotationX = 1045;
				itemDef.rotationY = 826;
				itemDef.modelZoom = 1648;
				itemDef.modelOffsetX = 7;
				itemDef.modelOffsetY = 25;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.colorChange = new double[]{0.1, 0.1, 3.1};
				break;
			case 22166:
				itemDef.name = "Chance scroll";
				itemDef.modelID = 2774;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = 255;
				itemDef.rotationX = 1719;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 50;
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				itemDef.oldColors = new int[]{5440, 5452, 1938, 5427,};
				itemDef.newColors = new int[]{25823, 26638, 25823, 27823,};
				break;
			case 23512:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.9, 0, 0};
				break;
			case 23513:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0, 0.8, 0};
				break;
			case 23514:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0, 0, 1.2};
				break;
			case 23515:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.9, 0.5, 0};
				break;
			case 23516:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.8, 0, 0.8};
				break;
			case 23517:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.9, 0.9, 0};
				break;
			case 23510:
				itemDef.copyItem(4621);
				itemDef.name = "Turkey feather";
				itemDef.oldColors = new int[]{
						7512, 4011, 8150, 8670, 2880, 6084,
				};
				itemDef.newColors = new int[]{
						7481, 3360, 7481, 7481, 3345, 3345,
				};
				itemDef.actions = new String[]{"Claim", null, null, null, null};
				break;
			case 17580:
				itemDef.name = "Turkey Pet Mutation";
				itemDef.rdc2 = 65155;
				itemDef.actions = new String[]{null, null, null, null, null};
				break;
			case 23511:
				itemDef.copyItem(5074);
				itemDef.name = "Turkey Pet";
				itemDef.modelID = MobDefinition.get(8501).npcModels[0];
				itemDef.scaleX = 32;
				itemDef.scaleY = 32;
				itemDef.scaleZ = 32;
				itemDef.modelZoom = 909;
				itemDef.rotationX = 161;
				itemDef.rotationY = 144;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = -1;
				break;
			case 23508:
				itemDef.copyItem(23498);
				itemDef.name = "Grandmaster Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23509:
				itemDef.copyItem(23508);
				itemDef.certID = 23508;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Grandmaster Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23497:
				itemDef.copyItem(6737);
				itemDef.name = "Grandmaster hood";
				itemDef.modelID = 96496;
				itemDef.maleEquip1 = 96497;
				itemDef.femaleEquip1 = 96497;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.modelZoom = 868;
				itemDef.rotationX = 110;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = -15;
				break;
			case 23498:
				itemDef.copyItem(6737);
				itemDef.name = "Grandmaster body";
				itemDef.modelID = 96498;
				itemDef.maleEquip1 = 96499;
				itemDef.femaleEquip1 = 96499;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.modelZoom = 1387;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 2;
				break;
			case 23499:
				itemDef.copyItem(6737);
				itemDef.name = "Grandmaster legs";
				itemDef.modelID = 96500;
				itemDef.maleEquip1 = 96501;
				itemDef.femaleEquip1 = 96501;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.modelZoom = 1636;
				itemDef.rotationX = 2000;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 2;
				break;
			case 23483:
				itemDef.copyItem(4685);
				itemDef.name = "Legends Costume";
				break;
			case 23484:
				itemDef.copyItem(23483);
				itemDef.certID = 23483;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Legends Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23481:
				itemDef.copyItem(23260);
				itemDef.name = "Reaper Costume";
				itemDef.rdc2 = 37664;
				break;
			case 23482:
				itemDef.copyItem(23481);
				itemDef.certID = 23481;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Reaper Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23403:
				itemDef.copyItem(23477);
				itemDef.certID = 23477;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Lucifer Costume";
				itemDef.actions = new String[]{null, "Wear", "<col=C3C0B2>Dissolve", null, null};
				itemDef.stackable = false;
				break;
			case 23477:
				itemDef.copyItem(23810);
				itemDef.name = "Lucifer Costume";
				break;
			case 23809:
				itemDef.copyItem(14050);
				itemDef.name = "Lucifer helmet";
				itemDef.modelID = 100000;
				itemDef.maleEquip1 = 100000;
				itemDef.femaleEquip1 = 100000;
				break;
			case 23810:
				itemDef.copyItem(14051);
				itemDef.name = "Lucifer body";
				itemDef.modelID = 100001;
				itemDef.maleEquip1 = 100001;
				itemDef.femaleEquip1 = 100001;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23811:
				itemDef.copyItem(14052);
				itemDef.name = "Lucifer legs";
				itemDef.modelID = 100002;
				itemDef.maleEquip1 = 100002;
				itemDef.femaleEquip1 = 100002;
				break;
			case 23812:
				itemDef.copyItem(14602);
				itemDef.name = "Lucifer gloves";
				itemDef.modelID = 100003;
				itemDef.maleEquip1 = 100003;
				itemDef.femaleEquip1 = 100003;
				itemDef.modelZoom = 1000;
				break;
			case 23813:
				itemDef.name = "Lucifer boots";
				itemDef.modelID = 100004;
				itemDef.maleEquip1 = 100004;
				itemDef.femaleEquip1 = 100004;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23478:
				itemDef.copyItem(23815);
				itemDef.name = "Divine Costume";
				break;
			case 23395:
				itemDef.copyItem(23478);
				itemDef.certID = 23478;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Divine Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23814:
				itemDef.copyItem(14050);
				itemDef.name = "Divine helmet";
				itemDef.modelID = 100289;
				itemDef.maleEquip1 = 100290;
				itemDef.femaleEquip1 = 100290;
				break;
			case 23815:
				itemDef.copyItem(14051);
				itemDef.name = "Divine body";
				itemDef.modelID = 100294;
				itemDef.maleEquip1 = 100294;
				itemDef.femaleEquip1 = 100294;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23816:
				itemDef.copyItem(14052);
				itemDef.name = "Divine legs";
				itemDef.modelID = 100291;
				itemDef.maleEquip1 = 100292;
				itemDef.femaleEquip1 = 100292;
				break;
			case 23817:
				itemDef.copyItem(14602);
				itemDef.name = "Divine gloves";
				itemDef.modelID = 100287;
				itemDef.maleEquip1 = 100288;
				itemDef.femaleEquip1 = 100288;
				itemDef.modelZoom = 1000;
				break;
			case 23818:
				itemDef.name = "Divine boots";
				itemDef.modelID = 100286;
				itemDef.maleEquip1 = 100286;
				itemDef.femaleEquip1 = 100286;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23479:
				itemDef.copyItem(23820);
				itemDef.name = "Kismet Costume";
				break;
			case 23384:
				itemDef.copyItem(23479);
				itemDef.certID = 23479;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Kismet Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23819:
				itemDef.copyItem(14050);
				itemDef.name = "Kismet helmet";
				itemDef.modelID = 20356;
				itemDef.maleEquip1 = 20356;
				itemDef.femaleEquip1 = 20356;
				break;
			case 23820:
				itemDef.copyItem(14051);
				itemDef.name = "Kismet body";
				itemDef.modelID = 20430;
				itemDef.maleEquip1 = 20430;
				itemDef.femaleEquip1 = 20430;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23821:
				itemDef.copyItem(14052);
				itemDef.name = "Kismet legs";
				itemDef.modelID = 20431;
				itemDef.maleEquip1 = 20431;
				itemDef.femaleEquip1 = 20431;
				break;
			case 23822:
				itemDef.copyItem(14602);
				itemDef.name = "Kismet gloves";
				itemDef.modelID = 20408;
				itemDef.maleEquip1 = 20408;
				itemDef.femaleEquip1 = 20408;
				itemDef.modelZoom = 1000;
				break;
			case 23823:
				itemDef.name = "Kismet boots";
				itemDef.modelID = 20355;
				itemDef.maleEquip1 = 20355;
				itemDef.femaleEquip1 = 20355;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23480:
				itemDef.copyItem(23825);
				itemDef.name = "Lucky Costume";
				break;
			case 23385:
				itemDef.copyItem(23480);
				itemDef.certID = 23480;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Lucky Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23824:
				itemDef.copyItem(14050);
				itemDef.name = "Lucky helmet";
				itemDef.modelID = 20432;
				itemDef.maleEquip1 = 20432;
				itemDef.femaleEquip1 = 20432;
				break;
			case 23825:
				itemDef.copyItem(14051);
				itemDef.name = "Lucky body";
				itemDef.modelID = 20433;
				itemDef.maleEquip1 = 20433;
				itemDef.femaleEquip1 = 20433;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23826:
				itemDef.copyItem(14052);
				itemDef.name = "Lucky legs";
				itemDef.modelID = 20434;
				itemDef.maleEquip1 = 20434;
				itemDef.femaleEquip1 = 20434;
				break;
			case 23827:
				itemDef.copyItem(14602);
				itemDef.name = "Lucky gloves";
				itemDef.modelID = 20435;
				itemDef.maleEquip1 = 20435;
				itemDef.femaleEquip1 = 20435;
				itemDef.modelZoom = 1000;
				break;
			case 23828:
				itemDef.name = "Lucky boots";
				itemDef.modelID = 20436;
				itemDef.maleEquip1 = 20436;
				itemDef.femaleEquip1 = 20436;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23390:
				itemDef.copyItem(23473);
				itemDef.certID = 23473;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Omega Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23473:
				itemDef.copyItem(23795);
				itemDef.name = "Omega Costume";
				break;
			case 23794:
				itemDef.copyItem(14050);
				itemDef.name = "Omega helmet";
				itemDef.modelID = 20128;
				itemDef.maleEquip1 = 20128;
				itemDef.femaleEquip1 = 20128;
				break;
			case 23795:
				itemDef.copyItem(14051);
				itemDef.name = "Omega body";
				itemDef.modelID = 20181;
				itemDef.maleEquip1 = 20181;
				itemDef.femaleEquip1 = 20181;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23796:
				itemDef.copyItem(14052);
				itemDef.name = "Omega legs";
				itemDef.modelID = 20227;
				itemDef.maleEquip1 = 20227;
				itemDef.femaleEquip1 = 20227;
				break;
			case 23797:
				itemDef.copyItem(14602);
				itemDef.name = "Omega gloves";
				itemDef.modelID = 20278;
				itemDef.maleEquip1 = 20278;
				itemDef.femaleEquip1 = 20278;
				itemDef.modelZoom = 1000;
				break;
			case 23798:
				itemDef.name = "Omega boots";
				itemDef.modelID = 20296;
				itemDef.maleEquip1 = 20296;
				itemDef.femaleEquip1 = 20296;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 7677:
				itemDef.copyItem(23476);
				itemDef.certID = 23476;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Unknown Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23476:
				itemDef.copyItem(23805);
				itemDef.name = "Unknown Costume";
				break;
			case 23804:
				itemDef.copyItem(14050);
				itemDef.name = "Unknown helmet";
				itemDef.modelID = 20297;
				itemDef.maleEquip1 = 20297;
				itemDef.femaleEquip1 = 20297;
				break;
			case 23805:
				itemDef.copyItem(14051);
				itemDef.name = "Unknown body";
				itemDef.modelID = 20299;
				itemDef.maleEquip1 = 20299;
				itemDef.femaleEquip1 = 20299;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23806:
				itemDef.copyItem(14052);
				itemDef.name = "Unknown legs";
				itemDef.modelID = 20300;
				itemDef.maleEquip1 = 20300;
				itemDef.femaleEquip1 = 20300;
				break;
			case 23807:
				itemDef.copyItem(14602);
				itemDef.name = "Unknown gloves";
				itemDef.modelID = 20343;
				itemDef.maleEquip1 = 20343;
				itemDef.femaleEquip1 = 20343;
				itemDef.modelZoom = 1000;
				break;
			case 23808:
				itemDef.name = "Unknown boots";
				itemDef.modelID = 20354;
				itemDef.maleEquip1 = 20354;
				itemDef.femaleEquip1 = 20354;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23550:
				itemDef.copyItem(23800);
				itemDef.certID = 23800;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Necrotic Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23799:
				itemDef.copyItem(14050);
				itemDef.name = "Necromancer helmet";
				itemDef.modelID = 20105;
				itemDef.maleEquip1 = 20107;
				itemDef.femaleEquip1 = 20107;
				break;
			case 23800:
				itemDef.copyItem(14051);
				itemDef.name = "Necrotic Costume";
				itemDef.modelID = 20114;
				itemDef.maleEquip1 = 20115;
				itemDef.femaleEquip1 = 20115;
				break;
			case 23801:
				itemDef.copyItem(14052);
				itemDef.name = "Necromancer legs";
				itemDef.modelID = 20116;
				itemDef.maleEquip1 = 20116;
				itemDef.femaleEquip1 = 20116;
				break;
			case 23802:
				itemDef.copyItem(14602);
				itemDef.name = "Necromancer gloves";
				itemDef.modelID = 20117;
				itemDef.maleEquip1 = 20117;
				itemDef.femaleEquip1 = 20117;
				itemDef.modelZoom = 1000;
				break;
			case 23803:
				itemDef.name = "Necromancer boots";
				itemDef.modelID = 20118;
				itemDef.maleEquip1 = 20118;
				itemDef.femaleEquip1 = 20118;
				itemDef.modelZoom = 800;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23785:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine bow";
				itemDef.modelID = 19921;
				itemDef.maleEquip1 = 19923;
				itemDef.femaleEquip1 = 19923;
				itemDef.modelZoom = 2583;
				itemDef.rotationY = 391;
				itemDef.rotationX = 965;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 26;
				itemDef.modelOffsetY = -26;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23786:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine Wand";
				itemDef.modelID = 19937;
				itemDef.maleEquip1 = 19936;
				itemDef.femaleEquip1 = 19936;
				itemDef.modelZoom = 2409;
				itemDef.rotationY = 391;
				itemDef.rotationX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 4;
				itemDef.modelOffsetY = -4;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23787:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine Sword";
				itemDef.modelID = 19938;
				itemDef.maleEquip1 = 19939;
				itemDef.femaleEquip1 = 19939;
				itemDef.modelZoom = 2043;
				itemDef.rotationY = 391;
				itemDef.rotationX = 1243;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -4;
				itemDef.modelOffsetY = 0;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23783:
				itemDef.copyItem(15674);
				itemDef.name = "Sanguine box";
				itemDef.actions = new String[]{"Open", null, null, null, null};
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23788:
				itemDef.copyItem(10666);
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine Shield";
				itemDef.modelID = 19940;
				itemDef.maleEquip1 = 19941;
				itemDef.femaleEquip1 = 19941;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23789:
				itemDef.copyItem(14050);
				itemDef.name = "Sanguine helmet";
				itemDef.modelID = 19850;
				itemDef.maleEquip1 = 19876;
				itemDef.femaleEquip1 = 19876;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23790:
				itemDef.copyItem(14051);
				itemDef.name = "Sanguine body";
				itemDef.modelID = 19877;
				itemDef.maleEquip1 = 19900;
				itemDef.femaleEquip1 = 19900;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23791:
				itemDef.copyItem(14052);
				itemDef.name = "Sanguine legs";
				itemDef.modelID = 19901;
				itemDef.maleEquip1 = 19902;
				itemDef.femaleEquip1 = 19902;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23792:
				itemDef.copyItem(14602);
				itemDef.name = "Sanguine gloves";
				itemDef.modelID = 19914;
				itemDef.maleEquip1 = 19915;
				itemDef.femaleEquip1 = 19915;
				itemDef.modelZoom = 1000;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23793:
				itemDef.name = "Sanguine boots";
				itemDef.modelID = 19912;
				itemDef.maleEquip1 = 19912;
				itemDef.femaleEquip1 = 19912;
				itemDef.modelZoom = 800;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 9650:
				itemDef.name = "Sanguine Seed";
				itemDef.actions = new String[]{"Combine", null, null, null, null};
				itemDef.modelID = 19919;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelOffsetY = 8;
				itemDef.colorChange = new double[]{1.5, 0.1, 0.1};
				break;
			case 3062: //Costume Box
				itemDef.stackable = false;
				itemDef.name = "Costume Box";
				itemDef.modelZoom = 2695;
				itemDef.rotationX = 1576;
				itemDef.rotationY = 42;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 9;
				itemDef.modelOffsetY = -93;
				itemDef.actions = new String[]{null, null, null, null, null};
				break;
			case 23518:
				itemDef.modelID = 15177;
				itemDef.maleEquip1 = 15177;
				itemDef.femaleEquip1 = 15177;
				break;
			case 23519:
				itemDef.modelID = 15178;
				itemDef.maleEquip1 = 15178;
				itemDef.femaleEquip1 = 15178;
				break;
			case 23520:
				itemDef.modelID = 15188;
				itemDef.maleEquip1 = 15188;
				itemDef.femaleEquip1 = 15188;
				break;
			case 23461:
				itemDef.copyItem(11764);
				itemDef.name = "Hanto Costume";
				break;
			case 23462:
				itemDef.copyItem(23461);
				itemDef.certID = 23461;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Hanto Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23463:
				itemDef.copyItem(9482);
				itemDef.name = "Raditz Costume";
				break;
			case 23464:
				itemDef.copyItem(23463);
				itemDef.certID = 23463;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Raditz Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23465:
				itemDef.copyItem(9479);
				itemDef.name = "Goku Costume";
				break;
			case 23466:
				itemDef.copyItem(23465);
				itemDef.certID = 23465;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Goku Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23467:
				itemDef.copyItem(5069);
				itemDef.name = "Inuyasha Costume";
				break;
			case 23468:
				itemDef.copyItem(23467);
				itemDef.certID = 23467;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Inuyasha Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23469:
				itemDef.copyItem(22101);
				itemDef.name = "Fallen Angel Costume";
				break;
			case 23470:
				itemDef.copyItem(23469);
				itemDef.certID = 23469;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Fallen Angel Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23471:
				itemDef.copyItem(14069);
				itemDef.name = "Garfield Costume";
				break;
			case 23472:
				itemDef.copyItem(23471);
				itemDef.certID = 23471;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Garfield Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23521:
				itemDef.copyItem(23282);
				itemDef.name = "Vozzath Costume";
				break;
			case 23458:
				itemDef.copyItem(23521);
				itemDef.certID = 23521;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Vozzath Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23459:
				itemDef.copyItem(23221);
				itemDef.name = "Nephilim Costume";
				break;
			case 23460:
				itemDef.copyItem(23459);
				itemDef.certID = 23459;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Nephilim Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23448:
				itemDef.copyItem(14050);
				itemDef.name = "Turkey helmet";
				itemDef.modelID = 20437;
				itemDef.maleEquip1 = 20438;
				itemDef.femaleEquip1 = 20438;
				itemDef.rdc2 = 100777;
				break;
			case 23449:
				itemDef.copyItem(14051);
				itemDef.name = "Turkey body";
				itemDef.modelID = 20439;
				itemDef.maleEquip1 = 20440;
				itemDef.femaleEquip1 = 20440;
				itemDef.rdc2 = 100777;
				break;
			case 23450:
				itemDef.copyItem(14052);
				itemDef.name = "Turkey legs";
				itemDef.modelID = 20441;
				itemDef.maleEquip1 = 20442;
				itemDef.femaleEquip1 = 20442;
				itemDef.rdc2 = 100777;
				break;
			case 23451:
				itemDef.copyItem(23421);
				itemDef.name = "Turkey gloves";
				itemDef.modelID = 20448;
				itemDef.maleEquip1 = 20465;
				itemDef.femaleEquip1 = 20465;
				itemDef.rdc2 = 100777;
				break;
			case 23452:
				itemDef.copyItem(20456);
				itemDef.name = "Turkey boots";
				itemDef.modelID = 20466;
				itemDef.maleEquip1 = 20466;
				itemDef.femaleEquip1 = 20466;
				itemDef.rdc2 = 100777;
				break;
			case 23453:
				itemDef.copyItem(23449);
				itemDef.name = "Turkey Costume";
				itemDef.rdc2 = 100777;
				break;
			case 23454:
				itemDef.copyItem(23453);
				itemDef.certID = 23453;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Turkey Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;

			case 23455:
				itemDef.copyItem(14051);
				itemDef.name = "Dragon Rider Costume";
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{98};
				break;
			case 23456:
				itemDef.copyItem(23455);
				itemDef.certID = 23455;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Dragon Rider Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
		}
		return itemDef;
	}
}
