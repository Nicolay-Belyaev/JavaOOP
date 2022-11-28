package classes;

import java.util.ArrayList;

public class Crossbowman extends BaseHero {
    private final int shots = 16;

    public Crossbowman(ArrayList<BaseHero> side, int x, int y) {
        super(6, 3, 10, 4, 2, 3, "xbowman", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}
