import java.util.*;
public class OthelloBoardPrinter implements OthelloBoardDisplay {

    private final static String[] cell  = {"-", "●", "○"};

    public void displayOthelloBoard ( OthelloBoard board ) {
        System.out.print(convertString(board.getOthelloBoardData()));
    }

    public String convertString ( ArrayList board ) {

        StringBuffer boardStr = new StringBuffer("");

        boardStr.append("  A B C D E F G H\n");

        for (int row = 0; row < 8; row++) {
                boardStr.append(row + 1);
            for (int column = 0; column < 8; column++) {
                ArrayList arrayList = (ArrayList) board.get(row);
                int cellStrType = new Integer(arrayList.get(column).toString());
                boardStr.append(" " + cell[cellStrType]);
                if (column == 7) {
                    boardStr.append("\n");
                }
            }
        }

        return boardStr.toString();

    }

}
