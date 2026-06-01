import java.util.Scanner;

public class Game {
    private final Board board;

    public Game() {
        board = new Board(4, 7);

        Robot bb = new Robot(0, 0, "BB", AnsiColor.YELLOW);
        Robot aa = new Robot(2, 1, "AA", AnsiColor.BLUE);
        Robot cc = new Robot(6, 3, "CC", AnsiColor.RED);

        board.addRobot(bb);
        board.addRobot(aa);
        board.addRobot(cc);

        board.addElement(new Goal(5, 2, "gg"));

        // Inner walls matching the assignment's Figure 1, using 0-based coordinates.
        board.addElement(new EastWall(2, 1, 1));
        board.addElement(new SouthWall(2, 1, 1));
        board.addElement(new SouthWall(3, 0, 2));

        // Extension: teleporter pair. A robot that lands on TP is moved to the other TP.
        board.addElement(new Teleporter(0, 2, 6, 0, "TP"));
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int moves = 0;

        while (!board.gameOver()) {
            clearConsole();
            board.createDisplay().show();
            System.out.println("Moves: " + moves);
            System.out.println("Robots: " + robotNames());
            System.out.print("Choose robot, or q to quit: ");
            String robotName = scanner.nextLine().trim();

            if (robotName.equalsIgnoreCase("q")) {
                System.out.println("Game quit.");
                return;
            }

            Robot chosen = findRobot(robotName);
            if (chosen == null) {
                System.out.println("No robot named " + robotName + ". Press Enter to continue.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Direction (w/a/s/d or north/south/west/east): ");
            Direction direction = Direction.fromInput(scanner.nextLine());
            if (direction == null) {
                System.out.println("Invalid direction. Press Enter to continue.");
                scanner.nextLine();
                continue;
            }

            board.move(chosen, direction);
            moves++;
        }

        clearConsole();
        board.createDisplay().show();
        System.out.println("You won in " + moves + " moves!");
    }

    private Robot findRobot(String name) {
        for (Robot robot : board.robots()) {
            if (robot.getName().equalsIgnoreCase(name)) return robot;
        }
        return null;
    }

    private String robotNames() {
        StringBuilder builder = new StringBuilder();
        for (Robot robot : board.robots()) {
            if (builder.length() > 0) builder.append(", ");
            builder.append(robot.getName());
        }
        return builder.toString();
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        new Game().play();
    }
}
