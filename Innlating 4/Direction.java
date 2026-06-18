public enum Direction {
    NORTH, SOUTH, WEST, EAST;

    public static Direction fromInput(String input) {
        String s = input.trim().toLowerCase();
        switch (s) {
            case "w":
            case "n":
            case "north":
                return NORTH;
            case "s":
            case "south":
                return SOUTH;
            case "a":
            case "west":
                return WEST;
            case "d":
            case "east":
                return EAST;
            default:
                return null;
        }
    }
}
