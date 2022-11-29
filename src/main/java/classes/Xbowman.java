package classes;

import utils.Party;

public class Xbowman extends BaseHero {
    private int shots = 16;

    public Xbowman(Party side, int x, int y) {
        super(6, 3, 10, 4, 2, 3, "xbowman", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }

    private void ActionAttack(BaseHero target, double distance) {
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
        damage = distance < this.speed ? damage : damage/2;
        target.getAttack(damage);
    }

    @Override
    public void step(Party foes) {
        for (BaseHero character : side) {
            if (character.className.equals("peasant") && character.status.equals("alive")) {
                shots++;
                character.status = "occupied";
                break;
            }
        }
        if (shots != 0) {
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
            shots--;
            ActionAttack(closedEnemy, minDistance);
        }
    }
}
