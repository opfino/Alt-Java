public class BoardFrame extends BoardElement {
    private final int rows;
    private final int cols;

    public BoardFrame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void renderOn(BoardDisplay display) {
        // BoardDisplay always draws the outside frame automatically.
    }

    @Override
    public MoveResult interact(Robot robot, Direction direction) {
        Position next = robot.getPosition().next(direction);
        if (next.x() < 0 || next.x() >= cols || next.y() < 0 || next.y() >= rows) {
            return MoveResult.STOP;
        }
        return MoveResult.CONTINUE;
    }
}
