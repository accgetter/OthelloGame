public class BasicBrain implements Brain {
    private Position position;
    public Position getPutPosition ( OthelloBoard othelloBoard ) throws Exception {
        for ( int row = 0; row < 8; row++ ) {
            for ( int column = 0; column < 8; column++ ) {
                try {
                    position = new Position( row, column );
                } catch ( Exception e ) {
                    throw new Exception(" 予期せぬエラーです ");
                }
                if ( othelloBoard.isEmpty(position) && othelloBoard.tryPut(position) > 0 ) {
                    return position;
                }
            }
        }
        throw new Exception(" Can't put ");
    }
}
