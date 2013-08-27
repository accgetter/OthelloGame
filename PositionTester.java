import junit.framework.*;

public class PositionTester extends TestCase {

    Position ec_;

    public PositionTester (String name) { 
        super (name);
    }

    protected void setUp () {
    }

    public void testGetRow() {
        try {
            ec_ = new Position (1, "A");
            assertEquals ( 0, ec_.getRow() );
        } catch ( Exception e ) {
        }
    }

    public void testGetColumn() {

        try {
        ec_ = new Position (1, "A");
        assertEquals ( 0, ec_.getColumn() );
        } catch ( Exception e ) {
        }
    }

    public void testGetColumnStr() {

        try {
        ec_ = new Position (1, "A");
        assertEquals ( "A", ec_.getColumnStr() );
        } catch ( Exception e ) {
        }
    }


    public void testGetColumnIndex() {

        try {
        ec_ = new Position (1, "A");
        assertEquals ( "A", ec_.getColumnStrByIndex(0) );
        } catch ( Exception e ) {
        }
    }
    public void testOutOfIndexParam() {

        try {
            ec_ = new Position (10, "A");
            fail("Should throw exception");
        } catch ( Exception e ) {
            // ここに来たら期待通り
        }

        try {
            ec_ = new Position (1, "J");
            fail("Should throw exception");
        } catch ( Exception e ) {
            // ここに来たら期待通り
        }

    }
}
