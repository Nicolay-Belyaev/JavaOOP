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
    protected int initialAmount;
    protected int currentAmount;
    protected String status;
    protected String className;
    protected Party side;
    protected CharsCoords coords;


    public BaseHero(int offence, int defence,
                    int maxHp, int initiative,
                    int minDmg, int maxDmg, int initialAmount,
                    String className, String status) {
        this.offence = offence;
        this.defence = defence;
        this.maxHp = maxHp;
        currentHp = maxHp;
        this.initiative = initiative;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.initialAmount = initialAmount;
        currentAmount = initialAmount;
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
        if (offence - target.defence > 0)      {damage = maxDmg;}
        else if (offence - target.defence < 0) {damage = minDmg;}
        else                                   {damage = (maxDmg + minDmg) / 2;}
        return damage * currentAmount;
    }

    public Pair<BaseHero, Double> getClosedEnemyAndDistance (Party foes) {
        Party aliveEnemies = foes.getAliveHeroes();
        if (aliveEnemies.size() == 0) {
            System.out.println("Game Over!");
            System.exit(0);
        }
        BaseHero closedEnemy = aliveEnemies.get(0);
        double minDistance = coords.distance(closedEnemy.coords);
        for (BaseHero currentEnemy : aliveEnemies) {
            double enemyDistance = coords.distance(currentEnemy.coords);
            if (enemyDistance < minDistance) {
                minDistance = enemyDistance;
                closedEnemy = currentEnemy;
            }
        }
        return new Pair<>(closedEnemy, minDistance);
    }
    protected void getAttack(int damage) {
        int stackHP = (currentAmount - 1) * maxHp + currentHp;
            stackHP -= damage;
            if (stackHP <= 0) {
                currentAmount = 0;
                currentHp = 0;
            } else {
                currentAmount = stackHP / maxHp;
                if (stackHP % maxHp != 0) {
                    currentHp = stackHP - currentAmount * maxHp;
                    currentAmount += 1;
                }
            }
        CheckStatus();
    }

    protected void getHeal(int heal) {
        this.currentHp += heal;
        if (currentHp > maxHp) { currentHp = maxHp;}
    }

    public void CheckStatus() {
        status = currentAmount <= 0? "dead" : "alive";
    }
    //endregion

    public String getInfo() {
        return String.format("%s HP: %d/%d Status: %s, Units: %d",
                className, currentHp, maxHp, status, currentAmount);
    }

    public String getStatus() {return status;}
    public CharsCoords getCoords() {return coords;}
    public String getClassName() {return className;}
    public Party getSide() {return side;}
    public int getInitialStackHp() {return initialAmount * maxHp;}
    public int getCurrentStackHp() {return (currentAmount - 1) * maxHp + currentHp;}
}