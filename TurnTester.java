import junit.framework.*;

public class TurnTester extends TestCase {

    Turn  ec_ = new Turn();

    public void testConstructer () {
            assertEquals( 1, ec_.getCurrentTurn() );
    }

    public void testStaticValue () {
            assertEquals( 1, ec_.BLACK );
            assertEquals( 2, ec_.WHITE );
    }

    public void testTurn () {
        Turn  ec_ = new Turn();
        ec_.turn();
        assertEquals( 2, ec_.getCurrentTurn() );
    }

    public void testIsWhiteTurn () {
        Turn  ec_ = new Turn();
        ec_.turn();
        assertEquals( true, ec_.isWhiteTurn() );
    }

    public void testIsBlackTurn () {
        Turn  ec_ = new Turn();
        ec_.turn();
        ec_.turn();
        assertEquals( true, ec_.isBlackTurn() );
    }
}
