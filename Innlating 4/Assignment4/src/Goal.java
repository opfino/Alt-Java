import java.util.List;

public class Goal extends BoardElement {
    private final Position position;
    private final String name;

    public Goal(int x, int y, String name) {
        this.position = new Position(x, y);
        this.name = name;
    }

    @Override
    public void renderOn(BoardDisplay display) {
        display.set(position.x(), position.y(), AnsiColor.GREEN.apply(name));
    }

    @Override
    public boolean gameOver(List<Robot> robots) {
        for (Robot robot : robots) {
            if (robot.getPosition().equals(position)) return true;
        }
        return false;
    }
}
