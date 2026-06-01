public class Teleporter extends BoardElement {
    private final Position entrance;
    private final Position exit;
    private final String name;

    public Teleporter(int entranceX, int entranceY, int exitX, int exitY, String name) {
        this.entrance = new Position(entranceX, entranceY);
        this.exit = new Position(exitX, exitY);
        this.name = name;
    }

    @Override
    public void renderOn(BoardDisplay display) {
        display.set(entrance.x(), entrance.y(), AnsiColor.CYAN.apply(name));
        display.set(exit.x(), exit.y(), AnsiColor.CYAN.apply(name));
    }

    @Override
    public void afterStep(Robot robot, Direction direction, Board board) {
        if (robot.getPosition().equals(entrance) && !board.hasRobotAt(exit, robot)) {
            robot.moveTo(exit);
        } else if (robot.getPosition().equals(exit) && !board.hasRobotAt(entrance, robot)) {
            robot.moveTo(entrance);
        }
    }
}
