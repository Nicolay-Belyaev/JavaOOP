package classes;

import utils.Pair;
import utils.Party;

public abstract class BaseHero implements BaseInterface {
    protected int offence;
    protected int defence;
    protected int currentHp;
    protected int maxHp;
    protected int initiative;
    protected int maxDmg;
    protected int minDmg;
    protected String status;
    protected String className;
    protected Party side;
    protected CharsCoords coords;

    public BaseHero(int offence, int defence,
                    int maxHp, int initiative,
                    int minDmg, int maxDmg,
                    String className, String status) {
        this.offence = offence;
        this.defence = defence;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.initiative = initiative;
        this.maxDmg = maxDmg;
        this.minDmg = minDmg;
        this.status = status;
        this.className = className;
    }

    //region Amen and attack!
    public void step(Party foes) {}
    protected void ActionAttack(BaseHero target) {
        int damage = DamageCalc(target);
        target.getAttack(damage);
    }

    protected int DamageCalc(BaseHero target) {
        int damage;
        if (this.offence - target.defence > 0)      {damage = this.maxDmg;}
        else if (this.offence - target.defence < 0) {damage = this.minDmg;}
        else                                        {damage = (this.maxDmg + this.minDmg) / 2;}
        return damage;
    }

    public Pair<BaseHero, Double> getClosedEnemyAndDistance (Party foes) {
        Party aliveEnemies = foes.getAliveHeroes();
        BaseHero closedEnemy = aliveEnemies.get(0);
        double minDistance = this.coords.distance(closedEnemy.coords);
        for (BaseHero currentEnemy : aliveEnemies) {
            double enemyDistance = this.coords.distance(currentEnemy.coords);
            if (enemyDistance < minDistance) {
                minDistance = enemyDistance;
                closedEnemy = currentEnemy;
            }
        }
        return new Pair<>(closedEnemy, minDistance);
    }
    protected void getAttack(int damage) {
        this.currentHp = this.currentHp - damage;
        CheckStatus();
    }

    public void CheckStatus() {
        if (currentHp <= 0) {
            currentHp = 0;
            status = "dead";
        } else {status = "alive";}
    }
    //endregion

    public String getInfo() {
        return String.format("%s HP: %d/%d Status: %s",
                this.className, this.currentHp, this.maxHp, this.status);
    }

    public String getStatus() {return status;}
    public CharsCoords getCoords() {return coords;}
    public String getClassName() {return className;}
    public Party getSide() {return side;}
}