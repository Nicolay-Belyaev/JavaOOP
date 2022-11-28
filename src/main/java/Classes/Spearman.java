package Classes;

import java.util.ArrayList;

public class Spearman extends BaseHero {

    public Spearman(ArrayList<BaseHero> side, int x, int y) {
        super(4, 5, 10, 4, 1, 3, "spearman", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}
