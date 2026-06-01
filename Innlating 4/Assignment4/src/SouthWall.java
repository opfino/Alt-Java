import java.util.ArrayList;
import java.util.List;

public class SouthWall extends BoardElement {
    private final List<Position> wallCells = new ArrayList<>();

    // Wall is on the south side of the cells. Positive n runs west to east.
    public SouthWall(int x, int y, int n) {
        int length = Math.abs(n);
        int step = n >= 0 ? 1 : -1;
        for (int i = 0; i < length; i++) {
            wallCells.add(new Position(x + i * step, y));
        }
    }

    @Override
    public void renderOn(BoardDisplay display) {
        for (Position p : wallCells) display.setSouthWall(p.x(), p.y());
    }

    @Override
    public MoveResult interact(Robot robot, Direction direction) {
        int x = robot.getPosition().x();
        int y = robot.getPosition().y();
        for (Position p : wallCells) {
            boolean blockedFromNorth = direction == Direction.SOUTH && p.x() == x && p.y() == y;
            boolean blockedFromSouth = direction == Direction.NORTH && p.x() == x && p.y() == y - 1;
            if (blockedFromNorth || blockedFromSouth) return MoveResult.STOP;
        }
        return MoveResult.CONTINUE;
    }
}
