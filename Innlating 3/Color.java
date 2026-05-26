
public class Color {
    public int r, g, b;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Color mixColors(Color a, Color b) {
        int red = (a.r + b.r) / 2;
        int green = (a.g + b.g) / 2;
        int blue = (a.b + b.b) / 2;
        return new Color(red, green, blue);
    }

    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Returns an ANSI escape sequence for foreground color only.
     * @param fg The foreground color
     * @return A String representing the foreground color
     */
    public static String fgColorCode(Color fg) {
        return String.format("\033[38;2;%d;%d;%dm", fg.r, fg.g, fg.b);
    }

    /**
    * Returns an ANSI escape sequence that can be used to color text
    * that is printed to the console. The following snippet will - if
    * BG represents a blue background color and FG represents a red
    * foreground color - print a red X on a blue background. The
    * ANSI_RESET variable is used to reset any coloring options.
    * {@snippet :
    * String ANSI_RESET = "\u001B[0m";
    * System.out.print(Color.colorCode(bg, fg) + "X" + ANSI_RESET);
    * }
    *
    * @param bg The background color
    * @param fg The foreground color
    * @return A String representing the desired fore-
    * and background color
    */
    public static String colorCode(Color bg, Color fg) {
    /*
    ANSI escape sequence for background and foreground
    color is captured by the code:
    \033[48;2;<br>;<bg>;<bb>;38;2;<fr>;<fg>;<fb>m
    */
    return String.format(
    "\033[48;2;%d;%d;%d;38;2;%d;%d;%dm",
    bg.r, bg.g, bg.b, fg.r, fg.g, fg.b);
    }
}