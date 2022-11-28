package classes;

import java.util.ArrayList;

public class Peasant extends BaseHero {
    private final int delivery = 1;

    public Peasant (ArrayList<BaseHero> side, int x, int y) {
        super(1, 1, 1, 3, 1, 1, "peasant", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}
