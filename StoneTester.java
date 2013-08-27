import junit.framework.*;

public class StoneTester extends TestCase {

    Stone ec_ = new Stone();

    public void testValue () {
            assertEquals( 0, ec_.EMPTY );
            assertEquals( 1, ec_.BLACK );
            assertEquals( 2, ec_.WHITE );
    }
}
