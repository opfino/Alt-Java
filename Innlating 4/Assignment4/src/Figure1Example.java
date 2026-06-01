public class Figure1Example {
    public static void main(String[] args) {
        Board board = new Board(4, 7);
        board.addRobot(new Robot(0, 0, "BB", AnsiColor.YELLOW));
        board.addRobot(new Robot(2, 1, "AA", AnsiColor.BLUE));
        board.addRobot(new Robot(6, 3, "CC", AnsiColor.RED));
        board.addElement(new Goal(5, 2, "gg"));
        board.addElement(new EastWall(2, 1, 1));
        board.addElement(new SouthWall(2, 1, 1));
        board.addElement(new SouthWall(3, 0, 2));
        board.createDisplay().show();
    }
}
