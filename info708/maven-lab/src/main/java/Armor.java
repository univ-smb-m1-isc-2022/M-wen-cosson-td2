public class Armor {
    private String name;
    private int dmgBloked;
    private int dmgReduced;

    public Armor(String name, int dmgBlocked, int dmgReduced) {
        this.name = name;
        this.dmgBloked = dmgBlocked;
        this.dmgReduced = dmgReduced;
    }

    public String getName() {
        return name;
    }

    public int getDmgBloked() {
        return dmgBloked;
    }

    public int getDmgReduced() {
        return dmgReduced;
    }
}
