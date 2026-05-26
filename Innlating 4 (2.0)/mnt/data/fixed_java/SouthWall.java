public class SouthWall extends BoardElement {
    private Position position;

    public SouthWall(int x, int y) {
        this.position = new Position(x, y);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void renderOn(BoardDisplay display) {
        display.setSouthWall(position.x, position.y);
    }

    @Override
    public boolean blocks(Direction direction) {
        return direction == Direction.DOWN;
    }
}
