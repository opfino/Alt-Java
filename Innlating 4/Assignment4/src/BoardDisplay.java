public class BoardDisplay {
    private final String[][] grid;
    private final boolean[][] southWalls;
    private final boolean[][] eastWalls;
    private final int rows;
    private final int cols;

    public BoardDisplay(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new String[rows][cols];
        southWalls = new boolean[rows][cols];
        eastWalls = new boolean[rows][cols];
    }

    public void set(int x, int y, String content) {
        if (!isInside(x, y)) return;
        String plain = stripAnsi(content);
        if (plain.length() > 2) {
            content = content.substring(0, Math.min(content.length(), 2));
        }
        grid[y][x] = content;
    }

    public void setSouthWall(int x, int y) {
        if (isInside(x, y)) southWalls[y][x] = true;
    }

    public void setEastWall(int x, int y) {
        if (isInside(x, y)) eastWalls[y][x] = true;
    }

    private boolean isInside(int x, int y) {
        return x >= 0 && x < cols && y >= 0 && y < rows;
    }

    private String stripAnsi(String text) {
        return text.replaceAll("\\u001B\\[[;\\d]*m", "");
    }

    private String padCell(String content) {
        if (content == null) return "  ";
        String plain = stripAnsi(content);
        if (plain.length() == 0) return "  ";
        if (plain.length() == 1) return content + " ";
        return content;
    }

    public void show() {
        for (int x = 0; x < cols; x++) System.out.print("+--");
        System.out.println("+");

        for (int y = 0; y < rows; y++) {
            System.out.print("|");
            for (int x = 0; x < cols; x++) {
                System.out.print(padCell(grid[y][x]));
                System.out.print((eastWalls[y][x] || x == cols - 1) ? "|" : " ");
            }
            System.out.println();

            for (int x = 0; x < cols; x++) {
                System.out.print("+");
                System.out.print((southWalls[y][x] || y == rows - 1) ? "--" : "  ");
            }
            System.out.println("+");
        }
    }
}
