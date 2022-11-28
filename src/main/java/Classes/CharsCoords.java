package Classes;

public class CharsCoords {
    int x, y;

    public CharsCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(CharsCoords coords) {
        return this.x == coords.x && this.y == coords.y;
    }
}

