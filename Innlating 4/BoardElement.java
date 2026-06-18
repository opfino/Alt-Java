import java.util.List;

public abstract class BoardElement {
    public abstract void renderOn(BoardDisplay display);

    public MoveResult interact(Robot robot, Direction direction) {
        return MoveResult.CONTINUE;
    }

    public void afterStep(Robot robot, Direction direction, Board board) {
        // Optional hook used by extensions such as Teleporter.
    }

    public boolean gameOver(List<Robot> robots) {
        return false;
    }
}
