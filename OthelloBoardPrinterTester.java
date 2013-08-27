import junit.framework.*;

public class OthelloBoardPrinterTester extends TestCase {

    OthelloBoardPrinter ec_;

    public OthelloBoardPrinterTester (String name) { 
        super (name);
    }

    protected void setUp () {
        ec_ = new OthelloBoardPrinter ();
    }

    public void testConvertString () { 
        OthelloBoard board = new OthelloBoard();
        String boardStr = "  A B C D E F G H\n1 - - - - - - - -\n2 - - - - - - - -\n3 - - - - - - - -\n4 - - - ○ ● - - -\n5 - - - ● ○ - - -\n6 - - - - - - - -\n7 - - - - - - - -\n8 - - - - - - - -\n";
        assertEquals ( boardStr, ec_.convertString(board.getOthelloBoardData()) );
    }

    public void testDisplayOthelloBoard () { 

        try {
            OthelloBoard board = new OthelloBoard();
            Position position = new Position(1, "A");
            board.put(position);
            ec_.displayOthelloBoard(board);
        } catch ( Exception e ) {
        }
       
    }

}
