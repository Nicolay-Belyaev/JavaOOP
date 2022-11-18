import java.util.Random;

public abstract class BaseHero {
    protected int offence;
    protected int defence;
    protected int hp;
    protected int speed;
    protected int maxDmg;
    protected int minDmg;
    protected String name;

    public BaseHero() {}

    public BaseHero(int offence, int defence, int hp, int speed, int damage, String name) {
        this.offence = offence;
        this.defence = defence;
        this.hp = hp;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Name: %s  Hp: %d  Type: %s",
                this.name, this.hp, this.getClass().getSimpleName());
    }
}
