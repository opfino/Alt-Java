public class Robot extends BoardElement {
    private Position position;
    private String name;

    public Robot(int x, int y, String name) {
        this.position = new Position(x, y);
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void step(Direction direction) {
        switch (direction) {
            case UP:    position.y--; break;
            case DOWN:  position.y++; break;
            case LEFT:  position.x--; break;
            case RIGHT: position.x++; break;
        }
    }

    @Override
    public void renderOn(BoardDisplay display) {
        display.set(position.x, position.y, name);
    }
}
