package Classes;

import java.util.ArrayList;

public class Rogue extends BaseHero {
    public Rogue(ArrayList<BaseHero> side, int x, int y) {
        super(8, 3, 10, 6, 2, 4, "rogue", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}