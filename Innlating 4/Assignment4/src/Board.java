import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final int rows;
    private final int cols;
    private final List<Robot> robots = new ArrayList<>();
    private final List<BoardElement> elements = new ArrayList<>();

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        addElement(new BoardFrame(rows, cols));
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void addElement(BoardElement element) {
        elements.add(element);
    }

    public void move(Robot robot, Direction direction) {
        while (canMove(robot, direction)) {
            robot.step(direction);
            for (BoardElement element : elements) {
                element.afterStep(robot, direction, this);
            }
        }
    }

    private boolean canMove(Robot robot, Direction direction) {
        Position next = robot.getPosition().next(direction);
        if (hasRobotAt(next, robot)) return false;
        for (BoardElement element : elements) {
            if (element.interact(robot, direction) == MoveResult.STOP) return false;
        }
        return true;
    }

    public boolean hasRobotAt(Position position, Robot ignoredRobot) {
        for (Robot other : robots) {
            if (other != ignoredRobot && other.getPosition().equals(position)) return true;
        }
        return false;
    }

    public BoardDisplay createDisplay() {
        BoardDisplay display = new BoardDisplay(rows, cols);
        for (BoardElement element : elements) element.renderOn(display);
        for (Robot robot : robots) robot.renderOn(display);
        return display;
    }

    public boolean gameOver() {
        for (BoardElement element : elements) {
            if (element.gameOver(robots)) return true;
        }
        return false;
    }

    public List<BoardElement> elements() {
        return Collections.unmodifiableList(elements);
    }

    public List<Robot> robots() {
        return Collections.unmodifiableList(robots);
    }
}
