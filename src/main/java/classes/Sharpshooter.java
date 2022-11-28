package classes;

import java.util.ArrayList;

public class Sharpshooter extends BaseHero {
    private final int shots = 32;

    public Sharpshooter(ArrayList<BaseHero> side, int x, int y) {
        super(12, 10, 15, 9, 8, 10, "sharpshooter", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
    }
}