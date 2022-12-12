public class Shield {
    private String name;
    private int dmgBlocked;
    private int nbMain;
    private int durability;
    private int played;

    private int block;

    public Shield(String name, int dmgBlocked, int nbMain, int block) {
        this.name = name;
        this.dmgBlocked = dmgBlocked;
        this.nbMain = nbMain;
        this.block = block;
        this.played = 0;
        this.durability = 3;
    }

    public String getName() {
        return name;
    }

    public int getDmgBlocked() {
        return dmgBlocked;
    }

    public int getNbMain() {
        return nbMain;
    }

    public int getDurability() {
        return durability;
    }

    public void useDurability() { this.durability -= 1;}

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void use() {
        this.played++;;
    }

    public boolean playable() {
        return this.block != this.played && this.durability > 0;
    }

    public void reset() {
        this.played = 0;
    }
}
