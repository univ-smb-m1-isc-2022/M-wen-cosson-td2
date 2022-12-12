public class Weapon {
    private String name;
    private int nbMain;
    private int dmg;
    private Effect effect;

    private int attacknb;
    private int nbAtDone;
    //attack number
    //nb attack
    // on l incremente a chaque attaque et on test si different de nbattack pour pouvoir attaquer 2 tour sur 3 ou etc

    public Weapon(String name, int nbMain, int dmg, Effect effect) {
        this.name = name;
        this.nbMain = nbMain;
        this.dmg = dmg;
        this.effect = effect;
        this.attacknb = -1;
        this.nbAtDone = 0;
    }

    public void setAttacknb(int nb) {
        this.attacknb = nb;
    }

    public int getAttacknb(){return this.attacknb;}

    public String getName() {
        return this.name;
    }

    public int getNbMain() {
        return this.nbMain;
    }

    public int getDmg() {
        int dam = this.dmg;
        if (this.effect != null) {
            if (this.effect.getDurability() > 0) {
                dam += this.effect.getDmg();
                this.effect.use();
            }
        }
        return dam;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public boolean playable() {
        return this.nbAtDone != this.attacknb;
    }

    public void used() {
        this.nbAtDone++;
    }

    public void resetCount() {
        this.nbAtDone = 0;
    }
}
