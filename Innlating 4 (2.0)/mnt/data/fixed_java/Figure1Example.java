public class Figure1Example {
    public static void main(String[] args) {
        Board board = new Board(4, 7);

        // Coordinates are 0-based: new Robot(column, row, name)
        Robot bb = new Robot(0, 0, "BB");
        Robot aa = new Robot(2, 1, "AA");
        Robot cc = new Robot(6, 3, "CC");

        board.addRobot(bb);
        board.addRobot(aa);
        board.addRobot(cc);

        board.addElement(new Goal(5, 2, "gg"));

        // Inner walls from figure 1.
        // Cell (2,3) in the PDF is 1-based, so it becomes (2,1) or (col=2,row=1) in 0-based code.
        board.addElement(new EastWall(2, 1));
        board.addElement(new SouthWall(2, 1));
        board.addElement(new SouthWall(3, 0));
        board.addElement(new SouthWall(4, 0));

        board.createDisplay().show();
    }
}
