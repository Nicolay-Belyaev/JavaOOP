package classes;

import utils.Party;

public class Sharpshooter extends BaseHero {
    private int shots = 32;

    public Sharpshooter(Party side, int x, int y) {
        super(12, 10, 15, 9, 8, 10, "Sharpshooter", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
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
            ActionAttack(closedEnemy);
        }
    }
}

