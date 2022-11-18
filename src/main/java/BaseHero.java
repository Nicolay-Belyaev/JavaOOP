public abstract class BaseHero {
    protected int offence;
    protected int defence;
    protected int currentHp;
    protected int maxHp;
    protected int speed;
    protected int maxDmg;
    protected int minDmg;
    protected String status;
    protected String className;

    public BaseHero(int offence, int defence, int maxHp, int speed, int minDmg, int maxDmg, String className, String status) {
        this.offence = offence;
        this.defence = defence;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.speed = speed;
        this.maxDmg = maxDmg;
        this.minDmg = minDmg;
        this.status = status;
        this.className = className;
    }

    @Override
    public String toString() {
        return String.format("Class: %s  Hp: %d Status: %s" ,
                this.getClass().getSimpleName(), this.currentHp, this.status);
    }
}
