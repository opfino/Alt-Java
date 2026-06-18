public class Robot extends BoardElement {
    private final Position position;
    private final String name;
    private final AnsiColor color;

    public Robot(int x, int y, String name) {
        this(x, y, name, AnsiColor.RESET);
    }

    public Robot(int x, int y, String name, AnsiColor color) {
        this.position = new Position(x, y);
        this.name = name;
        this.color = color;
    }

    public Position getPosition() { return position; }
    public String getName() { return name; }

    public void step(Direction direction) {
        Position next = position.next(direction);
        position.set(next.x(), next.y());
    }

    public void moveTo(Position target) {
        position.set(target.x(), target.y());
    }

    @Override
    public void renderOn(BoardDisplay display) {
        display.set(position.x(), position.y(), color.apply(name));
    }
}
