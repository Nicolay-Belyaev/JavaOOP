package classes;

public class CharsCoords {
    double x, y;

    public CharsCoords(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(CharsCoords coords) {
        return this.x == coords.x && this.y == coords.y;
    }

    public double distance(CharsCoords char1){
        return Math.pow((Math.pow((x - char1.x), 2) + Math.pow((y - char1.y), 2)), 0.5);
    }
}

