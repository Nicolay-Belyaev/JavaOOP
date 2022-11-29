package classes;

import utils.Party;

public class Peasant extends BaseHero {
    private final int delivery = 1;

    public Peasant (Party side, int x, int y) {
        super(1, 1, 1, 3, 1, 1, "peasant", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }

    @Override
    public void step(Party foes) {
        if (!this.status.equals("dead")) {
            this.status = "alive";
        }
    }
}
