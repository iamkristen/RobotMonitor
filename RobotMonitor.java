public class RobotMonitor {
    // constant (ensure you have at least MAX)
    public static final int GRID_SIZE = 6;
    public static final int START_ROW = 1;
    public static final int START_COL = 1;
    public static final int EXIT_ROW = 6;
    public static final int EXIT_COL = 6;

    // attributes
    private int row;
    private int col;
    private Move move;

    // invariant
    public boolean inv() {
        return (row >= 1 && row <= GRID_SIZE) && (col >= 1 && col <= GRID_SIZE);

    }

    // initialisation
    public RobotMonitor() {
        this.row = START_ROW;
        this.col = START_COL;
        this.move = Move.NONE;
    }

    // operations
    public int GetCol() {
        return col;
    }

    public int GetRow() {
        return row;
    }

    public Move GetMove() {
        return move;
    }

    public void MoveRight() {
        if (col < GRID_SIZE && move != Move.RIGHT) {
            col += 1;
            move = Move.RIGHT;
            return;
        }
        throw new VDMException("MoveRight() failed: Robot cannot move right.");
    }

    public void MoveLeft() {
        if (col > 1 && move != Move.LEFT) {
            col -= 1;
            move = Move.LEFT;
            return;
        }
        throw new VDMException("MoveLeft() failed: Robot cannot move left.");
    }

    public void MoveDown() {
        if (row < GRID_SIZE && move != Move.DOWN) {
            row += 1;
            move = Move.DOWN;
            return;
        }
        throw new VDMException("MoveDown() failed: Robot cannot move down.");
    }

    public void MoveUp() {
        if (row > 1 && move != Move.UP) {
            row -= 1;
            move = Move.UP;
            return;
        }
        throw new VDMException("MoveUp() failed: Robot cannot move up.");
    }

    public void Exit() {
        if (row == EXIT_ROW && col == EXIT_COL) {
            row = START_ROW;
            col = START_COL;
            move = Move.NONE;
            return;
        }
        throw new VDMException("Exit() failed: Robot is not at the exit position.");
    }

    // toString method added
    public String toString() {
        return "Robot Position: (" + row + ", " + col + "), Last Move: " + move;
    }
}