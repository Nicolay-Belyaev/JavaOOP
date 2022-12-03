package classes;

import java.util.Objects;

public class CharsCoords {
    double x, y;

    public CharsCoords(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharsCoords that = (CharsCoords) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    public Double distance(CharsCoords char1){
        return Math.pow((Math.pow((x - char1.x), 2) + Math.pow((y - char1.y), 2)), 0.5);
    }
}

