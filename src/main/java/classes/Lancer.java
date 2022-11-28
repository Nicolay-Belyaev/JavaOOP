package classes;

import java.util.ArrayList;

public class Lancer extends BaseHero {

    public Lancer(ArrayList<BaseHero> side, int x, int y) {
        super(4, 5, 10, 4, 1, 3, "lancer", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}
