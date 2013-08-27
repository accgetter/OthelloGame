// オセロボードの状態を保持、参照するクラス
import java.util.*;
public class OthelloGame {
    public static void main(String args[]) {

        //boolean power      = true; // true: ON 、false: OFF
        OthelloBoard board               = new OthelloBoard(); 
        OthelloBoardPrinter boardPrinter = new OthelloBoardPrinter(); 

        while (true) {

           boardPrinter.displayOthelloBoard(board);

           Scanner scan  = new Scanner(System.in);

           int row       = scan.nextInt();
           String column = scan.next();

           try {
               Position position = new Position(row, column);
               board.put(position);
           } catch ( Exception e ) {
               System.out.println(e.getMessage());
               continue;
           }

        }

    }
}
