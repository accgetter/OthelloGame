import java.util.*;
public class test {
    private final static ArrayList<ArrayList> board = new ArrayList<ArrayList>();
    private final static int CELL_EMPTY = 0;
    private final static int CELL_BLACK = 1;
    private final static int CELL_WHITE = 2;
    public static void main (String args[]) {
        for ( int row = 0; row < 8; row++ ) {
            ArrayList arrayList = new ArrayList();
            for ( int column = 0; column < 8; column++ ) {
                if ( (row == 4 && column == 3) || (row == 3 && column == 4) ) {
                    arrayList.add(column, CELL_BLACK);
                    continue;
                }
                if ( (row == 3 && column == 3) || (row == 4 && column == 4) ) {
                    arrayList.add(column, CELL_WHITE);
                    continue;
                }
                arrayList.add(column, CELL_EMPTY);
            }
            board.add(row, arrayList);
        }
        System.out.println( Collections.frequency(board.get(4), 4) );
        System.out.println( board.toString() );
    }
}
