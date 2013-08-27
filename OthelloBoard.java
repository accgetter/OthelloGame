// オセロボードの状態を保持、変更、参照するクラス
import java.util.*;
public class OthelloBoard {

    private ArrayList<ArrayList> board = new ArrayList<ArrayList>();

    Stone  stone = new Stone();
    public Turn  turn;

    public OthelloBoard () {

        turn = new Turn();

        for ( int row = 0; row < 8; row++ ) {
            ArrayList arrayList = new ArrayList();
            for ( int column = 0; column < 8; column++ ) {
                if ( (row == 4 && column == 3) || (row == 3 && column == 4) ) {
                    arrayList.add(column, stone.BLACK);
                    continue;
                }
                if ( (row == 3 && column == 3) || (row == 4 && column == 4) ) {
                    arrayList.add(column, stone.WHITE);
                    continue;
                }
                arrayList.add(column, stone.EMPTY);
            }
            board.add(row, arrayList);
        }

    }

    public int countWhite () { 
        int wCount = 0;
        for ( int row = 0; row < 8; row++ ) {
            wCount += Collections.frequency(board.get(row), stone.WHITE);
        }
        return wCount;
    }

    public int countBlack () { 
        int bCount = 0;
        for ( int row = 0; row < 8; row++ ) {
            bCount += Collections.frequency(board.get(row), stone.BLACK);
        }
        return bCount;
    }

    public boolean isEmpty ( Position position ) { 
        int cellCondition = new Integer( board.get(position.getRow()).get(position.getColumn()).toString() );
        return (cellCondition == stone.EMPTY);
    }

    public boolean isBlack ( Position position ) { 
        int cellCondition = new Integer( board.get(position.getRow()).get(position.getColumn()).toString() );
        return (cellCondition == stone.BLACK);
    }

    public boolean isWhite ( Position position ) { 
        int cellCondition = new Integer( board.get(position.getRow()).get(position.getColumn()).toString() );
        return (cellCondition == stone.WHITE);
    }

    public void put ( Position position ) throws Exception { 
        if ( isEmpty( position ) && tryPut( position ) > 0 ) {
            board.get(position.getRow()).set(position.getColumn(), turn.getCurrentTurn());
            turnAll(position);
            turn.turn();
        } else {
            throw new Exception("そこは置けません。もう一度考えてください。");
        }
    }

    public void change ( Position position, int stone ) throws Exception { 
        board.get(position.getRow()).set(position.getColumn(), stone);
    }

    public void turnOneStone ( Position position ) throws Exception {
        if ( isEmpty(position) ) {
            throw new Exception("想定外のエラーです");
        }
        change( position, turn.getCurrentTurn() );
    }

    public void turnAll ( Position position ) { 

        ArrayList<Position> turnCellsArr = new ArrayList<Position>(); 
        int r = position.getDispRow();
        int c = position.getColumn();

        // 各方向の石を裏返す
        // 上
        for (int i = r - 1; i >= 0; i--) {
            try {
                Position p = new Position(i, position.getColumnStr());
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 右斜め上
        r = position.getDispRow();
        c = position.getColumn();
        turnCellsArr.clear();

        for (int i = r - 1; i >= 0; i--) {
            c ++;
            if (c > 7) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 右
        r = position.getDispRow();
        c = position.getColumn();
        turnCellsArr.clear();

        for (int i = c + 1; i < 8; i++) {
            try {
                Position p = new Position(r, position.getColumnStrByIndex(i));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 右斜め下
        r = position.getDispRow();
        c = position.getColumn();
        turnCellsArr.clear();

        for (int i = r + 1; i < 8; i++) {
            c ++;
            if (c > 7) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 下
        r = position.getDispRow();
        c = position.getColumn();
        turnCellsArr.clear();

        for (int i = r + 1; i < 8; i++) {
            try {
                Position p = new Position(i, position.getColumnStr());
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 左斜め下
        r = position.getDispRow();
        c = position.getColumn();
        turnCellsArr.clear();

        for (int i = r + 1; i < 8 ; i++) {
            c --;
            if (c < 0) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 左
        r = position.getDispRow();
        c = position.getColumn();
        turnCellsArr.clear();

        for (int i = c - 1; i >= 0; i--) {
            try {
                Position p = new Position(r, position.getColumnStrByIndex(i));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 左斜め上
        r = position.getDispRow();
        c = position.getColumn();
        turnCellsArr.clear();

        for (int i = r - 1; i >= 0; i--) {
            c --;
            if (c < 0) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    turnCellsArr.add(p);
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    for ( Position tp : turnCellsArr ) {
                        turnOneStone(tp);
                    }
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }
    }

    public int tryPut ( Position position ) { 

        int turnCount    = 0; 
        int tmpTurnCount = 0; 
        int r = position.getDispRow();
        int c = position.getColumn();

        // 各方向をチェック
        // 上
        for (int i = r - 1; i > 0; i--) {
            try {
                Position p = new Position(i, position.getColumnStr());
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 右斜め上
        tmpTurnCount = 0; 
        r = position.getDispRow();
        c = position.getColumn();

        for (int i = r - 1; i >= 0; i--) {
            c ++;
            if (c > 7) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 右
        tmpTurnCount = 0; 
        r = position.getDispRow();
        c = position.getColumn();
        for (int i = c + 1; i < 8; i++) {
            try {
                Position p = new Position(r, position.getColumnStrByIndex(i));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 右斜め下
        tmpTurnCount = 0; 
        r = position.getDispRow();
        c = position.getColumn();

        for (int i = r + 1; i < 8; i++) {
            c ++;
            if (c > 7) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 下
        tmpTurnCount = 0; 
        r = position.getDispRow();
        c = position.getColumn();
        for (int i = r + 1; i < 8; i++) {
            try {
                Position p = new Position(i, position.getColumnStr());
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 左斜め下
        tmpTurnCount = 0; 
        r = position.getDispRow();
        c = position.getColumn();

        for (int i = r + 1; i < 8; i++) {
            c --;
            if (c < 0) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 左
        tmpTurnCount = 0; 
        r = position.getDispRow();
        c = position.getColumn();
        for (int i = c - 1; i >= 0; i--) {
            try {
                Position p = new Position(r, position.getColumnStrByIndex(i));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        // 左斜め上
        tmpTurnCount = 0; 
        r = position.getDispRow();
        c = position.getColumn();

        for (int i = r - 1; i >= 0; i--) {
            c --;
            if (c < 0) {
                break;
            }

            try {
                Position p = new Position(i, position.getColumnStrByIndex(c));
                if ( (turn.isBlackTurn() && isWhite(p)) || (turn.isWhiteTurn() && isBlack(p)) ) {
                    tmpTurnCount ++;
                } else if ( (turn.isBlackTurn() && isBlack(p)) || (turn.isWhiteTurn() && isWhite(p)) ) {
                    turnCount += tmpTurnCount;
                    break;
                } else if ( isEmpty(p) ) {
                    break;
                }
            } catch ( Exception e ) {
            }
        }

        return turnCount;
    }

    public ArrayList getOthelloBoardData () {
        return board;
    }

}
