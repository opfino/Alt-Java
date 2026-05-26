
import java.util.Arrays;

public class Grid {
// Fields
private int h;
private int w;
private char[][] grid;
private Color[][] colorGrid;

// Constructor parameterized by height and width of the grid
public Grid(int h, int w) {
    this.h = h;
    this.w = w;
    grid = new char[h][w];
    colorGrid = new Color[h][w];
    for(int i = 0; i < h; i++) {
        Arrays.fill(grid[i], ' ');
        // colorGrid[i] is already null
    }
}

public void drawRectangle(Rectangle rectangle) {
    int minX = Math.min(rectangle.getP1().getX(), rectangle.getP2().getX());
    int maxX = Math.max(rectangle.getP1().getX(), rectangle.getP2().getX());
    int minY = Math.min(rectangle.getP1().getY(), rectangle.getP2().getY());
    int maxY = Math.max(rectangle.getP1().getY(), rectangle.getP2().getY());
    for(int y = minY; y <= maxY; y++) {
        for(int x = minX; x <= maxX; x++) {
            if(x >= 0 && x < w && y >= 0 && y < h) {
                grid[y][x] = '#';
                colorGrid[y][x] = rectangle.getColor();
            }
        }
    }
}

public void drawCircle(Circle circle) {
    Point center = circle.getCenter();
    int radius = circle.getRadius();
    for(int y = 0; y < h; y++) {
        for(int x = 0; x < w; x++) {
            double dist = Math.sqrt((x - center.getX()) * (x - center.getX()) + (y - center.getY()) * (y - center.getY()));
            if(dist <= radius) {
                grid[y][x] = 'O';
                colorGrid[y][x] = circle.getColor();
            }
        }
    }
}

public void renderGrid() {
    ClearConsole();
    for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
            if (colorGrid[y][x] != null) {
                System.out.print(Color.fgColorCode(colorGrid[y][x]) + grid[y][x] + Color.ANSI_RESET);
            } else {
                System.out.print(grid[y][x]);
            }
        }
        System.out.println();
    }
}

private void ClearConsole() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec(new String[]{"clear"}).waitFor();
        }
    } catch (Exception ex) {
    System.err.println("Failed to clear console: " + ex.getMessage());
    // Or re-throw if critical: throw new RuntimeException(ex);
        }
    }
}