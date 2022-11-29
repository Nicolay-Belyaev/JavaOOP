package classes;

import utils.Party;

public class Lancer extends BaseHero {

    public Lancer(Party side, int x, int y) {
        super(4, 5, 10, 4, 1, 3, "lancer", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}
