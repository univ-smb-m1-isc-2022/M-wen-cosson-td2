public class Effect {
    private String name;
    private int dmg;
    private int durability;
    public Effect(String name, int dmg, int durability){
        this.name = name;
        this.dmg = dmg;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    public int getDurability() {
        return durability;
    }

    public void use() {
        this.durability -= 1;
    }
}
