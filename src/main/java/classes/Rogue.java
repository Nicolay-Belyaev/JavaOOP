package classes;

import utils.Party;

public class Rogue extends BaseHero {
    public Rogue(Party side, int x, int y) {
        super(8, 3, 10, 6, 2, 4, "rogue", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}