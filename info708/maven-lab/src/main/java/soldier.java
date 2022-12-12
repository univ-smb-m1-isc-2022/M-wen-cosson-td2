import java.util.ArrayList;
import java.util.List;

public class soldier {
    private String name;
    private int hp;
    private int currentHp;
    private List<Weapon> weapon;
    private Armor armor;
    private Shield shield;
    private int berzerk;
    int mainLibre;

    public soldier(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.currentHp = hp;
        this.weapon = new ArrayList<Weapon>();
        this.armor = null;
        this.shield = null;
        this.berzerk = -1;
        this.mainLibre = 2;
    }

    public int getHp() {
        return hp;
    }

    public List<Weapon> getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Shield getShield() {
        return shield;
    }

    public void addWeapon(Weapon weapon){
        if (this.mainLibre >= weapon.getNbMain()) {
            this.weapon.add(weapon);
            this.mainLibre -= weapon.getNbMain();
        }
    }

    public void addArmor(Armor armor){
        this.armor = armor;
    }

    public void addShield(Shield shield){
        if (this.mainLibre >= shield.getNbMain()) {
            this.shield = shield;
            this.mainLibre -= shield.getNbMain();
        }
    }

    public int getBerzerk() {
        return berzerk;
    }

    public void setBerzerk(int nb) {
        berzerk = nb;
    }

    public boolean dead() {
        return currentHp < 0;
    }

    public void suffer(int dmg, String weapon) {
        if (!shieldBlock(weapon) || shield == null) {
            int blocked = getBlockedDmg();
            currentHp -= dmg - blocked;
        }
    }

    private int getBlockedDmg() {
        int blocked = 0;
        if (armor != null) {
            blocked += armor.getDmgBloked();
        }
        return blocked;
    }
    private boolean shieldBlock(String weapon) {
        boolean res = false;
        if (shield != null) {
            if (shield.playable()) {
                if (shield.getDurability() > 0) {
                    res = true;
                    shield.use();
                    if (weapon.contains("axe")){
                        shield.useDurability();
                    }
                }
            }
            else {
                shield.reset();
            }
        }
        return res;
    }

    public int calculateDmag(int nbTurn) {
        int dmg = 0;
        if (weapon != null) {
            for (int i = 0; i < this.weapon.size(); i++) {
                if (this.weapon.get(i).playable()) {
                    dmg += this.weapon.get(i).getDmg();
                    this.weapon.get(i).used();
                }
                else {
                    this.weapon.get(i).resetCount();
                }
            }
        }
        if (armor != null) {
            dmg -= armor.getDmgReduced();
        }
        if (berzerk > 0) {
           if ( 1.0 * currentHp / hp *100 < berzerk ) {
               dmg = dmg * 2;
           }
        }
        return dmg;
    }

    public void displayStat() {
        System.out.println("name : " + this.name);
        System.out.println("hp : " + this.currentHp);
    }
}
