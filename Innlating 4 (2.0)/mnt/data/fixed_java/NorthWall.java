public class NorthWall extends BoardElement {
    private Position position;

    public NorthWall(int x, int y) {
        this.position = new Position(x, y);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void renderOn(BoardDisplay display) {
        display.setNorthWall(position.x, position.y);
    }

    @Override
    public boolean blocks(Direction direction) {
        return direction == Direction.UP;
    }
}
