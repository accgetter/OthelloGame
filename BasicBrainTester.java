import junit.framework.*;

public class BasicBrainTester extends TestCase {

    private OthelloBoard othelloBoard;
    private BasicBrain basicBrain;

    public BasicBrainTester (String name) { 
        super (name);
    }

    protected void setUp () {
        othelloBoard = new OthelloBoard();
        basicBrain   = new BasicBrain();
    }

    public void testGetPutPosition () {
        try {
            Position position = basicBrain.getPutPosition( othelloBoard );
            assertEquals ( 2, position.getRow() );
            assertEquals ( 3, position.getColumn() );
        } catch ( Exception e ) {
            fail("Should not throw Exception " + e.getMessage());
        }
    }
}
