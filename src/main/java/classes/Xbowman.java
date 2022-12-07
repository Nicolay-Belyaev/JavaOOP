package classes;

import utils.Pair;
import utils.Party;

public class Xbowman extends BaseHero {
    private int shots = 16;

    public Xbowman(Party side, int x, int y, int amount) {
        super(6, 3, 11, 4, 2, 3, 1,"Xbowman", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
        super.initialAmount = amount;
    }

    private void ActionAttack(BaseHero target, double distance) {
        int damage = DamageCalc(target);
        damage = distance < initiative ? damage : damage/2;
        target.getAttack(damage);
    }

    @Override
    public void step(Party foes) {
        for (int i = 0; i < 2; i++) {
            for (BaseHero character : side) {
                if (character.className.equals("peasant") && character.status.equals("alive")) {
                    shots++;
                    character.status = "occupied";
                    break;
                }
            }
            if (shots != 0) {
                Pair<BaseHero, Double> closedEnemyAndDistance = getClosedEnemyAndDistance(foes);
                shots--;
                ActionAttack(closedEnemyAndDistance.getKey(), closedEnemyAndDistance.getValue());
            }
        }
    }
}
