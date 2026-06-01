import java.util.ArrayList;
import java.util.List;

public class EastWall extends BoardElement {
    private final List<Position> wallCells = new ArrayList<>();

    // Wall is on the east side of the cells. Positive n runs north to south.
    public EastWall(int x, int y, int n) {
        int length = Math.abs(n);
        int step = n >= 0 ? 1 : -1;
        for (int i = 0; i < length; i++) {
            wallCells.add(new Position(x, y + i * step));
        }
    }

    @Override
    public void renderOn(BoardDisplay display) {
        for (Position p : wallCells) display.setEastWall(p.x(), p.y());
    }

    @Override
    public MoveResult interact(Robot robot, Direction direction) {
        int x = robot.getPosition().x();
        int y = robot.getPosition().y();
        for (Position p : wallCells) {
            boolean blockedFromWest = direction == Direction.EAST && p.x() == x && p.y() == y;
            boolean blockedFromEast = direction == Direction.WEST && p.x() == x - 1 && p.y() == y;
            if (blockedFromWest || blockedFromEast) return MoveResult.STOP;
        }
        return MoveResult.CONTINUE;
    }
}
