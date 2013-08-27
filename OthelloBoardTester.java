import junit.framework.*;

public class OthelloBoardTester extends TestCase {

    OthelloBoard ec_;

    public OthelloBoardTester (String name) { 
        super (name);
    }

    protected void setUp () {
       //ec_ = new OthelloBoard ();
    }

    public void testDefaultOthelloBoardPosition () { 

        ec_ = new OthelloBoard ();

        try {
            Position position = new Position(4, "D");
            assertEquals ( false, ec_.isEmpty(position) );
            assertEquals ( true, ec_.isWhite(position) );

            position = new Position(5, "D");
            assertEquals ( false, ec_.isEmpty(position) );
            assertEquals ( true, ec_.isBlack(position));

            position = new Position(4, "E");
            assertEquals ( false, ec_.isEmpty(position) );
            assertEquals ( true, ec_.isBlack(position));

            position = new Position(5, "E");
            assertEquals ( false, ec_.isEmpty(position) );
            assertEquals ( true, ec_.isWhite(position) );

        } catch ( Exception e ) {
        }
        assertEquals (  2, ec_.countBlack() );
        assertEquals (  2, ec_.countWhite() );
    }

    public void testCountStone () { 

        ec_ = new OthelloBoard ();

        try {

        Position position = new Position(4, "D");
        Stone stone = new Stone();
        ec_.change( position, stone.BLACK );
        assertEquals ( 3, ec_.countBlack() );
        assertEquals ( 1, ec_.countWhite() );

        } catch ( Exception e ) {
            fail("Should not throw exception");
        }
    }

    public void testPutStone () { 

        ec_ = new OthelloBoard();
        try {

            Position position = new Position(3, "D");
            ec_.put( position );
            assertEquals ( false, ec_.isEmpty(position) );

            Position position2 = new Position(4, "D");
            assertEquals ( true, ec_.isBlack(position2) );

        } catch ( Exception e ) {
        }

    }

    public void testPutStoneOnStone () { 

        OthelloBoard ec_ = new OthelloBoard();
        try {
            Position position = new Position(4, "D");
            ec_.put( position );
            fail("Should throw exception");
        } catch ( Exception e ) {
            // ここに来たら期待通り
        }

    }


    public void testPutStoneOnNoTurnCell () { 

        OthelloBoard ec_ = new OthelloBoard();
        try {
            Position position = new Position(6, "D");
            ec_.put( position );
            fail("Should throw exception");
        } catch ( Exception e ) {
            // ここに来たら期待通り
        }

    }

    public void testTryPutStone () {
        try {

            ec_                   = new OthelloBoard();
            Position position     = new Position(4, "C");
            Stone stone     = new Stone();

            ec_.change(position, stone.WHITE);
            position     = new Position(4, "E");
            ec_.change(position, stone.WHITE);
            position     = new Position(5, "C");
            ec_.change(position, stone.WHITE);
            position     = new Position(6, "C");
            ec_.change(position, stone.WHITE);
            position     = new Position(6, "D");
            ec_.change(position, stone.WHITE);
            position     = new Position(6, "E");
            ec_.change(position, stone.WHITE);

            position     = new Position(3, "B");
            ec_.change(position, stone.BLACK);
            position     = new Position(3, "D");
            ec_.change(position, stone.BLACK);
            position     = new Position(3, "F");
            ec_.change(position, stone.BLACK);

            position     = new Position(5, "B");
            ec_.change(position, stone.BLACK);
            position     = new Position(5, "F");
            ec_.change(position, stone.BLACK);

            position     = new Position(7, "B");
            ec_.change(position, stone.BLACK);
            position     = new Position(7, "D");
            ec_.change(position, stone.BLACK);
            position     = new Position(7, "F");
            ec_.change(position, stone.BLACK);

            position     = new Position(5, "D");
            ec_.change(position, stone.EMPTY);

            position     = new Position(5, "D");
            assertEquals( 8, ec_.tryPut(position) );

        } catch ( Exception e ) {
            fail("Should not throw exception");
        }
    }

    public void testGetOthelloBoardData () {

        ec_ = new OthelloBoard();
        String boardDataStr = "[[0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 2, 1, 0, 0, 0], [0, 0, 0, 1, 2, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0]]";
        assertEquals ( boardDataStr, ec_.getOthelloBoardData().toString() );

    }

    public void testTurnOneEmptyCell () {
        try {
            ec_ = new OthelloBoard();
            Position position = new Position(1, "D");
            ec_.turnOneStone(position);
            fail("Should throw exception");
        } catch ( Exception e ) {
        }

    }

    public void testTurnOne () {
        try {
            ec_ = new OthelloBoard();
            Position position = new Position(4, "D");
            ec_.turnOneStone(position);
            assertEquals( true, ec_.isBlack(position) );
        } catch ( Exception e ) {
            fail("Should not throw exception");
        }
    }

    public void testChange () {
        try {

            ec_                   = new OthelloBoard();
            Position position     = new Position(4, "D");
            Stone stone = new Stone();

            ec_.change(position, stone.EMPTY);
            assertEquals( true, ec_.isEmpty(position) );

            position = new Position(4, "D");
            ec_.change(position, stone.BLACK);
            assertEquals( true, ec_.isBlack(position) );

            position = new Position(4, "D");
            ec_.change(position, stone.WHITE);
            assertEquals( true, ec_.isWhite(position) );

        } catch ( Exception e ) {
            fail("Should not throw exception");
        }
    }

   public void testTurnAll () {
        try {

            ec_                   = new OthelloBoard();
            Position position     = new Position(4, "C");
            Stone stone     = new Stone();

            ec_.change(position, stone.WHITE);
            position     = new Position(4, "E");
            ec_.change(position, stone.WHITE);
            position     = new Position(5, "C");
            ec_.change(position, stone.WHITE);
            position     = new Position(6, "C");
            ec_.change(position, stone.WHITE);
            position     = new Position(6, "D");
            ec_.change(position, stone.WHITE);
            position     = new Position(6, "E");
            ec_.change(position, stone.WHITE);

            position     = new Position(3, "B");
            ec_.change(position, stone.BLACK);
            position     = new Position(3, "D");
            ec_.change(position, stone.BLACK);
            position     = new Position(3, "F");
            ec_.change(position, stone.BLACK);

            position     = new Position(5, "B");
            ec_.change(position, stone.BLACK);
            position     = new Position(5, "F");
            ec_.change(position, stone.BLACK);

            position     = new Position(7, "B");
            ec_.change(position, stone.BLACK);
            position     = new Position(7, "D");
            ec_.change(position, stone.BLACK);
            position     = new Position(7, "F");
            ec_.change(position, stone.BLACK);

            position     = new Position(5, "D");
            ec_.change(position, stone.EMPTY);
            ec_.put(position);

            position     = new Position(4, "C");
            assertEquals( true, ec_.isBlack(position) );
            position     = new Position(5, "C");
            assertEquals( true, ec_.isBlack(position) );
            position     = new Position(6, "C");
            assertEquals( true, ec_.isBlack(position) );
            position     = new Position(4, "D");
            assertEquals( true, ec_.isBlack(position) );

            position     = new Position(4, "E");
            assertEquals( true, ec_.isBlack(position) );
            position     = new Position(5, "E");
            assertEquals( true, ec_.isBlack(position) );
            position     = new Position(6, "E");
            assertEquals( true, ec_.isBlack(position) );
            position     = new Position(6, "D");
            assertEquals( true, ec_.isBlack(position) );

        } catch ( Exception e ) {
            fail("Should not throw exception");
        }
    }

}
