package classes;

import utils.Party;

public abstract class BaseHero implements BaseInterface {
    protected int offence;
    protected int defence;
    protected float currentHp;
    protected int maxHp;
    protected int speed;
    protected int maxDmg;
    protected int minDmg;
    protected String status;
    protected String className;
    protected Party side;
    protected CharsCoords coords;

    public BaseHero(int offence, int defence,
                    int maxHp, int speed,
                    int minDmg, int maxDmg,
                    String className, String status) {
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

    protected void ActionAttack(BaseHero target) {
        float damage;
        if (this.offence - target.defence > 0) {
            damage = this.maxDmg;
        }
        else if (this.offence - target.defence < 0) {
            damage = this.minDmg;
        }
        else {
            damage = (this.maxDmg + this.minDmg) / 2;
        }
        target.getAttack(damage);
    }

    protected void getAttack(float damage) {
        this.currentHp = this.currentHp - damage;
        CheckStatus();
    }

    public void CheckStatus() {
        if (currentHp <= 0) {
            currentHp = 0;
            status = "dead";
        } else {
            status = "alive";
        }
    }

    //region get-set
    public void setCurrentHp(float currentHp) {this.currentHp = currentHp;}

    public String getStatus() {return status;}

    public CharsCoords getCoords() {return coords;}

    public String getClassName() {return className;}
    //endregion

    public void step(Party foes) {}

    public String getInfo() {
        return String.format("%s Hp: %d/%d Status: %s ",
                this.className, (int) this.currentHp, this.maxHp, this.status);
    }
}
