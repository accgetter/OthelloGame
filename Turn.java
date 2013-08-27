public class Turn {

    private             int CURRENT;
    public static final int BLACK   = 1;
    public static final int WHITE   = 2;

    public Turn () {
        CURRENT = BLACK;
    }

    public int getCurrentTurn () {
        return CURRENT;
    }

    public void turn () {
        CURRENT  = CURRENT == WHITE ? BLACK : WHITE;
    }

    public boolean isBlackTurn () {
        return CURRENT == BLACK;
    }

    public boolean isWhiteTurn () {
        return CURRENT == WHITE;
    }

}
