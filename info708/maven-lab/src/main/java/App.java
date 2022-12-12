public class App
{
    public static void main( String[] args )
    {
        Effect poison = new Effect("poison", 20, 3);

        Weapon handSword = new Weapon("hand sword", 1, 5, null);
        Weapon handAxe = new Weapon("hand axe", 1, 6, null);
        Weapon greatSword = new Weapon("great sword", 2, 12, null);
        greatSword.setAttacknb(2);
        Weapon vicioushandaxe = new Weapon("vicious axe", 1, 6, poison);

        Shield buckler = new Shield("buckler", -1, 1, 1);
        Shield buckler2 = new Shield("buckler", -1, 1, 1);

        Armor armor = new Armor("armor", 3, 1);

        /*
        soldier swordsman = new soldier("swordsman", 100, handSword, null, null, -1);
        soldier viking = new soldier("viking", 120, handAxe, null, null, -1);
        soldier swordsmanB = new soldier("swordsman b", 100, handSword, null, buckler, -1);
        soldier vikingB = new soldier("viking b", 120, handAxe, null, buckler, -1);
        soldier swordsmanBA = new soldier("swordsman b", 100, handSword, armor, buckler, -1);
        soldier highlander = new soldier("Highlander", 150, greatSword, null, null, -1);
        soldier viciousSwordsman = new soldier("Vicious Swordsman", 100, vicioushandaxe, armor, buckler, -1);
        soldier veteranHighlande = new soldier("veteran Highlande", 150, greatSword, null, null, 30);

         */

        soldier swordsman = new soldier("swordsman", 100);
        swordsman.addWeapon(handSword);

        soldier viking = new soldier("viking", 120);
        viking.addWeapon(handAxe);

        soldier swordsmanB = new soldier("swordsman b", 100);
        swordsmanB.addWeapon(handSword);
        swordsmanB.addShield(buckler);
        soldier vikingB = new soldier("viking b", 120);
        vikingB.addWeapon(handAxe);
        vikingB.addShield(buckler2);
        soldier swordsmanBA = new soldier("swordsman b", 100);
        swordsmanBA.addArmor(armor);
        swordsmanBA.addShield(buckler);
        swordsmanBA.addWeapon(handSword);
        soldier highlander = new soldier("Highlander", 150);
        highlander.addWeapon(greatSword);
        soldier viciousSwordsman = new soldier("Vicious Swordsman", 100);
        viciousSwordsman.addWeapon(vicioushandaxe);
        viciousSwordsman.addShield(buckler);
        viciousSwordsman.addArmor(armor);
        soldier veteranHighlande = new soldier("veteran Highlande", 150);
        veteranHighlande.setBerzerk(30);
        veteranHighlande.addWeapon(greatSword);

        //System.out.println(game(swordsman, viking));
        //System.out.println(game(swordsmanB, vikingB));
        //printStat(swordsmanBA,highlander);
        //System.out.println(game(swordsmanBA, highlander));
        System.out.println(game(viciousSwordsman, veteranHighlande));
    }

    public static boolean game(soldier first, soldier second) {
        int nbturn = 1;

        while (!first.dead() && !second.dead()) {
            attack(first, second, nbturn);
            if (!second.dead()) {
                attack(second, first, nbturn);
            }
            nbturn++;
            printStat(first,second);
        }
        return first.dead();
    }

    private static void attack(soldier first, soldier second, int nbturn) {
        int firstDmg = first.calculateDmag(nbturn);
        second.suffer(firstDmg, first.getWeapon().get(0).getName());
    }

    private static void printStat(soldier first, soldier second) {
        first.displayStat();
        second.displayStat();
    }

}
