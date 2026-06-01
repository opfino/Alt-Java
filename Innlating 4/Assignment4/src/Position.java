import java.util.Objects;

public class Position {
    private int x; // column, 0-based
    private int y; // row, 0-based

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() { return x; }
    public int y() { return y; }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position next(Direction direction) {
        switch (direction) {
            case NORTH: return new Position(x, y - 1);
            case SOUTH: return new Position(x, y + 1);
            case WEST:  return new Position(x - 1, y);
            case EAST:  return new Position(x + 1, y);
            default: throw new IllegalArgumentException("Unknown direction: " + direction);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
