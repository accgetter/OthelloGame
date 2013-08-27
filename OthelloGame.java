// オセロゲーム実行クラス
import java.util.*;
public class OthelloGame {

    public static void main(String args[]) {

        OthelloBoard board               = new OthelloBoard(); 
        OthelloBoardPrinter boardPrinter = new OthelloBoardPrinter(); 
        Stone stone                      = new Stone();
        BasicBrain basicBrain            = new BasicBrain();

        while (true) {

            boardPrinter.displayOthelloBoard(board);
            System.out.println("Black:" + board.countBlack() + " White:" + board.countWhite() + "\n");

            if ( board.turn.isBlackTurn() ) {
                System.out.println("Please put black stone.");
            }

            Scanner scan  = new Scanner(System.in);

            if ( board.turn.isBlackTurn() ) {

                String row    = scan.next();

                if ( row.equals("pass") ) {
                    board.turn.turn();  
                } else if ( row.equals("end") ) {
                    break;
                } else {

                    String column = scan.next();

                    try {
                        Position position = new Position(Integer.valueOf(row), column);
                        board.put(position);
                    } catch ( Exception e ) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                try {
                    System.out.print("White turn thinking ");
                    for (int s = 6; s >= 1; s--) {
                        System.out.print(".");
                        try{
                            Thread.sleep(500); 
                        }catch(InterruptedException e){}
                    }
                    Position position = basicBrain.getPutPosition( board );
                    board.put(position);
                    System.out.println("\n\nWhite turn has put.");
                } catch ( Exception e ) {
                    board.turn.turn();  
                    try {
                        Position position = basicBrain.getPutPosition( board );
                    } catch ( Exception ex ) {
                        System.out.println("\n\nGame Over.");
                        if ( board.countBlack() >  board.countWhite() ) {
                            System.out.println("Black WIN!!");
                        } else if ( board.countBlack() <  board.countWhite() ) {
                            System.out.println("White WIN!!");
                        } else if ( board.countBlack() ==  board.countWhite() ) {
                            System.out.println("DRAW...");
                        }
                        break;
                    }
                }
            }
        }
    }
}
