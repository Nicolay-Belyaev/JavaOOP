public abstract class BaseHero {
    protected int offence;
    protected int defence;
    protected int hp;
    protected int speed;
    protected int maxDmg;
    protected int minDmg;
    protected String status;

    public BaseHero() {}

    public BaseHero(int offence, int defence, int hp, int speed, int minDmg, int maxDmg, String status) {
        this.offence = offence;
        this.defence = defence;
        this.hp = hp;
        this.speed = speed;
        this.maxDmg = maxDmg;
        this.minDmg = minDmg;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Class: %s  Hp: %d Status: %s" ,
                this.getClass().getSimpleName(), this.hp, this.status);
    }
}
