package classes;

import utils.Pair;
import utils.Party;

public class Sharpshooter extends BaseHero {
    private int shots = 32;

    public Sharpshooter(Party side, int x, int y, int amount) {
        super(12, 10, 15, 9, 8, 10, 1,"Sharpshooter", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
        super.initialAmount = amount;
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
            Pair<BaseHero, Double> closedEnemyAndDistance = getClosedEnemyAndDistance(foes);
            shots--;
            ActionAttack(closedEnemyAndDistance.getKey());
        }
    }
}

