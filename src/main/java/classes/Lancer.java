package classes;

import utils.Pair;
import utils.Party;

import java.util.ArrayList;

public class Lancer extends BaseHero {

    public Lancer(Party side, int x, int y, int amount) {
        super(4, 5, 10, 4, 1, 3, 1,"Lancer", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
        super.initialAmount = amount;
    }

    @Override
    public void step(Party foes) {
        Pair<BaseHero, Double> ClosedEnemyAndDistance = getClosedEnemyAndDistance(foes);
        BaseHero closedEnemy = ClosedEnemyAndDistance.getKey();

        ArrayList<CharsCoords> nearestLegalCells = new ArrayList<>();
        Party aliveAllies = this.side.getAliveHeroes();
        ArrayList<CharsCoords> aliveAlliesCoords = new ArrayList<>();
        for (BaseHero character : aliveAllies) {
            aliveAlliesCoords.add(character.coords);
        }

        final int[][] shifts = new int[][]{{-1, 1}, {0, 1}, {1, 1},{0, -1}, {1, 0}, {1, -1}, {1, -1}, {-1, 0}};
        for (int i = 0; i < 8; i++) {
            CharsCoords currentCell = new CharsCoords(this.coords.x + shifts[i][0], this.coords.y + shifts[i][1]);
            if (currentCell.equals(closedEnemy.coords)) {
                ActionAttack(closedEnemy);
                return;
            }
            if (!aliveAlliesCoords.contains(currentCell)) {
                nearestLegalCells.add(currentCell);
            }
        }

        CharsCoords cellWithMinDistance = nearestLegalCells.get(0);
        double localDistance = cellWithMinDistance.distance(closedEnemy.coords);
        for (CharsCoords nearestLegalCell : nearestLegalCells) {
            double currentDistance = nearestLegalCell.distance(closedEnemy.coords);
            if (currentDistance < localDistance) {
                localDistance = currentDistance;
                cellWithMinDistance = nearestLegalCell;
            }
        }
        this.coords = cellWithMinDistance;
    }
}
