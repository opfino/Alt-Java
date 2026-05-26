public class EastWall extends BoardElement {
    private Position position;

    public EastWall(int x, int y) {
        this.position = new Position(x, y);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void renderOn(BoardDisplay display) {
        display.setEastWall(position.x, position.y);
    }

    @Override
    public boolean blocks(Direction direction) {
        return direction == Direction.RIGHT;
    }
}
