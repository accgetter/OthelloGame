// オセロボード上の位置を示す為のクラス 
import java.util.*;
import java.lang.Exception;

public class Position {

    private int rowIndex;
    private int rowDisp;
    private int columnIndex;

    private String columnDisp;

    private final static String [] colMap = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public Position ( int pRow, String pColumn ) throws Exception { 

        rowIndex    = pRow -1; 
        rowDisp     = pRow; 
        columnIndex = Arrays.binarySearch(colMap, pColumn);
        columnDisp  = pColumn;

        if ( (pRow > 8 || pRow < 0) || columnIndex < 0 ) {
            throw new Exception("位置の指定が不正です。もう一度石を置く位置を指定してください。");
        }
    }

    public Position ( int pRowIndex, int pColumnIndex ) throws Exception { 

        rowIndex    = pRowIndex; 
        rowDisp     = pRowIndex + 1; 
        columnIndex = pColumnIndex;
        columnDisp  = colMap[pColumnIndex];

        if ( (pRowIndex > 7 || pRowIndex < 0) || (pColumnIndex < 0 || pColumnIndex > 7) ) {
            throw new Exception("位置の指定が不正です。もう一度石を置く位置を指定してください。");
        }
    }

    public int    getRow       () { return rowIndex; }
    public int    getDispRow   () { return rowDisp; }
    public int    getColumn    () { return columnIndex; }
    public String getColumnStr () { return columnDisp; }

    public String getColumnStrByIndex ( int i ) {
        return colMap[i];
    }

}
