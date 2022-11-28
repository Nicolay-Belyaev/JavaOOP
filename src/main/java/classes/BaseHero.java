package classes;

import java.util.ArrayList;

public abstract class BaseHero implements BaseInterface {
    protected int offence;
    protected int defence;
    protected int currentHp;
    protected int maxHp;
    protected int speed;
    protected int maxDmg;
    protected int minDmg;
    protected String status;
    protected String className;
    protected ArrayList<BaseHero> side;
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
        target.setCurrentHp(target.currentHp - maxDmg);
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
    public void setCurrentHp(int currentHp) {this.currentHp = currentHp;}

    public CharsCoords getCoords() {return coords;}

    public String getClassName() {return className;}
    //endregion

    public void Step(ArrayList<BaseHero> foes) {}

    public String getInfo() {
        return String.format("%s Hp: %d/%d Status: %s ",
                this.className, this.currentHp, this.maxHp, this.status);
    }
}
