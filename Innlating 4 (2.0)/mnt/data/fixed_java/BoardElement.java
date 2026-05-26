import java.util.List;

public abstract class BoardElement {
    public abstract void renderOn(BoardDisplay display);
    public abstract Position getPosition();

    public boolean blocks(Direction direction) {
        return false;
    }

    public boolean gameOver(List<Robot> robots) {
        return false;
    }
}
